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
public class Registro implements Serializable{
    private Integer numIngreso;
    private String fechaIngreso;
    private String fechaSalida;
    private String horaIngreso;
    private String horaSalida;
    private String rolRegistro;
    private String cuentaTipoDocumento;
    private String cuentaNumeroDocumento;
    private String motivoVisita;

    public Integer getNumIngreso() {
        return numIngreso;
    }

    public void setNumIngreso(Integer numIngreso) {
        this.numIngreso = numIngreso;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getHoraIngreso() {
        return horaIngreso;
    }

    public void setHoraIngreso(String horaIngreso) {
        this.horaIngreso = horaIngreso;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getRolRegistro() {
        return rolRegistro;
    }

    public void setRolRegistro(String rolRegistro) {
        this.rolRegistro = rolRegistro;
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

    public String getMotivoVisita() {
        return motivoVisita;
    }

    public void setMotivoVisita(String motivoVisita) {
        this.motivoVisita = motivoVisita;
    }

    @Override
    public String toString() {
        return "Registro{" + "numIngreso=" + numIngreso + ", fechaIngreso=" + fechaIngreso + ", fechaSalida=" + fechaSalida + ", horaIngreso=" + horaIngreso + ", horaSalida=" + horaSalida + ", rol=" + rolRegistro + ", cuentaTipoDocumento=" + cuentaTipoDocumento + ", cuentaNumeroDocumento=" + cuentaNumeroDocumento + ", motivoVisita=" + motivoVisita + '}';
    }
    
   
}
