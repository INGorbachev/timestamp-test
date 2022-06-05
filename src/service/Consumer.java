package service;

import util.ConnectionManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.concurrent.BlockingQueue;

public record Consumer(BlockingQueue<Timestamp> blockingQueue) implements Runnable {

    @Override
    public void run() {

        while (true) {
            var sql = """
                    INSERT INTO data (data)
                    VALUES (?);
                    """;
            try (Connection connection = ConnectionManager.open();
                 var preparedStatement = connection.prepareStatement(sql)) {
                var value = String.valueOf(blockingQueue.take());
                preparedStatement.setString(1, value);
                preparedStatement.executeUpdate();
            } catch (SQLException | InterruptedException e) {
                e.printStackTrace();

            }
        }
    }
}

