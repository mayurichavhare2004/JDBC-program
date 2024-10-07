package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class PersonDetailsJDBC {
    private static final String URL = "jdbc:mysql://localhost:3306/my_database";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM person";
            ResultSet resultSet = statement.executeQuery(query);

            // Adjusted format specifiers
            System.out.printf("%-5s %-20s %-10s%n", "PID", "Name", "Gender");
            System.out.println("------------------------------------");

            while (resultSet.next()) {
                int pid = resultSet.getInt("PID");
                String name = resultSet.getString("name");
                String gender = resultSet.getString("gender");
                // Corrected format specifiers
                System.out.printf("%-5d %-20s %-10s%n", pid, name, gender);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


