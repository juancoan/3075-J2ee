/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bean;

import conexion.Par_ExtCNX;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import model.Participantes_Ext;


@ManagedBean
@ViewScoped


/**
 *
 * @author A
 */
public class Par_ExtBean {
    
    private Participantes_Ext _par_ext = new Participantes_Ext();
    private List<Participantes_Ext> Lista;

    public Participantes_Ext getPar_ext() {
        return _par_ext;
    }

    public void setPar_ext(Participantes_Ext _par_ext) {
        this._par_ext = _par_ext;
    }

    public List<Participantes_Ext> getLista() {
        return Lista;
    }

    public void setLista(List<Participantes_Ext> Lista) {
        this.Lista = Lista;
    }
    
    
    
    public void listar() throws Exception{
        
        Par_ExtCNX AD; //Acceso a datos
        
        try{
            AD = new Par_ExtCNX();
            Lista = AD.listar();
            
        }catch (Exception e){
            
        }
    }
    
    
}
