/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bean;

import conexion.HospitalCNX;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import model.Hospital;

@ManagedBean
@ViewScoped


/**
 *
 * @author A
 */
public class hospitalBean {
    
    private Hospital _hospital = new Hospital();
    private List<Hospital> ListaHospitales;

    public List<Hospital> getListaHospitales() {
        return ListaHospitales;
    }

    public void setListaHospitales(List<Hospital> ListaHospitales) {
        this.ListaHospitales = ListaHospitales;
    }

    public Hospital getHospital() {
        return _hospital;
    }

    public void setHospital(Hospital _hospital) {
        this._hospital = _hospital;
    }
    
    
    public void registrar() throws Exception{
        
        HospitalCNX AD; //Acceso a datos
        
        try{
            AD = new HospitalCNX();
            AD.registrar(_hospital);
            
        }catch (Exception e){
            throw e;
        }
       
    }
    
    public void listar() throws Exception{
        
        HospitalCNX AD; //Acceso a datos
        
        try{
            AD = new HospitalCNX();
            ListaHospitales = AD.listar();
            
        }catch (Exception e){
            
        }
    }
    
    public void leerID(Hospital _hospital){
        
        HospitalCNX AD;
        Hospital temp;
        
        try{
            AD = new HospitalCNX();
            temp = AD.leerID(_hospital);
            
            if (temp != null){
                this._hospital = temp;
                
            }
            
        }catch(Exception e){
            
        }
       
    }
    
    public void modificar() throws Exception{
        HospitalCNX AD;
        
        try{
            AD = new HospitalCNX();
            AD.modificar(_hospital);
            this.listar();
            
        }catch(Exception e){
            throw e;
            
        }
        
    }
    
     public void eliminar(Hospital _hospital) throws Exception{
        HospitalCNX AD;
        
        try{
            AD = new HospitalCNX();
            AD.eliminar(_hospital);
            this.listar();
            
        }catch(Exception e){
            throw e;
            
        }
        
    }
    
    
}
