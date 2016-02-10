/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao.mysql;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

/**
 *
 * @author Usuario
 */
public class ResouceMananger {

    private static String JDBC_URL = "jdbc:mysql://localhost:3306/Pro";

    private static String JDBC_USER = "root";
    private static String JDBC_PASSWORD = "123456789";

    public static Connection getConeccion() {

        Connection conexion = null;
        try {
            conexion = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
        } catch (Exception e) {
            System.err.println("No hay conexion" + e.getMessage());

        }
        return conexion;
    }

}
