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
public class Medico {
    
    private int cod_medico;
    private int cod_especialidad;
    private int cod_loc;
    private String nombre;
    private String apellido;
    private String email;

    public int getCod_medico() {
        return cod_medico;
    }

    public void setCod_medico(int cod_medico) {
        this.cod_medico = cod_medico;
    }

    public int getCod_especialidad() {
        return cod_especialidad;
    }

    public void setCod_especialidad(int cod_especialidad) {
        this.cod_especialidad = cod_especialidad;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
    
}
