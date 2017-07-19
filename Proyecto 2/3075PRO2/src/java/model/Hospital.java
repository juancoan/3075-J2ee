/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author A
 */
public class Hospital {

    private int cod_hospital;
    private int cod_loc;
    private String nombre;

    public int getCod_hospital() {
        return cod_hospital;
    }

    public void setCod_hospital(int cod_hospital) {
        this.cod_hospital = cod_hospital;
    }

    public int getCod_loc() {
        return cod_loc;
    }

    public void setCod_loc(int cod_loc) {
        this.cod_loc = cod_loc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
}
