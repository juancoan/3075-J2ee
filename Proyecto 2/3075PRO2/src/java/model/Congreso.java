/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.Date;

/**
 *
 * @author A
 */
public class Congreso {
    
    private int cod_congreso;
    private int cod_loc;
    private Date fecha;
    private String titulo;

  
    public int getCod_congreso() {
        return cod_congreso;
    }

    public void setCod_congreso(int cod_congreso) {
        this.cod_congreso = cod_congreso;
    }

    public int getCod_loc() {
        return cod_loc;
    }

    public void setCod_loc(int cod_loc) {
        this.cod_loc = cod_loc;
    }

    public Date getFecha() {
        return fecha;
    }
    
    public java.sql.Date getFechaSQL() {
        java.sql.Date sqlDate = new java.sql.Date(fecha.getTime());
        return sqlDate;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
   

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
   
    
}
