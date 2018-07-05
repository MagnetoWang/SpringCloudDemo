package start;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import start.file.StorageService;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import start.rabbitmq.Receiver;


@SpringBootApplication
@EnableScheduling
@EnableAutoConfiguration
public class Application {
    private static final Logger logger = LoggerFactory.getLogger(Application.class);


    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class);
    }

    @Bean
    CommandLineRunner init(StorageService storageService) {
        return (args) -> {
            storageService.deleteAll();
            storageService.init();
        };
    }


    /**
     * Register the listener and send a message
     * Spring AMQP’s RabbitTemplate provides everything you need to send and receive messages with RabbitMQ.
     * Specifically, you need to configure:
     *
     * A message listener container
     * Declare the queue, the exchange, and the binding between them
     * A component to send some messages to test the listener
     *
     *
     *Spring Boot automatically creates a connection factory and a RabbitTemplate,
     * reducing the amount of code you have to write.
     *
     *
     *
     */

    public static final String topicExchangeName = "spring-boot-exchange";

    public static final String queueName = "spring-boot";

    @Bean
    Queue queue() {
        logger.info("----------Queue-------   ");

        return new Queue(queueName, false);
    }

    @Bean
    // send it to a default exchange with a default routing key.
    //send it to a specific exchange with a specific routing key
    TopicExchange exchange() {
        logger.info("----------TopicExchange-------   ");

        return new TopicExchange(topicExchangeName);
    }

    @Bean
    Binding binding(Queue queue, TopicExchange exchange) {
        logger.info("----------binding-------   ");
        return BindingBuilder.bind(queue).to(exchange).with("foo.bar.#");
    }


    /**
     * You’ll use RabbitTemplate to send messages,
     * and you will register a Receiver with the message listener container to receive messages.
     * The connection factory drives both, allowing them to connect to the RabbitMQ server.
     * @param connectionFactory
     * @param listenerAdapter
     * @return
     */
    @Bean
    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
                                             MessageListenerAdapter listenerAdapter) {
        logger.info("----------SimpleMessageListenerContainer-------   ");
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(queueName);
        container.setMessageListener(listenerAdapter);
        return container;
    }
    /**
     * The bean defined in the listenerAdapter() method is registered as a message listener in the container defined in container().
     * It will listen for messages on the "spring-boot" queue. Because the Receiver class is a POJO, it needs to be wrapped in the MessageListenerAdapter,
     * where you specify it to invoke receiveMessage.
     */
    @Bean
    MessageListenerAdapter listenerAdapter(Receiver receiver) {
        logger.info("----------listenerAdapter-------   ");
        return new MessageListenerAdapter(receiver, "receiveMessage");
    }


}
