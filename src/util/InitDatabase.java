package util;

import java.sql.SQLException;

public class InitDatabase {


    public static void init() throws SQLException {
        String createDatabase = """
                CREATE DATABASE IF NOT EXISTS timestamp
                """;
        String createTable = """
                CREATE TABLE IF NOT EXISTS data (
                    id BIGINT AUTO_INCREMENT PRIMARY KEY,
                    data VARCHAR(64) NOT NULL 
                )
                                    
                """;

        try (var connection = ConnectionManager.open();
             var statement = connection.createStatement()) {
            statement.execute(createDatabase);
            statement.execute(createTable);
        }

    }
}
