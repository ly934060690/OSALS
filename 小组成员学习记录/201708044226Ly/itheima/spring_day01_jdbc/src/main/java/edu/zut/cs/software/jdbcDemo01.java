package edu.zut.cs.software;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class jdbcDemo01 {
    public static void main(String[] args) {
        Connection connection = new jdbcConnection().getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("select * from students");
            ResultSet resultSet = preparedStatement.executeQuery();
            int numColumns = resultSet.getMetaData().getColumnCount();
            while (resultSet.next()) {
                for(int i = 1; i <= numColumns; i++) {
                    System.out.print(resultSet.getString(i) + '\t');
                }
                System.out.println();
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
