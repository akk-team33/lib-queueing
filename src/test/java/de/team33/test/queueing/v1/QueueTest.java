package de.team33.test.queueing.v1;

import de.team33.libs.queueing.v1.Queue;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

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

    private class Producer implements Runnable {

        private Producer(final Queue queue) {
        }

        @Override
        public void run() {
            throw new UnsupportedOperationException("not yet implemented");
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
}