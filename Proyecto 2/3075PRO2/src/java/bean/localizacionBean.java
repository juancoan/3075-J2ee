/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bean;

import conexion.LocalizacionCNX;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import model.Localizacion;

@ManagedBean
@ViewScoped

/**
 *
 * @author A
 */
public class localizacionBean {
    
    
    private Localizacion _Localizacion = new Localizacion();
    private List<Localizacion> ListaLocaciones;
    

    public Localizacion getLocalizacion() {
        return _Localizacion;
    }

    public void setLocalizacion(Localizacion _localizacion) {
        this._Localizacion = _localizacion;
    }

    public List<Localizacion> getListaLocaciones() {
        return ListaLocaciones;
    }

    public void setListaLocaciones(List<Localizacion> ListaLocaciones) {
        this.ListaLocaciones = ListaLocaciones;
    }
    
    public void registrar() throws Exception{
        
        LocalizacionCNX AD; //Acceso a datos
        
        try{
            AD = new LocalizacionCNX();
            AD.registrar(_Localizacion);
            
        }catch (Exception e){
            throw e;
        }
       
    }
    
    public void listar() throws Exception{
        
        LocalizacionCNX AD; //Acceso a datos
        
        try{
            AD = new LocalizacionCNX();
            ListaLocaciones = AD.listar();
            
        }catch (Exception e){
            
        }
    }
    
    public void leerID(Localizacion _Localizacion){
        
        LocalizacionCNX AD;
        Localizacion temp;
        
        try{
            AD = new LocalizacionCNX();
            temp = AD.leerID(_Localizacion);
            
            if (temp != null){
                this._Localizacion = temp;
                
            }
            
        }catch(Exception e){
            
        }
       
    }
    
    public void modificar() throws Exception{
        LocalizacionCNX AD;
        
        
        try{
            AD = new LocalizacionCNX();
            AD.modificar(_Localizacion);
            this.listar();
            
        }catch(Exception e){
            throw e;
            
        }
        
    }
    
     public void eliminar(Localizacion _Localizacion) throws Exception{
        LocalizacionCNX AD;
         
        
        try{
            AD = new LocalizacionCNX();
            AD.eliminar(_Localizacion);
            this.listar();
            
        }catch(Exception e){
            throw e;
            
        }
        
    }
    
}
