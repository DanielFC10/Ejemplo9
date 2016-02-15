/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.modelo.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import edu.co.sena.modelo.dao.UsuarioDAO;
import edu.co.sena.modelo.dto.Usuario;
import edu.co.sena.modelo.dto.UsuarioPK;
import javax.swing.JOptionPane;

/**
 *
 * @author Juan
 */
public class UsuarioDAOImpl implements UsuarioDAO {

    private Connection conexion;

    private final String SQL_SELECT = "SELECT * FROM " + getTableName() + "";

    private final String SQL_INSERT = "INSERT INTO " + getTableName() + "\n"
            + "(contrasena,\n"
            + "rol,\n"
            + "Cuenta_Tipo_Documento,\n"
            + "Cuenta_Num_Documento,\n"
            + "correoDeRecuperacion)\n"
            + "VALUES\n"
            + "(?,?,?,?,?)";

    private final String SQL_UPDATE = "UPDATE " + getTableName() + "\n"
            + "SET\n"
            + "contrasena = ?,\n"
            + "rol = ?,\n"
            + "correoDeRecuperacion = ?\n"
            + "WHERE Cuenta_Tipo_Documento = ? AND Cuenta_Num_Documento = ?";

    private final String SQL_UPDATEPK = "UPDATE " + getTableName() + "\n"
            + "SET\n"
            + "Cuenta_Tipo_Documento = ?,\n"
            + "Cuenta_Num_Documento = ?\n"
            + "WHERE Cuenta_Tipo_Documento = ? AND Cuenta_Num_Documento = ?";

    private final String SQL_DELETE = "DELETE FROM " + getTableName() + "\n"
            + "WHERE Cuenta_Tipo_Documento = ? AND Cuenta_Num_Documento = ?";

    private final String SQL_SELECT_COUNT = "SELECT count(*) FROM " + getTableName() + "";

    public String getTableName() {
        return "PRO.USUARIO";
    }

    @Override
    public List<Usuario> findAll() {

        final boolean estaConectado = (conexion != null);
        Connection conex = null;
        PreparedStatement prstmt = null;
        ResultSet rs = null;
        List<Usuario> lt = new ArrayList<>();

        try {
            if (estaConectado) {
                conex = conexion;
            } else {
                conex = ResourceManager.getConeccion();
            }
            final String SQL = SQL_SELECT;

            JOptionPane.showMessageDialog(null, "Se ejecuto " + SQL);
            prstmt = conex.prepareStatement(SQL);
            rs = prstmt.executeQuery();

            if (!rs.wasNull()) {
                while (rs.next()) {
                    Usuario us = new Usuario();
                    us.setContrasenia(rs.getString(1));
                    us.setRol(rs.getString(2));
                    us.setCuentaTipoDocumento(rs.getString(3));
                    us.setCuentaNumeroDocumento(rs.getString(4));
                    us.setCorreoRecuperacion(rs.getString(5));
                    lt.add(us);
                }
            }

        } catch (Exception e) {
            System.out.println("Error dentro del FindAll: " + e.getMessage());
        } finally {
            ResourceManager.closeResultSet(rs);
            ResourceManager.closePreparedStatement(prstmt);
            if (!estaConectado) {
                ResourceManager.closeConnection(conex);
            }
        }
        return lt;
    }

    @Override
    public void insert(Usuario dto) {
        final boolean estaConectado = (conexion != null);
        Connection conex = null;
        PreparedStatement prstmt = null;
        int rs;
        try {
            if (estaConectado) {
                conex = conexion;
            } else {
                conex = ResourceManager.getConeccion();
            }
            final String SQL = SQL_INSERT;
            int indice = 1;
            JOptionPane.showMessageDialog(null, "Se ejecuto " + SQL);
            prstmt = conex.prepareStatement(SQL);
            prstmt.setString(indice++, dto.getContrasenia());
            prstmt.setString(indice++, dto.getRol());
            prstmt.setString(indice++, dto.getCuentaTipoDocumento());
            prstmt.setString(indice++, dto.getCuentaNumeroDocumento());
            prstmt.setString(indice++, dto.getCorreoRecuperacion());

            rs = prstmt.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error dentro del Insert: " + e.getMessage());
        } finally {
            ResourceManager.closePreparedStatement(prstmt);
            if (!estaConectado) {
                ResourceManager.closeConnection(conex);
            }
        }
    }

    @Override
    public void update(UsuarioPK llaveDto, Usuario dto) {
        final boolean estaConectado = (conexion != null);
        Connection conex = null;
        PreparedStatement prstmt = null;
        int rs;

        try {
            if (estaConectado) {
                conex = conexion;
            } else {
                conex = ResourceManager.getConeccion();
            }
            final String SQL = SQL_UPDATE;
            int indice = 1;
            JOptionPane.showMessageDialog(null, "Se ejecuto " + SQL);
            prstmt = conex.prepareStatement(SQL);

            prstmt.setString(indice++, dto.getContrasenia());
            prstmt.setString(indice++, dto.getRol());
            prstmt.setString(indice++, dto.getCorreoRecuperacion());

            prstmt.setString(indice++, llaveDto.getCuentaTipoDocumento());
            prstmt.setString(indice++, llaveDto.getCuentaNumeroDocumento());

            rs = prstmt.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error dentro del Update: " + e.getMessage());
        } finally {
            ResourceManager.closePreparedStatement(prstmt);
            if (!estaConectado) {
                ResourceManager.closeConnection(conex);
            }
        }

    }

    @Override
    public void updatePk(UsuarioPK llaveVieja, UsuarioPK llaveNueva) {
        final boolean estaConectado = (conexion != null);
        Connection conex = null;
        PreparedStatement prstmt = null;
        int rs;

        try {
            if (estaConectado) {
                conex = conexion;
            } else {
                conex = ResourceManager.getConeccion();
            }
            final String SQL = SQL_UPDATEPK;
            int indice = 1;
            JOptionPane.showMessageDialog(null, "Se ejecuto " + SQL);
            prstmt = conex.prepareStatement(SQL);

            prstmt.setString(indice++, llaveNueva.getCuentaTipoDocumento());
            prstmt.setString(indice++, llaveNueva.getCuentaNumeroDocumento());
            prstmt.setString(indice++, llaveVieja.getCuentaTipoDocumento());
            prstmt.setString(indice++, llaveVieja.getCuentaNumeroDocumento());

            rs = prstmt.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error dentro del UpdatePK: " + e.getMessage());
        } finally {
            ResourceManager.closePreparedStatement(prstmt);
            if (!estaConectado) {
                ResourceManager.closeConnection(conex);
            }
        }
    }

    @Override
    public void delete(UsuarioPK dto) {
        final boolean estaConectado = (conexion != null);
        Connection conex = null;
        PreparedStatement prstmt = null;
        int rs;
        try {
            if (estaConectado) {
                conex = conexion;
            } else {
                conex = ResourceManager.getConeccion();
            }
            final String SQL = SQL_DELETE;
            int indice = 1;
            JOptionPane.showMessageDialog(null, "Se ejecuto " + SQL);
            prstmt = conex.prepareStatement(SQL);
            prstmt.setString(indice++, dto.getCuentaTipoDocumento());
            prstmt.setString(indice++, dto.getCuentaTipoDocumento());

            rs = prstmt.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error dentro del Delete: " + e.getMessage());
        } finally {
            ResourceManager.closePreparedStatement(prstmt);
            if (!estaConectado) {
                ResourceManager.closeConnection(conex);
            }
        }
    }

    @Override
    public List<Usuario> findByPK(UsuarioPK dto) {
        final boolean estaConectado = (conexion != null);
        Connection conex = null;
        PreparedStatement prstmt = null;
        ResultSet rs = null;
        List<Usuario> lt = new ArrayList();

        try {
            if (estaConectado) {
                conex = conexion;
            } else {
                conex = ResourceManager.getConeccion();
            }
            final String SQL = SQL_SELECT + " WHERE Cuenta_Tipo_Documento = ? AND Cuenta_Num_Documento = ?";

            JOptionPane.showMessageDialog(null, "Se ejecuto " + SQL);
            prstmt = conex.prepareStatement(SQL);
            int index = 1;
            prstmt.setString(index++, dto.getCuentaTipoDocumento());
            prstmt.setString(index++, dto.getCuentaNumeroDocumento());
            rs = prstmt.executeQuery();

            if (!rs.wasNull()) {
                while (rs.next()) {
                    Usuario us = new Usuario();
                    us.setContrasenia(rs.getString(1));
                    us.setRol(rs.getString(2));
                    us.setCuentaTipoDocumento(rs.getString(3));
                    us.setCuentaNumeroDocumento(rs.getString(4));
                    us.setCorreoRecuperacion(rs.getString(5));
                    lt.add(us);

                }
            }

        } catch (Exception e) {
            System.out.println("Error dentro del FindByPK: " + e.getMessage());
        } finally {
            ResourceManager.closeResultSet(rs);
            ResourceManager.closePreparedStatement(prstmt);
            if (!estaConectado) {
                ResourceManager.closeConnection(conex);
            }
        }
        return lt;

    }

    @Override
    public int count() {
        final boolean estaConectado = (conexion != null);
        Connection conex = null;
        PreparedStatement prstmt = null;
        ResultSet rs = null;
        Integer rowsCount = 0;

        try {
            if (estaConectado) {
                conex = conexion;
            } else {
                conex = ResourceManager.getConeccion();
            }
            final String SQL = SQL_SELECT_COUNT;

            JOptionPane.showMessageDialog(null, "Se ejecuto " + SQL);
            prstmt = conex.prepareStatement(SQL);
            rs = prstmt.executeQuery();
            if (!rs.wasNull()) {
                while (rs.next()) {
                    rowsCount = rs.getInt(1);

                }

            }

        } catch (Exception e) {
            System.out.println("Error dentro del SelectCount: " + e.getMessage());
        } finally {
            ResourceManager.closeResultSet(rs);
            ResourceManager.closePreparedStatement(prstmt);
            if (!estaConectado) {
                ResourceManager.closeConnection(conex);
            }
        }
        return rowsCount;

    }

}
