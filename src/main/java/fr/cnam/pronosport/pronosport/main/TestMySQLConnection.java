package fr.cnam.pronosport.pronosport.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class TestMySQLConnection {

    public static Connection getConnection() throws SQLException, SQLException {
        String url = "jdbc:mysql://localhost:3306/pronosport?useSSL=false&allowPublicKeyRetrieval=true";
        String user = "root";
        String password = "java123";
        return DriverManager.getConnection(url, user, password);
    }
        }



