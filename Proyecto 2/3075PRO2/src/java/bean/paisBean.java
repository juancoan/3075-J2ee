/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bean;

import conexion.PaisCNX;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import model.Pais;

@ManagedBean
@ViewScoped


/**
 *
 * @author A
 */
public class paisBean {
    
    private Pais _pais = new Pais();
    private List<Pais> ListaPaises;

    public List<Pais> getListaPaises() {
        return ListaPaises;
    }

    public void setListaPaises(List<Pais> ListaPaises) {
        this.ListaPaises = ListaPaises;
    }

    public Pais getPais() {
        return _pais;
    }

    public void setPais(Pais _pais) {
        this._pais = _pais;
    }
    
    
    public void registrar() throws Exception{
        
        PaisCNX AD; //Acceso a datos
        
        try{
            AD = new PaisCNX();
            AD.registrar(_pais);
            
        }catch (Exception e){
            throw e;
        }
       
    }
    
    public void listar() throws Exception{
        
        PaisCNX AD; //Acceso a datos
        
        try{
            AD = new PaisCNX();
            ListaPaises = AD.listar();
            
        }catch (Exception e){
            
        }
    }
    
    public void leerID(Pais _pais){
        
        PaisCNX AD;
        Pais temp;
        
        try{
            AD = new PaisCNX();
            temp = AD.leerID(_pais);
            
            if (temp != null){
                this._pais = temp;
                
            }
            
        }catch(Exception e){
            
        }
       
    }
    
    public void modificar() throws Exception{
        PaisCNX AD;
        
        try{
            AD = new PaisCNX();
            AD.modificar(_pais);
            this.listar();
            
        }catch(Exception e){
            throw e;
            
        }
        
    }
    
     public void eliminar(Pais _pais) throws Exception{
        PaisCNX AD;
        
        try{
            AD = new PaisCNX();
            AD.eliminar(_pais);
            this.listar();
            
        }catch(Exception e){
            throw e;
            
        }
        
    }
    
    
}
