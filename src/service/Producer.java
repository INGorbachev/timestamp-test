package service;

import java.sql.Timestamp;
import java.util.concurrent.BlockingQueue;

public record Producer(BlockingQueue<Timestamp> blockingQueue) implements Runnable {


    @Override
    public void run() {
        while (true) {
            var timestamp = new Timestamp(System.currentTimeMillis());
            blockingQueue.add(timestamp);

            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
