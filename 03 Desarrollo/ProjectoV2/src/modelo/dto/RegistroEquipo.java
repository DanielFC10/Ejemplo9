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
public class RegistroEquipo implements Serializable{
    
    private Integer registroNumIngreso;
    private String propietarioCuentaTipoDocumento;
    private String propietarioCuentaNumeroDocumento;
    private String propietarioEquipoCodigoBarras;

    public Integer getRegistroNumIngreso() {
        return registroNumIngreso;
    }

    public void setRegistroNumIngreso(Integer registroNumIngreso) {
        this.registroNumIngreso = registroNumIngreso;
    }

    public String getPropietarioCuentaTipoDocumento() {
        return propietarioCuentaTipoDocumento;
    }

    public void setPropietarioCuentaTipoDocumento(String propietarioCuentaTipoDocumento) {
        this.propietarioCuentaTipoDocumento = propietarioCuentaTipoDocumento;
    }

    public String getPropietarioCuentaNumeroDocumento() {
        return propietarioCuentaNumeroDocumento;
    }

    public void setPropietarioCuentaNumeroDocumento(String propietarioCuentaNumeroDocumento) {
        this.propietarioCuentaNumeroDocumento = propietarioCuentaNumeroDocumento;
    }

    public String getPropietarioEquipoCodigoBarras() {
        return propietarioEquipoCodigoBarras;
    }

    public void setPropietarioEquipoCodigoBarras(String propietarioEquipoCodigoBarras) {
        this.propietarioEquipoCodigoBarras = propietarioEquipoCodigoBarras;
    }

    @Override
    public String toString() {
        return "RegistroEquipo{" + "registroNumIngreso=" + registroNumIngreso + ", propietarioCuentaTipoDocumento=" + propietarioCuentaTipoDocumento + ", propietarioCuentaNumeroDocumento=" + propietarioCuentaNumeroDocumento + ", propietarioEquipoCodigoBarras=" + propietarioEquipoCodigoBarras + '}';
    }
    
}
