/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package converter;

import conexion.PaisCNX;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
    
/**
 *
 * @author A
 */

@FacesConverter("PaisConverter")


public class PaisConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        
        String Nombre_Pais = "";
        int cod_pais = (int) value;        
        
        if(value != null){
            
            PaisCNX AD;
            
            try{
            AD = new PaisCNX();
            Nombre_Pais = AD.paisbyid(cod_pais);                    
            
        }catch (Exception e){
            
        }
           
        }
    
        return Nombre_Pais;
    }
    
}
