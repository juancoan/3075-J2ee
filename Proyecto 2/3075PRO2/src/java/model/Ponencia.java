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
public class Ponencia {
    
    private int cod_ponencia;
    private int cod_congreso;
    private String titulo;

    public int getCod_ponencia() {
        return cod_ponencia;
    }

    public void setCod_ponencia(int cod_ponencia) {
        this.cod_ponencia = cod_ponencia;
    }

    public int getCod_congreso() {
        return cod_congreso;
    }

    public void setCod_congreso(int cod_congreso) {
        this.cod_congreso = cod_congreso;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    
    
}
