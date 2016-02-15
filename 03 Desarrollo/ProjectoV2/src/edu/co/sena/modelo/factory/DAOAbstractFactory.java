/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.modelo.factory;

/**
 *
 * @author Juan
 */
public abstract class DAOAbstractFactory implements DAOFactory {

    public static final int MYSQL_FACTORY = 1;

    public static DAOAbstractFactory getDAOFactory(int factorType) {
        switch (factorType) {
            case MYSQL_FACTORY:
                return new MySqlDAOFactory();
            default:
                System.out.println("Esa base de datos no esta disponible");
                return null;
        }
    }
}
