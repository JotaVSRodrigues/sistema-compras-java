package org.example.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {
    // configurações do MySQL
    private static final String URL = "jdbc:mysql://localhost:3306/creditCard";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "admin";

    // Driver do MySQL --> Não estou usando o Driver por enquanto
    // private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    // Conexão com o banco
    public static Connection getConnection() throws SQLException {
        Connection connection = null;
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
