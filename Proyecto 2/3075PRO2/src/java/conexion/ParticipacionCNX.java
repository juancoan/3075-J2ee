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
import model.Participacion;



/**
 *
 * @author A
 */
public class ParticipacionCNX extends conector {
    
    public void registrar(Participacion _participacion)
    {
        try {
          this.Conectar();  
          PreparedStatement st = this.getCn().prepareStatement("insert into participacion (cod_medico, cod_congreso, cod_hospital) values (? , ?, ? )" );
          
          st.setInt(1, _participacion.getCod_medico());
          st.setInt(2, _participacion.getCod_congreso());
          st.setInt(3, _participacion.getCod_hospital());
          st.executeUpdate();
          
        }catch (Exception e){
            System.out.println("Hay un Error Insertando");
            System.out.println(e);
        } finally {
            this.Cerrar();
        }
        
    }
    
       public List<Participacion> listar() throws Exception{
        List<Participacion> lista;
        ResultSet rs;
        
        try{
            this.Conectar();
            PreparedStatement st = this.getCn().prepareCall("select cod_participacion, cod_medico, cod_congreso, cod_hospital from participacion");
            System.out.println(st);
            rs = st.executeQuery();
            lista = new ArrayList();
            while(rs.next()){
                Participacion _participacion = new Participacion();
                
                _participacion.setCod_participacion(rs.getInt("cod_participacion"));
                _participacion.setCod_medico(rs.getInt("cod_medico"));
                _participacion.setCod_congreso(rs.getInt("cod_congreso"));
                _participacion.setCod_hospital(rs.getInt("cod_hospital"));
                            
                lista.add(_participacion);
                                
            }
        }catch(Exception e){
            System.out.println(e);
            throw e;
            
            
        }finally{
        this.Cerrar();
        }
        return lista;
    }
       
    public Participacion leerID(Participacion _participacion) throws Exception{
    
    ResultSet rs;
    Participacion _participacionout = null;
    
    
   
    try{
        this.Conectar();
        PreparedStatement st = this.getCn().prepareStatement("select cod_participacion, cod_medico, cod_congreso, cod_hospital from participacion where cod_participacion = ?");
        st.setInt(1, _participacion.getCod_participacion());
        rs = st.executeQuery();
        while (rs.next()){
            
            _participacionout = new Participacion();
            _participacionout.setCod_participacion(rs.getInt("cod_participacion"));
            _participacionout.setCod_medico(rs.getInt("cod_medico"));
            _participacionout.setCod_congreso(rs.getInt("cod_congreso"));
            _participacionout.setCod_hospital(rs.getInt("cod_hospital"));
            
         }
        
    }catch(Exception e){
        throw e;
    }finally{
        this.Cerrar();
        
    }
            
    return _participacionout;
    
    }
    
    public void modificar(Participacion _participacion) throws Exception{
        
        try{
            this.Conectar();
            System.out.println("Conectado");
            PreparedStatement st = this.getCn().prepareStatement("update participacion set cod_medico = ?, cod_congreso = ?, cod_hospital = ? where cod_participacion = ?");
            st.setInt(1, _participacion.getCod_medico());
            st.setInt(2, _participacion.getCod_congreso());
            st.setInt(3, _participacion.getCod_hospital());
            st.setInt(4, _participacion.getCod_participacion());
            System.out.println(st);
            st.executeUpdate();
            
        }catch(Exception e){
            System.out.println("No me pude conectar en la modificacion");
        }finally{
            
            this.Cerrar();
            
        }
       
    }
     
    public void eliminar(Participacion _participacion) throws Exception{
        
        try{
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("DELETE FROM participacion WHERE cod_participacion = ?");
            st.setInt(1, _participacion.getCod_participacion());
            st.executeUpdate();
            
        }catch(Exception e){
            throw e;
            
            
        }finally{
            this.Cerrar();
            
        }
        
        
    }
    
     
}
