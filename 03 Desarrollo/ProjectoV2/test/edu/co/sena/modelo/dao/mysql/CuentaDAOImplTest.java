/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.modelo.dao.mysql;

import java.util.Date;
import java.util.List;
import edu.co.sena.modelo.dao.CuentaDAO;
import edu.co.sena.modelo.dto.Cuenta;
import edu.co.sena.modelo.dto.CuentaPK;
import edu.co.sena.modelo.factory.DAOAbstractFactory;
import edu.co.sena.modelo.factory.DAOFactory;
import edu.co.sena.modelo.factory.MySqlDAOFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Juan
 */
public class CuentaDAOImplTest {

    public CuentaDAOImplTest() {
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

    @Test
    public void testFindAll() {
        System.out.println("FindAll");
        DAOFactory fDAO = MySqlDAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        CuentaDAO instance = fDAO.createCuentaDAO();
        
        List<Cuenta> result = instance.findAll();
        for (Cuenta cuentas : result) {
            System.out.println(cuentas.toString());
        }
    }

    @Test
    public void testInsert() {
        Date fecha = new Date();
        System.out.println("Insert Cuenta");
        Cuenta cu = new Cuenta();
        Byte fotoT = new Byte("4");

        cu.setTipoDocumento("CC");
        cu.setNumeroDocumento("12345678910");
        cu.setCargo("Aprendiz");
        cu.setFechaTerminacion(fecha);
        cu.setFoto(fotoT);
        cu.setEstado(true);
        cu.setPrimerNombre("Joaquin");
        cu.setSegundoNombre("Joaquin");
        cu.setPrimerApellido("Chapo");
        cu.setSegundoApellido("Chapo");
        
        DAOFactory fDAO = MySqlDAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        CuentaDAO instance = fDAO.createCuentaDAO();

        instance.insert(cu);
    }

    @Test
    public void testUpdate() {

        System.out.println("Update Cuenta");
        CuentaPK llaveVieja = new CuentaPK("CC", "12345678910");
        Cuenta nuevaCuenta = new Cuenta();
        Date fecha = new Date();
        Byte fotoT = new Byte("5");

        nuevaCuenta.setCargo("Aprendiz");
        nuevaCuenta.setFechaTerminacion(fecha);
        nuevaCuenta.setFoto(fotoT);
        nuevaCuenta.setEstado(true);
        nuevaCuenta.setPrimerNombre("Duvanito");
        nuevaCuenta.setSegundoNombre("CHepe");
        nuevaCuenta.setPrimerApellido("Capo");
        nuevaCuenta.setSegundoApellido("SOsa");

        DAOFactory fDAO = MySqlDAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        CuentaDAO instance = fDAO.createCuentaDAO();
        instance.update(llaveVieja, nuevaCuenta);

    }

    @Test
    public void testUpdatePK() {

        System.out.println("UpdatePK Cuenta");

        CuentaPK llaveVieja = new CuentaPK("CC", "12345678910");
        CuentaPK llaveNueva = new CuentaPK("CC", "55554444");

        DAOFactory fDAO = MySqlDAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        CuentaDAO instance = fDAO.createCuentaDAO();
        instance.updatePk(llaveVieja, llaveNueva);

    }

    @Test
    public void testDelete() {
        System.out.println("Delete Cuenta");
        CuentaPK cu = new CuentaPK("CC", "5555");

        DAOFactory fDAO = MySqlDAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        CuentaDAO instance = fDAO.createCuentaDAO();

        instance.delete(cu);
    }

    @Test
    public void testFindByPK() {
        System.out.println("FindByPK");
        DAOFactory fDAO = MySqlDAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        CuentaDAO instance = fDAO.createCuentaDAO();
        CuentaPK cu = new CuentaPK("CC", "1251452354");
        
        List<Cuenta> result = instance.findByPK(cu);
        
        for (Cuenta cuentas : result) {
            System.out.println(cuentas.toString());
        }
    }

    @Test
    public void testSelectCount() {
        System.out.println("SelectCount");
        DAOFactory fDAO = MySqlDAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        CuentaDAO instance = fDAO.createCuentaDAO();

        System.out.println(instance.count());

    }

}
