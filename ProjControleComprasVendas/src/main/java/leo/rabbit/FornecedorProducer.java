package leo.rabbit;

import leo.model.Fornecedor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class FornecedorProducer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Qualifier("fornecedorQueue")
    @Autowired
    private Queue queue;

    public void send(Fornecedor fornecedor){
        rabbitTemplate.convertAndSend(this.queue.getName(), fornecedor);
    }
}
