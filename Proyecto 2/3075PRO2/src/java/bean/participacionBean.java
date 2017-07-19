/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bean;

import conexion.ParticipacionCNX;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import model.Participacion;

@ManagedBean
@ViewScoped


/**
 *
 * @author A
 */
public class participacionBean {
    
    private Participacion _participacion = new Participacion();
    private List<Participacion> ListaParticipaciones;

    public List<Participacion> getListaParticipaciones() {
        return ListaParticipaciones;
    }

    public void setListaParticipaciones(List<Participacion> ListaParticipaciones) {
        this.ListaParticipaciones = ListaParticipaciones;
    }

    public Participacion getParticipacion() {
        return _participacion;
    }

    public void setParticipacion(Participacion _participacion) {
        this._participacion = _participacion;
    }
    
    
    public void registrar() throws Exception{
        
        ParticipacionCNX AD; //Acceso a datos
        
        try{
            AD = new ParticipacionCNX();
            AD.registrar(_participacion);
            
        }catch (Exception e){
            throw e;
        }
       
    }
    
    public void listar() throws Exception{
        
        ParticipacionCNX AD; //Acceso a datos
        
        try{
            AD = new ParticipacionCNX();
            ListaParticipaciones = AD.listar();
            
        }catch (Exception e){
            
        }
    }
    
    public void leerID(Participacion _participacion){
        
        ParticipacionCNX AD;
        Participacion temp;
        
        try{
            AD = new ParticipacionCNX();
            temp = AD.leerID(_participacion);
            System.out.println("estoy en esta seccion");
            if (temp != null){
                this._participacion = temp;
                
            }
            
        }catch(Exception e){
            System.out.println("Aqui hubo un error");
            System.out.println(e);
            
        }
       
    }
    
    public void modificar() throws Exception{
        ParticipacionCNX AD;
        
        try{
            AD = new ParticipacionCNX();
            AD.modificar(_participacion);
            this.listar();
            
        }catch(Exception e){
            throw e;
            
        }
        
    }
    
     public void eliminar(Participacion _participacion) throws Exception{
        ParticipacionCNX AD;
        
        try{
            AD = new ParticipacionCNX();
            AD.eliminar(_participacion);
            this.listar();
            
        }catch(Exception e){
            throw e;
            
        }
        
    }
    
    
}
