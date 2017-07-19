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
import model.Especialidad;



/**
 *
 * @author A
 */
public class EspecialidadCNX extends conector {
    
    public void registrar(Especialidad _especialidad)
    {
        try {
          this.Conectar();  
          PreparedStatement st = this.getCn().prepareStatement("insert into especialidad (nombre) values (?)" );
          
          st.setString(1, _especialidad.getNombre());
          st.executeUpdate();
          
        }catch (Exception e){
            System.out.println("Hay un Error Insertando");
            System.out.println(e);
        } finally {
            this.Cerrar();
        }
        
    }
    
       public List<Especialidad> listar() throws Exception{
        List<Especialidad> lista;
        ResultSet rs;
        
        try{
            this.Conectar();
            PreparedStatement st = this.getCn().prepareCall("select cod_especialidad, nombre from especialidad");            
            rs = st.executeQuery();
            lista = new ArrayList();
            while(rs.next()){
                Especialidad _especialidad = new Especialidad();
                
                _especialidad.setCod_especialidad(rs.getInt("cod_especialidad"));
                _especialidad.setNombre(rs.getString("nombre"));
                               
                lista.add(_especialidad);
                                
            }
        }catch(Exception e){
            System.out.println(e);
            throw e;
            
            
        }finally{
        this.Cerrar();
        }
        return lista;
    }
       
    public Especialidad leerID(Especialidad _especialidad) throws Exception{
    
    ResultSet rs;
    Especialidad _especialidadout = null;
    
    
   
    try{
        this.Conectar();
        PreparedStatement st = this.getCn().prepareStatement("select cod_especialidad, nombre from especialidad where cod_especialidad = ?");
        st.setInt(1, _especialidad.getCod_especialidad());
        rs = st.executeQuery();
        while (rs.next()){
            
            _especialidadout = new Especialidad();
            _especialidadout.setCod_especialidad(rs.getInt("cod_especialidad"));
            _especialidadout.setNombre(rs.getString("nombre"));
            
         }
        
    }catch(Exception e){
        throw e;
    }finally{
        this.Cerrar();
        
    }
            
    return _especialidadout;
    
    }
    
    public void modificar(Especialidad _especialidad) throws Exception{
        
        try{
            this.Conectar();
            System.out.println("Conectado");
            PreparedStatement st = this.getCn().prepareStatement("update especialidad set nombre = ? where cod_especialidad = ?");
            st.setString(1, _especialidad.getNombre());
            st.setInt(2, _especialidad.getCod_especialidad());
            st.executeUpdate();
            
        }catch(Exception e){
            System.out.println("No me pude conectar en la modificacion");
        }finally{
            
            this.Cerrar();
            
        }
       
    }
     
    public void eliminar(Especialidad _especialidad) throws Exception{
        
        try{
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("delete from especialidad where cod_especialidad = ?;");
            st.setInt(1, _especialidad.getCod_especialidad() );
            st.executeUpdate();
            
        }catch(Exception e){
            throw e;
            
            
        }finally{
            this.Cerrar();
            
        }
        
        
    }
    
     
}
