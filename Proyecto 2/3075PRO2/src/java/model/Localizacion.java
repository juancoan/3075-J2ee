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
public class Localizacion {
    
    private int cod_loc;
    private int cod_pais;
    private String ciudad;
    private String provincia;

    public int getCod_loc() {
        return cod_loc;
    }

    public void setCod_loc(int cod_loc) {
        this.cod_loc = cod_loc;
    }

    public int getCod_pais() {
        return cod_pais;
    }

    public void setCod_pais(int cod_pais) {
        this.cod_pais = cod_pais;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
    
    
    
}
