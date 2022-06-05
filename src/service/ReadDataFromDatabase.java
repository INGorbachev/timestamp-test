package service;

import util.ConnectionManager;

import java.sql.SQLException;

public class ReadDataFromDatabase {

    public static void printData() throws SQLException {

        var sql = """
                SELECT * 
                FROM data;                    
                """;

        try (var connection = ConnectionManager.open();
             var preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setFetchSize(50);
            preparedStatement.setQueryTimeout(5);
            var resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getString("data"));
            }
        }
    }
}
