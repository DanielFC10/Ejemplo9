/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.modelo.dao;

import java.util.List;
import edu.co.sena.modelo.dto.Usuario;
import edu.co.sena.modelo.dto.UsuarioPK;

/**
 *
 * @author Juan
 */
public interface UsuarioDAO {

    public List<Usuario> findAll();

    public void insert(Usuario dto);

    public void update(UsuarioPK llaveDto, Usuario dto);

    public void updatePk(UsuarioPK llaveVieja, UsuarioPK llaveNueva);

    public void delete(UsuarioPK dto);

    public List<Usuario> findByPK(UsuarioPK dto);
    
    public int count();

}
