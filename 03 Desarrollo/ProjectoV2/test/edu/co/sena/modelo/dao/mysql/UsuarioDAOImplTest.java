/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.modelo.dao.mysql;

import java.util.List;
import edu.co.sena.modelo.dao.UsuarioDAO;
import edu.co.sena.modelo.dto.Usuario;
import edu.co.sena.modelo.dto.UsuarioPK;
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
public class UsuarioDAOImplTest {

    public UsuarioDAOImplTest() {
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
     * Test of findAll method, of class UsuarioDAOImpl.
     */
    @Test
    public void testFindAll() {
        System.out.println("FindAll");
        DAOFactory fDAO = MySqlDAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        UsuarioDAO instance = fDAO.createUsuarioDAO();
        List<Usuario> result = instance.findAll();
        for (Usuario usuarios : result) {
            System.out.println(usuarios.toString());
        }
    }

    @Test
    public void testInsert() {
        System.out.println("Insert Usuario");
        Usuario us = new Usuario();

        us.setContrasenia("132456");
        us.setRol("Estudent");
        us.setCuentaTipoDocumento("CC");
        us.setCuentaNumeroDocumento("12345678910");
        us.setCorreoRecuperacion("chicasexy@pincho.com");

        DAOFactory fDAO = MySqlDAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        UsuarioDAO instance = fDAO.createUsuarioDAO();

        instance.insert(us);
    }

    @Test
    public void testUpdate() {

        System.out.println("Update Usuario");
        UsuarioPK llaveVieja = new UsuarioPK("CC", "55554444");
        Usuario nuevoUsuario = new Usuario();

        nuevoUsuario.setContrasenia("132");
        nuevoUsuario.setRol("Estudent");
        nuevoUsuario.setCorreoRecuperacion("Hotmail");

        DAOFactory fDAO = MySqlDAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        UsuarioDAO instance = fDAO.createUsuarioDAO();
        instance.update(llaveVieja, nuevoUsuario);

    }

    @Test
    public void testUpdatePK() {

        System.out.println("UpdatePK Usuario");

        UsuarioPK llaveVieja = new UsuarioPK("CC", "1001244511");
        UsuarioPK llaveNueva = new UsuarioPK("TI", "12345");

        DAOFactory fDAO = MySqlDAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        UsuarioDAO instance = fDAO.createUsuarioDAO();
        instance.updatePk(llaveVieja, llaveNueva);

    }

    @Test
    public void testDelete() {
        System.out.println("Delete Usuario");
        UsuarioPK us = new UsuarioPK("CC", "1893565214");

        DAOFactory fDAO = MySqlDAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        UsuarioDAO instance = fDAO.createUsuarioDAO();
        instance.delete(us);
    }

    @Test
    public void testFindByPK() {
        System.out.println("FindByPK");
        DAOFactory fDAO = MySqlDAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        UsuarioDAO instance = fDAO.createUsuarioDAO();
        UsuarioPK cPK = new UsuarioPK("CC", "1893565214");

        List<Usuario> result = instance.findByPK(cPK);
        for (Usuario usuarios : result) {
            System.out.println(usuarios.toString());
        }
    }
    
        @Test
    public void testSelectCount() {
        System.out.println("SelectCount");
        DAOFactory fDAO = MySqlDAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        UsuarioDAO instance = fDAO.createUsuarioDAO();

        System.out.println(instance.count());

    }

}
