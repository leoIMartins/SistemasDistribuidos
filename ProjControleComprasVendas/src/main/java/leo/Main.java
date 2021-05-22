package leo;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Main {

    @Value("${queue.cliente.name}")
    private String clienteQueue;

    @Value("${queue.venda.name}")
    private String vendaQueue;

    @Value("${queue.produto.name}")
    private String produtoQueue;

    @Value("${queue.compra.name}")
    private String compraQueue;

    @Value("${queue.fornecedor.name}")
    private String fornecedorQueue;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public Queue clienteQueue(){
        return new Queue(clienteQueue, true);
    }

    @Bean
    public Queue vendaQueue(){
        return new Queue(vendaQueue, true);
    }

    @Bean
    public Queue produtoQueue(){
        return new Queue(produtoQueue, true);
    }

    @Bean
    public Queue compraQueue(){ return new Queue(compraQueue, true); }

    @Bean
    public Queue fornecedorQueue(){
        return new Queue(fornecedorQueue, true);
    }
}
