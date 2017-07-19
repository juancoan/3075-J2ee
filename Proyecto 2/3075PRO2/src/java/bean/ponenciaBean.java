/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bean;

import conexion.PonenciaCNX;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import model.Ponencia;

@ManagedBean
@ViewScoped


/**
 *
 * @author A
 */
public class ponenciaBean {
    
    private Ponencia _ponencia = new Ponencia();
    private List<Ponencia> ListaPonencias;

    public List<Ponencia> getListaPonencias() {
        return ListaPonencias;
    }

    public void setListaPonencias(List<Ponencia> ListaPonencias) {
        this.ListaPonencias = ListaPonencias;
    }

    public Ponencia getPonencia() {
        return _ponencia;
    }

    public void setPonencia(Ponencia _ponencia) {
        this._ponencia = _ponencia;
    }
    
    
    public void registrar() throws Exception{
        
        PonenciaCNX AD; //Acceso a datos
        
        try{
            AD = new PonenciaCNX();
            AD.registrar(_ponencia);
            
        }catch (Exception e){
            throw e;
        }
       
    }
    
    public void listar() throws Exception{
        
        PonenciaCNX AD; //Acceso a datos
        
        try{
            AD = new PonenciaCNX();
            ListaPonencias = AD.listar();
            
        }catch (Exception e){
            
        }
    }
    
    public void leerID(Ponencia _ponencia){
        
        PonenciaCNX AD;
        Ponencia temp;
        
        try{
            AD = new PonenciaCNX();
            temp = AD.leerID(_ponencia);
            
            if (temp != null){
                this._ponencia = temp;
                
            }
            
        }catch(Exception e){
            
        }
       
    }
    
    public void modificar() throws Exception{
        PonenciaCNX AD;
        
        try{
            AD = new PonenciaCNX();
            AD.modificar(_ponencia);
            this.listar();
            
        }catch(Exception e){
            throw e;
            
        }
        
    }
    
     public void eliminar(Ponencia _ponencia) throws Exception{
        PonenciaCNX AD;
        
        try{
            AD = new PonenciaCNX();
            AD.eliminar(_ponencia);
            this.listar();
            
        }catch(Exception e){
            throw e;
            
        }
        
    }
    
    
}
