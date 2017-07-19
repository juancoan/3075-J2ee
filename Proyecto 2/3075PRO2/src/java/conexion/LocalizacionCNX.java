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
import model.Localizacion;
import model.Pais;


/**
 *
 * @author A
 */
public class LocalizacionCNX extends conector {
    
    public void registrar(Localizacion _localizacion)
    {
        try {
          this.Conectar();  
          PreparedStatement st = this.getCn().prepareStatement("INSERT INTO localizacion (cod_pais, ciudad, provincia) VALUES(?, ?, ? )" );
          st.setInt(1, _localizacion.getCod_pais());
          st.setString(2, _localizacion.getCiudad());
          st.setString(3, _localizacion.getProvincia());
          System.out.println(st);
          st.executeUpdate();
          
        }catch (Exception e){
            System.out.println("Hay un Error Insertando");
            System.out.println(e);
        } finally {
            this.Cerrar();
        }
        
    }
    
       public List<Localizacion> listar() throws Exception{
        List<Localizacion> lista;
        ResultSet rs;
        
        try{
            this.Conectar();
            PreparedStatement st = this.getCn().prepareCall("SELECT cod_loc, cod_pais, ciudad, provincia FROM localizacion");
            System.out.println(st);
            rs = st.executeQuery();
            lista = new ArrayList();
            while(rs.next()){
                Localizacion _Localizacion = new Localizacion();
                _Localizacion.setCod_loc(rs.getInt("cod_loc"));
                _Localizacion.setCod_pais(rs.getInt("cod_pais"));
                _Localizacion.setCiudad(rs.getString("ciudad"));
                _Localizacion.setProvincia(rs.getString("provincia"));
                
                lista.add(_Localizacion);
                                
            }
        }catch(Exception e){
            System.out.println(e);
            throw e;
            
            
        }finally{
        this.Cerrar();
        }
        return lista;
    }
       
    public Localizacion leerID(Localizacion _Localizacion) throws Exception{
    
    ResultSet rs;
    Localizacion _localizacionout = null;
   
    try{
        this.Conectar();
        PreparedStatement st = this.getCn().prepareStatement("SELECT cod_loc, cod_pais, ciudad, provincia FROM localizacion WHERE cod_loc = ?");
        st.setInt(1, _Localizacion.getCod_loc());
        rs = st.executeQuery();
        while (rs.next()){
            _localizacionout = new Localizacion();
            _localizacionout.setCod_loc(rs.getInt("cod_loc"));
            _localizacionout.setCod_pais(rs.getInt("cod_pais"));
            _localizacionout.setCiudad(rs.getString("ciudad"));
            _localizacionout.setProvincia(rs.getString("provincia"));
           
         }
        
    }catch(Exception e){
        throw e;
    }finally{
        this.Cerrar();
        
    }
            
    return _localizacionout;
    }
    
    public void modificar(Localizacion _Localizacion) throws Exception{
        
        try{
            this.Conectar();
            System.out.println("Conectado");
            PreparedStatement st = this.getCn().prepareStatement("UPDATE localizacion SET cod_pais = ?, ciudad = ?, provincia = ? WHERE cod_loc = ?");
            st.setInt(1, _Localizacion.getCod_pais());
            st.setString(2, _Localizacion.getCiudad());
            st.setString(3, _Localizacion.getProvincia());
            st.setInt(4, _Localizacion.getCod_loc());
            st.executeUpdate();
            
        }catch(Exception e){
            System.out.println("No me pude conectar en la modificacion");
        }finally{
            
            this.Cerrar();
            
        }
       
    }
     
    public void eliminar(Localizacion _Localizacion) throws Exception{
        
        try{
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("DELETE FROM localizacion WHERE cod_loc = ?");
            st.setInt(1, _Localizacion.getCod_loc());
            st.executeUpdate();
            
        }catch(Exception e){
            throw e;
            
            
        }finally{
            this.Cerrar();
            
        }
        
        
    }
    
    
    
}
