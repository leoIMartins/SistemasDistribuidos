package leo.rabbit;

import leo.model.Compra;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CompraProducer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Qualifier("compraQueue")
    @Autowired
    private Queue queue;

    public void send(Compra compra){
        rabbitTemplate.convertAndSend(this.queue.getName(), compra);
    }
}
