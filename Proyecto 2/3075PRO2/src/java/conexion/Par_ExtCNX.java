/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package conexion;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Participantes_Ext;

/**
 *
 * @author A
 */
public class Par_ExtCNX extends conector {
    
    public List<Participantes_Ext> listar()throws Exception{
       List<Participantes_Ext> lista = null;
       ResultSet rs;
       
       try{
           this.Conectar();
           PreparedStatement st = this.getCn().prepareCall("select a.cod_participacion, b.nombre, b.apellido, f.nombre as nacionalidad, c.titulo, c.fecha, d.nombre as hospital\n" +
"from participacion as a, medico as b, congreso as c, hospital as d, localizacion as e, pais as f\n" +
"where a.cod_medico = b.cod_medico and a.cod_congreso = c.cod_congreso and a.cod_hospital = d.cod_hospital and b.cod_loc = e.cod_loc\n" +
"and e.cod_pais = f.cod_pais");
             rs = st.executeQuery();
            lista = new ArrayList();
            while(rs.next()){
                Participantes_Ext _par_ext = new Participantes_Ext();
                _par_ext.setCod_participacion(rs.getInt("cod_participacion"));
                _par_ext.setNombre(rs.getString("nombre"));
                _par_ext.setApellido(rs.getString("apellido"));
                _par_ext.setNacionalidad(rs.getString("nacionalidad"));
                _par_ext.setTitulo(rs.getString("titulo"));
                _par_ext.setFecha(rs.getDate("fecha"));
                _par_ext.setHospital(rs.getString("hospital"));
                
            lista.add(_par_ext);
               
            }
           
       }catch(Exception e){
           System.out.println("Error");
           System.out.println(e);
       }finally{
           this.Cerrar();
       }
       return lista;
        
        
    }
    
    
}
