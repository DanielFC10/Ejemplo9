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
public class Equipo implements Serializable{
    
    private String codigoBarras;
    private String marca;

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "Equipo{" + "codigoBarras=" + codigoBarras + ", marca=" + marca + '}';
    }
    
}
