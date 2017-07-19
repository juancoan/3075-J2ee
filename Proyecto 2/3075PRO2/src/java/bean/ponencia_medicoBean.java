/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bean;


import conexion.Ponencia_MedicoCNX;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import model.Ponencia_Medico;

@ManagedBean
@ViewScoped


/**
 *
 * @author A
 */
public class ponencia_medicoBean {
    
    private Ponencia_Medico _ponencia_medico = new Ponencia_Medico();
    private List<Ponencia_Medico> ListaPonMed;

    public List<Ponencia_Medico> getListaPonMed() {
        return ListaPonMed;
    }

    public void setListaPonMed(List<Ponencia_Medico> ListaPonMed) {
        this.ListaPonMed = ListaPonMed;
    }

    public Ponencia_Medico getPonencia() {
        return _ponencia_medico;
    }

    public void setPonencia_Medico(Ponencia_Medico _ponencia_medico) {
        this._ponencia_medico = _ponencia_medico;
    }
    
    
    public void registrar() throws Exception{
        
        Ponencia_MedicoCNX AD; //Acceso a datos
        
        try{
            AD = new Ponencia_MedicoCNX();
            AD.registrar(_ponencia_medico);
            
        }catch (Exception e){
            throw e;
        }
       
    }
    
    public void listar() throws Exception{
        
        Ponencia_MedicoCNX AD; //Acceso a datos
        
        try{
            AD = new Ponencia_MedicoCNX();
            ListaPonMed = AD.listar();
            
        }catch (Exception e){
            
        }
    }
    
    public void leerID(Ponencia_Medico _ponencia_medico){
        
        Ponencia_MedicoCNX AD;
        Ponencia_Medico temp;
        
        try{
            AD = new Ponencia_MedicoCNX();
            temp = AD.leerID(_ponencia_medico);
            
            if (temp != null){
                this._ponencia_medico = temp;
                
            }
            
        }catch(Exception e){
            
        }
       
    }
    
    public void modificar() throws Exception{
        Ponencia_MedicoCNX AD;
        
        try{
            AD = new Ponencia_MedicoCNX();
            AD.modificar(_ponencia_medico);
            this.listar();
            
        }catch(Exception e){
            throw e;
            
        }
        
    }
    
     public void eliminar(Ponencia_Medico _ponencia_medico) throws Exception{
        Ponencia_MedicoCNX AD;
        
        try{
            AD = new Ponencia_MedicoCNX();
            AD.eliminar(_ponencia_medico);
            this.listar();
            
        }catch(Exception e){
            throw e;
            
        }
        
    }
    
    
}
