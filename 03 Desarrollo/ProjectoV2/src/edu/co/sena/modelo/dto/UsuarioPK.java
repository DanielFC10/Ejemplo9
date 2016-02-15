/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.modelo.dto;

/**
 *
 * @author Juan
 */
public class UsuarioPK {

    private String cuentaTipoDocumento;
    private String cuentaNumeroDocumento;

    public UsuarioPK(String cuentaTipoDocumento, String cuentaNumeroDocumento) {
        this.cuentaTipoDocumento = cuentaTipoDocumento;
        this.cuentaNumeroDocumento = cuentaNumeroDocumento;
    }

    public UsuarioPK() {
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

    @Override
    public String toString() {
        return "UsuarioPK{" + "cuentaTipoDocumento=" + cuentaTipoDocumento + ", cuentaNumeroDocumento=" + cuentaNumeroDocumento + '}';
    }

}
