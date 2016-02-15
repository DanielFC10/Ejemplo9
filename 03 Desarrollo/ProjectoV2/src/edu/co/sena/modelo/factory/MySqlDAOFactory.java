/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.modelo.factory;

import edu.co.sena.modelo.dao.CuentaDAO;
import edu.co.sena.modelo.dao.EquipoDAO;
import edu.co.sena.modelo.dao.PropietarioDAO;
import edu.co.sena.modelo.dao.RegistroDAO;
import edu.co.sena.modelo.dao.RegistroEquipoDAO;
import edu.co.sena.modelo.dao.UsuarioDAO;
import edu.co.sena.modelo.dao.mysql.CuentaDAOImpl;
import edu.co.sena.modelo.dao.mysql.EquipoDAOImpl;
import edu.co.sena.modelo.dao.mysql.PropietarioDAOImpl;
import edu.co.sena.modelo.dao.mysql.RegistroDAOImpl;
import edu.co.sena.modelo.dao.mysql.RegistroEquipoDAOImpl;
import edu.co.sena.modelo.dao.mysql.UsuarioDAOImpl;

/**
 *
 * @author Juan
 */
public class MySqlDAOFactory extends DAOAbstractFactory{

    @Override
    public CuentaDAO createCuentaDAO() {
        return  new CuentaDAOImpl();
    }

    @Override
    public EquipoDAO createEquipoDAO() {
        return new EquipoDAOImpl();
    }

    @Override
    public PropietarioDAO createPropietarioDAO() {
        return new PropietarioDAOImpl();
    }

    @Override
    public RegistroDAO createRegistroDAO() {
        return new RegistroDAOImpl();
    }

    @Override
    public RegistroEquipoDAO createRegistroEquipoDAO() {
        return new RegistroEquipoDAOImpl();
    }

    @Override
    public UsuarioDAO createUsuarioDAO() {
        return new UsuarioDAOImpl();
    }
    
}
