package start.rabbitmq;

import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import start.file.FileUploadController;

/**
 * With any messaging-based application, you need to create a receiver that will respond to published messages.
 *
 * The Receiver is a simple POJO that defines a method for receiving messages.
 * When you register it to receive messages, you can name it anything you want.
 *
 *
 * For convenience, this POJO also has a CountDownLatch.
 * This allows it to signal that the message is received.
 * This is something you are not likely to implement in a production application.
 *
 *
 */
@Component
public class Receiver {
    private static final Logger logger = LoggerFactory.getLogger(Receiver.class);

    private CountDownLatch latch = new CountDownLatch(5);

    public void receiveMessage(String message) {
        logger.info("Received <" + message + ">");
        latch.countDown();
        logger.info("------------over------------");
    }

    public CountDownLatch getLatch() {
        return latch;
    }

}