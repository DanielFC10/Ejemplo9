/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dto;

import java.io.Serializable;

/**
 *
 * @author Juan
 */
public class Propietario implements Serializable{
    
    private String cuentaTipoDocumento;
    private String cuentaNumeroDocumento;
    private String equipoCodigoBarras;

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

    public String getEquipoCodigoBarras() {
        return equipoCodigoBarras;
    }

    public void setEquipoCodigoBarras(String equipoCodigoBarras) {
        this.equipoCodigoBarras = equipoCodigoBarras;
    }

    @Override
    public String toString() {
        return "Propietario{" + "cuentaTipoDocumento=" + cuentaTipoDocumento + ", cuentaNumeroDocumento=" + cuentaNumeroDocumento + ", equipoCodigoBarras=" + equipoCodigoBarras + '}';
    }
    
}
