package org.zutjmx.java.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private static String url = "jdbc:mariadb://192.168.1.136:3306/jakartaee9_curso?serverTimezone=America/Mexico_City";
    private static String username = "root";
    private static String password = "sistemas";
    private static Connection connection;

    public static Connection getConnection() throws SQLException {
        if (connection == null) {
            connection = DriverManager.getConnection(url,username,password);
        }
        return connection;
    }

}
