/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Usuario
 */
public class ResourceManagerTest {

    public ResourceManagerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getConeccion method, of class ResourceManager.
     */
    @Test
    public void testGetConeccion() throws SQLException {
        System.out.println("getConeccion");

        Connection result = ResourceManager.getConeccion();
        result.close();

    }

    @Test
    public void testClose() throws SQLException {
        System.out.println("Close connection");

        Connection result = ResourceManager.getConeccion();
        ResourceManager.closeConnection(result);

    }

    @Test
    public void testCloseRs() throws SQLException {
        System.out.println("Close All");
        Connection conection = ResourceManager.getConeccion();

        PreparedStatement prest = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM pro.cuenta WHERE Num_Documento = ?;";
        prest = conection.prepareStatement(sql);
        prest.setString(1, "98935652145");
        rs = prest.executeQuery();

        if (!rs.wasNull()) {
            while (rs.next()) { 
                System.out.println("Numero de Documento: " + rs.getString(2));
                System.out.println("-------------------------------");
            }
        }

        ResourceManager.closeResultSet(rs);
        ResourceManager.closePreparedStatement(prest);
        ResourceManager.closeConnection(conection);
    }

}
