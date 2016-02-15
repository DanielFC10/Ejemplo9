/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.modelo.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import edu.co.sena.modelo.dao.CuentaDAO;
import edu.co.sena.modelo.dto.Cuenta;
import edu.co.sena.modelo.dto.CuentaPK;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Juan
 */
public class CuentaDAOImpl implements CuentaDAO {

    private Connection conexion;

    private final String SQL_SELECT = "SELECT * FROM " + getTableName() + "";

    private final String SQL_INSERT = "INSERT INTO " + getTableName() + "\n"
            + "(Tipo_Documento,\n"
            + "Num_Documento,\n"
            + "cargo,\n"
            + "FECHA_TERMINACION,\n"
            + "Foto,\n"
            + "Estado,\n"
            + "p_Nombre,\n"
            + "s_Nombre,\n"
            + "p_Apellido,\n"
            + "a_Apellido)\n"
            + "VALUES\n"
            + "(?,?,?,?,?,?,?,?,?,?);";

    private final String SQL_UPDATE = "UPDATE " + getTableName() + "\n"
            + "SET\n"
            + "cargo = ?,\n"
            + "FECHA_TERMINACION = ?,\n"
            + "Foto = ?,\n"
            + "Estado = ?,\n"
            + "p_Nombre = ?,\n"
            + "s_Nombre = ?,\n"
            + "p_Apellido = ?,\n"
            + "a_Apellido = ?\n"
            + "WHERE Tipo_Documento = ? AND Num_Documento = ?";

    private final String SQL_UPDATEPK = "UPDATE " + getTableName() + "\n"
            + "SET\n"
            + "Tipo_Documento = ?,\n"
            + "Num_Documento = ?\n"
            + "WHERE Tipo_Documento = ? AND Num_Documento = ?;";

    private final String SQL_DELETE = "DELETE FROM " + getTableName() + "\n"
            + "WHERE Tipo_Documento = ? AND Num_Documento = ?;";

    private final String SQL_SELECT_COUNT = "SELECT count(*) FROM " + getTableName() + "";

    public String getTableName() {
        return "PRO.CUENTA";
    }

    @Override
    public List<Cuenta> findAll() {

        final boolean estaConectado = (conexion != null);
        Connection conex = null;
        PreparedStatement prstmt = null;
        ResultSet rs = null;
        List<Cuenta> lt = new ArrayList<>();

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
                    Cuenta ct = new Cuenta();
                    ct.setTipoDocumento(rs.getString(1));
                    ct.setNumeroDocumento(rs.getString(2));
                    ct.setCargo(rs.getString(3));
                    ct.setFechaTerminacion(rs.getDate(4));
                    ct.setFoto(rs.getByte(5));
                    ct.setEstado(rs.getBoolean(6));
                    ct.setPrimerNombre(rs.getString(7));
                    ct.setSegundoNombre(rs.getString(8));
                    ct.setPrimerApellido(rs.getString(9));
                    ct.setSegundoApellido(rs.getString(10));
                    lt.add(ct);
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
    public void insert(Cuenta dto) {
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
            prstmt.setString(indice++, dto.getTipoDocumento());
            prstmt.setString(indice++, dto.getNumeroDocumento());
            prstmt.setString(indice++, dto.getCargo());
            prstmt.setDate(indice++, new java.sql.Date(dto.getFechaTerminacion().getTime()));
            prstmt.setByte(indice++, dto.getFoto());
            prstmt.setBoolean(indice++, dto.getEstado());
            prstmt.setString(indice++, dto.getPrimerNombre());
            prstmt.setString(indice++, dto.getSegundoNombre());
            prstmt.setString(indice++, dto.getPrimerApellido());
            prstmt.setString(indice++, dto.getSegundoApellido());

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
    public void update(CuentaPK llaveDto, Cuenta dto) {
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

            prstmt.setString(indice++, dto.getCargo());
            prstmt.setDate(indice++, new java.sql.Date(dto.getFechaTerminacion().getTime()));
            prstmt.setByte(indice++, dto.getFoto());
            prstmt.setBoolean(indice++, dto.getEstado());
            prstmt.setString(indice++, dto.getPrimerNombre());
            prstmt.setString(indice++, dto.getSegundoNombre());
            prstmt.setString(indice++, dto.getPrimerApellido());
            prstmt.setString(indice++, dto.getSegundoApellido());

            prstmt.setString(indice++, llaveDto.getTipoDocumento());
            prstmt.setString(indice++, llaveDto.getNumeroDocumento());

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
    public void updatePk(CuentaPK llaveVieja, CuentaPK llaveNueva) {
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
            prstmt.setString(indice++, llaveNueva.getTipoDocumento());
            prstmt.setString(indice++, llaveNueva.getNumeroDocumento());
            prstmt.setString(indice++, llaveVieja.getTipoDocumento());
            prstmt.setString(indice++, llaveVieja.getNumeroDocumento());

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
    public void delete(CuentaPK dto) {
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
            prstmt.setString(indice++, dto.getTipoDocumento());
            prstmt.setString(indice++, dto.getNumeroDocumento());

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
    public List<Cuenta> findByPK(CuentaPK dto) {
        final boolean estaConectado = (conexion != null);
        Connection conex = null;
        PreparedStatement prstmt = null;
        ResultSet rs = null;
        List<Cuenta> lt = new ArrayList<>();

        try {
            if (estaConectado) {
                conex = conexion;
            } else {
                conex = ResourceManager.getConeccion();
            }
            final String SQL = SQL_SELECT + " where Tipo_Documento = ? AND Num_Documento = ?";

            JOptionPane.showMessageDialog(null, "Se ejecuto " + SQL);
            prstmt = conex.prepareStatement(SQL);
            int index = 1;
            prstmt.setString(index++, dto.getTipoDocumento());
            prstmt.setString(index++, dto.getNumeroDocumento());
            rs = prstmt.executeQuery();
           
            if (!rs.wasNull()) {
                while (rs.next()) {
                    Cuenta ct = new Cuenta();
                    ct.setTipoDocumento(rs.getString(1));
                    ct.setNumeroDocumento(rs.getString(2));
                    ct.setCargo(rs.getString(3));
                    ct.setFechaTerminacion(rs.getDate(4));
                    ct.setFoto(rs.getByte(5));
                    ct.setEstado(rs.getBoolean(6));
                    ct.setPrimerNombre(rs.getString(7));
                    ct.setSegundoNombre(rs.getString(8));
                    ct.setPrimerApellido(rs.getString(9));
                    ct.setSegundoApellido(rs.getString(10));
                    lt.add(ct);
                    
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
