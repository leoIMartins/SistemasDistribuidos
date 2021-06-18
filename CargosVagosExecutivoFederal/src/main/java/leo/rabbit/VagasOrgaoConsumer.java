package leo.rabbit;

import leo.model.VagasOrgao;
import leo.service.VagasOrgaoService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class VagasOrgaoConsumer {

    @Autowired
    private VagasOrgaoService vagasOrgaoService;

    @RabbitListener(queues = {"${queue.vagasorgao.name}"})
    public void receive (@Payload VagasOrgao vagasOrgao){
        System.out.println("Id: "+ vagasOrgao.get_id() + "\nMês: " + vagasOrgao.getNOME_MES()
        + "\nOrgão: " + vagasOrgao.getORGAO() + "\nNome do orgão: " + vagasOrgao.getNOME_ORGAO()
                + "\nSigla: " + vagasOrgao.getSIGLA_ORGAO() + "\nVagas Aprovadas: " + vagasOrgao.getAPROVADA()
        + "\nVagas Distribuídas: " + vagasOrgao.getDISTRIBUIDA() + "\nVagas Ocupadas: " + vagasOrgao.getOCUPADA()
                + "\nVagas Disponíveis: " + vagasOrgao.getVAGAS());
        System.out.println("-------------------------");
        vagasOrgaoService.save(vagasOrgao);
    }
}
