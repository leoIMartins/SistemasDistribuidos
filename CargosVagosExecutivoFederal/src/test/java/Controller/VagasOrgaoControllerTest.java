package Controller;

import leo.Main;
import leo.model.VagasOrgao;
import leo.service.VagasOrgaoService;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Main.class)
@WebAppConfiguration
public class VagasOrgaoControllerTest {

    @Autowired
    private VagasOrgaoService vagasOrgaoService;

    @Test
    public void save() throws Exception {
        long qtd = 1000;

        vagasOrgaoService.deleteAll();

        for ( int i = 1 ; i <= qtd ; i++){
            vagasOrgaoService.sendVagasOrgaoRabbit(new VagasOrgao(Integer.toString(i), "Jun 2021", i,
                    "Teste " + i, "SIGLA " + i, i+100, i+50, i + 25));
        }

        Thread.sleep(20000);
        List<VagasOrgao> lst = vagasOrgaoService.findAll();

        System.out.println("Quantidade:" + lst.size());
        Assert.assertEquals(lst.size(), qtd);
    }
}
