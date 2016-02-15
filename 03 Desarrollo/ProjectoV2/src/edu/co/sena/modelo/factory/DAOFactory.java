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

/**
 *
 * @author Juan
 */
public interface DAOFactory {

    public CuentaDAO createCuentaDAO();

    public EquipoDAO createEquipoDAO();

    public PropietarioDAO createPropietarioDAO();

    public RegistroDAO createRegistroDAO();

    public RegistroEquipoDAO createRegistroEquipoDAO();

    public UsuarioDAO createUsuarioDAO();
}
