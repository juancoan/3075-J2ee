/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bean;

import conexion.EspecialidadCNX;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import model.Especialidad;

@ManagedBean
@ViewScoped


/**
 *
 * @author A
 */
public class especialidadBean {
    
    private Especialidad _especialidad = new Especialidad();
    private List<Especialidad> ListaEspecialidades;

    public List<Especialidad> getListaEspecialidades() {
        return ListaEspecialidades;
    }

    public void setListaEspecialidades(List<Especialidad> ListaEspecialidades) {
        this.ListaEspecialidades = ListaEspecialidades;
    }

    public Especialidad getEspecialidad() {
        return _especialidad;
    }

    public void setEspecialidad(Especialidad _especialidad) {
        this._especialidad = _especialidad;
    }
    
    
    public void registrar() throws Exception{
        
        EspecialidadCNX AD; //Acceso a datos
        
        try{
            AD = new EspecialidadCNX();
            AD.registrar(_especialidad);
            
        }catch (Exception e){
            throw e;
        }
       
    }
    
    public void listar() throws Exception{
        
        EspecialidadCNX AD; //Acceso a datos
        
        try{
            AD = new EspecialidadCNX();
            ListaEspecialidades = AD.listar();
            
        }catch (Exception e){
            
        }
    }
    
    public void leerID(Especialidad _especialidad){
        
        EspecialidadCNX AD;
        Especialidad temp;
        
        try{
            AD = new EspecialidadCNX();
            temp = AD.leerID(_especialidad);
            
            if (temp != null){
                this._especialidad = temp;
                
            }
            
        }catch(Exception e){
            
        }
       
    }
    
    public void modificar() throws Exception{
        EspecialidadCNX AD;
        
        try{
            AD = new EspecialidadCNX();
            AD.modificar(_especialidad);
            this.listar();
            
        }catch(Exception e){
            throw e;
            
        }
        
    }
    
     public void eliminar(Especialidad _especialidad) throws Exception{
        EspecialidadCNX AD;
        
        try{
            AD = new EspecialidadCNX();
            AD.eliminar(_especialidad);
            this.listar();
            
        }catch(Exception e){
            throw e;
            
        }
        
    }
    
    
}
