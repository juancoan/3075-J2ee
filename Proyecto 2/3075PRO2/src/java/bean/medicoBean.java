/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bean;

import conexion.MedicoCNX;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import model.Medico;

@ManagedBean
@ViewScoped


/**
 *
 * @author A
 */
public class medicoBean {
    
    private Medico _medico = new Medico();
    private List<Medico> ListaMedicos;

    public List<Medico> getListaMedicos() {
        return ListaMedicos;
    }

    public void setListaMedicoes(List<Medico> ListaMedicos) {
        this.ListaMedicos = ListaMedicos;
    }

    public Medico getMedico() {
        return _medico;
    }

    public void setMedico(Medico _medico) {
        this._medico = _medico;
    }
    
    
    public void registrar() throws Exception{
        
        MedicoCNX AD; //Acceso a datos
        
        try{
            AD = new MedicoCNX();
            AD.registrar(_medico);
            
        }catch (Exception e){
            throw e;
        }
       
    }
    
    public void listar() throws Exception{
        
        MedicoCNX AD; //Acceso a datos
        
        try{
            AD = new MedicoCNX();
            ListaMedicos = AD.listar();
            
        }catch (Exception e){
            
        }
    }
    
    public void leerID(Medico _medico){
        
        MedicoCNX AD;
        Medico temp;
        
        try{
            AD = new MedicoCNX();
            temp = AD.leerID(_medico);
            
            if (temp != null){
                this._medico = temp;
                
            }
            
        }catch(Exception e){
            
        }
       
    }
    
    public void modificar() throws Exception{
        MedicoCNX AD;
        
        try{
            AD = new MedicoCNX();
            AD.modificar(_medico);
            this.listar();
            
        }catch(Exception e){
            throw e;
            
        }
        
    }
    
     public void eliminar(Medico _medico) throws Exception{
        MedicoCNX AD;
        
        try{
            AD = new MedicoCNX();
            AD.eliminar(_medico);
            this.listar();
            
        }catch(Exception e){
            throw e;
            
        }
        
    }
    
    
}
