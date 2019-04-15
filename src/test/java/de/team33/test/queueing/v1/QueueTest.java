package de.team33.test.queueing.v1;

import com.google.gson.Gson;
import de.team33.libs.queueing.v1.Queue;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.stream.Stream;

public class QueueTest {

    private long produced = 0;
    private long consumed = 0;

    @Test
    public void test() throws InterruptedException, IOException {
        final Queue queue = new Queue(getClass().getCanonicalName());
        final Thread producer = new Thread(new Producer(queue));
        final Thread consumer = new Thread(new Consumer(queue));
        consumer.start();
        producer.start();
        producer.join();
        consumer.join();
        Assert.assertEquals(produced, consumed);
    }

    private static class Message {

        private String toJson() {
            return new Gson().toJson(this);
        }
    }

    private class Consumer implements Runnable {

        private Consumer(final Queue queue) {
        }

        @Override
        public void run() {
            throw new UnsupportedOperationException("not yet implemented");
        }
    }

    private class Producer implements Runnable {

        private final Queue queue;

        private Producer(final Queue queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            Stream.generate(Message::new).limit(100).map(Message::toJson).forEach(message -> {
                queue.put(message);
            });
            throw new UnsupportedOperationException("not yet implemented");
        }
    }
}