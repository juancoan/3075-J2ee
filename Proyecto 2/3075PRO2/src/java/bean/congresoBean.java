/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bean;

import conexion.CongresoCNX;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import model.Congreso;

@ManagedBean
@ViewScoped


/**
 *
 * @author A
 */
public class congresoBean {
    
    private Congreso _congreso = new Congreso();
    private List<Congreso> ListaCongresos;

    public List<Congreso> getListaCongresos() {
        return ListaCongresos;
    }

    public void setListaCongresos(List<Congreso> ListaCongresos) {
        this.ListaCongresos = ListaCongresos;
    }

    public Congreso getCongreso() {
        return _congreso;
    }

    public void setCongreso(Congreso _congreso) {
        this._congreso = _congreso;
    }
    
    
    public void registrar() throws Exception{
        
        CongresoCNX AD; //Acceso a datos
        
        try{
            AD = new CongresoCNX();
            AD.registrar(_congreso);
            
        }catch (Exception e){
            System.out.println("Aqui viene el error");
            System.out.println(e);
            throw e;
        }
       
    }
    
    public void listar() throws Exception{
        
        CongresoCNX AD; //Acceso a datos
        
        try{
            AD = new CongresoCNX();
            ListaCongresos = AD.listar();
            
        }catch (Exception e){
            
        }
    }
    
    public void leerID(Congreso _congreso){
        
        CongresoCNX AD;
        Congreso temp;
        
        try{
            AD = new CongresoCNX();
            temp = AD.leerID(_congreso);
            
            if (temp != null){
                this._congreso = temp;
                
            }
            
        }catch(Exception e){
            
        }
       
    }
    
    public void modificar() throws Exception{
        CongresoCNX AD;
        
        try{
            AD = new CongresoCNX();
            AD.modificar(_congreso);
            this.listar();
            
        }catch(Exception e){
            throw e;
            
        }
        
    }
    
     public void eliminar(Congreso _congreso) throws Exception{
        CongresoCNX AD;
        
        try{
            AD = new CongresoCNX();
            AD.eliminar(_congreso);
            this.listar();
            
        }catch(Exception e){
            throw e;
            
        }
        
    }
    
    
}
