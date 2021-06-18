package leo;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.bson.Document;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@SpringBootApplication
@EnableCaching
public class Main {

    @Value("${queue.vagasorgao.name}")
    private String vagasOrgaoQueue;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        try {
            MongoClient mongo = new MongoClient( "localhost" , 27017 );
            System.out.println("Connected to the database successfully");
            //Accessing the database
            MongoDatabase database = mongo.getDatabase("dbcargosvagos");
            MongoCollection dbcoll = database.getCollection("vagasOrgao");

            List vagasLista = new ArrayList<>();
            File myFile = new File("C:/Projetos Temporarios do Git/Java/LotOrgao_DistOcupVagas_202105.xlsx");
            FileInputStream fis = new FileInputStream(myFile);
            // Finds the workbook instance for XLSX file
            Workbook myWorkBook = new XSSFWorkbook(fis);
            // Return first sheet from the XLSX workbook
            Sheet mySheet = myWorkBook.getSheetAt(0);
            System.out.println(mySheet.getSheetName());
            String headerArr[] = new String[10];

            // Get iterator to all the rows in current sheet
            Iterator rowIterator = mySheet.iterator();
            Row headerRow = (Row) rowIterator.next();
            Iterator headerCellIterator = headerRow.cellIterator();
            int i= 0;
            while (headerCellIterator.hasNext()){
                Cell headerCell = (Cell) headerCellIterator.next();
                headerArr[i] = headerCell.toString();
                i++;
            }
            while (rowIterator.hasNext()) {
                Row row = (Row) rowIterator.next();
                Document vagas = new Document();
                i=0;
                // For each row, iterate through each columns
                Iterator cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    try {
                        Cell cell = (Cell) cellIterator.next();
                        if(cell.getCellType() == CellType.STRING)
                            vagas.put(headerArr[i],cell.getStringCellValue());
                        else
                            vagas.put(headerArr[i], (int)cell.getNumericCellValue());
                        i++;
                    }catch(Exception e){
                    }
                }
                vagasLista.add(vagas);
            }
            dbcoll.insertMany(vagasLista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Bean
    public Queue queue(){
        return new Queue(vagasOrgaoQueue, true);
    }
}
