/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.modelo.dto;

import java.io.Serializable;

/**
 *
 * @author Juan
 */
public class Usuario implements Serializable{
    
    private String contrasenia;
    private String rol;
    private String cuentaTipoDocumento;
    private String cuentaNumeroDocumento;
    private String correoRecuperacion;

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getCuentaTipoDocumento() {
        return cuentaTipoDocumento;
    }

    public void setCuentaTipoDocumento(String cuentaTipoDocumento) {
        this.cuentaTipoDocumento = cuentaTipoDocumento;
    }

    public String getCuentaNumeroDocumento() {
        return cuentaNumeroDocumento;
    }

    public void setCuentaNumeroDocumento(String cuentaNumeroDocumento) {
        this.cuentaNumeroDocumento = cuentaNumeroDocumento;
    }

    public String getCorreoRecuperacion() {
        return correoRecuperacion;
    }

    public void setCorreoRecuperacion(String correoRecuperacion) {
        this.correoRecuperacion = correoRecuperacion;
    }

    @Override
    public String toString() {
        return "Usuario{" + "Contrasenia: " + contrasenia 
                + ", Rol: " + rol + ", Cuenta Tipo Documento: " 
                + cuentaTipoDocumento + ", Cuenta Numero Documento: " 
                + cuentaNumeroDocumento + ", Correo Recuperacion: " 
                + correoRecuperacion + '}';
    }
    

}
