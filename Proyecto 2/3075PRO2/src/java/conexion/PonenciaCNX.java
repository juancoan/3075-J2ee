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
import model.Ponencia;



/**
 *
 * @author A
 */
public class PonenciaCNX extends conector {
    
    public void registrar(Ponencia _ponencia)
    {
        try {
          this.Conectar();  
          PreparedStatement st = this.getCn().prepareStatement("insert into ponencia (cod_congreso, titulo) values (?, ?)" );
          st.setInt(1, _ponencia.getCod_congreso());
          st.setString(2, _ponencia.getTitulo());
          st.executeUpdate();
          
        }catch (Exception e){
            System.out.println("Hay un Error Insertando");
            System.out.println(e);
        } finally {
            this.Cerrar();
        }
        
    }
    
       public List<Ponencia> listar() throws Exception{
        List<Ponencia> lista;
        ResultSet rs;
        
        try{
            this.Conectar();
            PreparedStatement st = this.getCn().prepareCall("select cod_ponencia, cod_congreso, titulo from ponencia");
            System.out.println(st);
            rs = st.executeQuery();
            lista = new ArrayList();
            while(rs.next()){
                Ponencia _ponencia = new Ponencia();
                _ponencia.setCod_ponencia(rs.getInt("cod_ponencia"));
                _ponencia.setCod_congreso(rs.getInt("cod_congreso"));
                _ponencia.setTitulo(rs.getString("titulo"));
               
                lista.add(_ponencia);
                                
            }
        }catch(Exception e){
            System.out.println(e);
            throw e;
            
            
        }finally{
        this.Cerrar();
        }
        return lista;
    }
       
    public Ponencia leerID(Ponencia _ponencia) throws Exception{
    
    ResultSet rs;
    Ponencia _ponenciaout = null;
    
   
    try{
        this.Conectar();
        PreparedStatement st = this.getCn().prepareStatement("select cod_ponencia, cod_congreso, titulo from ponencia where cod_ponencia = ?");
        st.setInt(1, _ponencia.getCod_ponencia());
        rs = st.executeQuery();
        while (rs.next()){
            
            _ponenciaout = new Ponencia();
            _ponenciaout.setCod_ponencia(rs.getInt("cod_ponencia"));
            _ponenciaout.setCod_congreso(rs.getInt("cod_congreso"));
            _ponenciaout.setTitulo(rs.getString("titulo"));
            
         }
        
    }catch(Exception e){
        throw e;
    }finally{
        this.Cerrar();
        
    }
            
    return _ponenciaout;
    
    }
    
    public void modificar(Ponencia _ponencia) throws Exception{
        
        try{
            this.Conectar();
            System.out.println("Conectado");
            PreparedStatement st = this.getCn().prepareStatement("update ponencia set cod_congreso = ?, titulo = ? where cod_ponencia = ?");
            st.setInt(1, _ponencia.getCod_congreso());
            st.setString(2, _ponencia.getTitulo());
            st.setInt(3, _ponencia.getCod_ponencia());
            st.executeUpdate();
            
        }catch(Exception e){
            System.out.println("No me pude conectar en la modificacion");
        }finally{
            
            this.Cerrar();
            
        }
       
    }
     
    public void eliminar(Ponencia _ponencia) throws Exception{
        
        try{
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("DELETE FROM ponencia WHERE cod_ponencia = ?");
            st.setInt(1, _ponencia.getCod_ponencia());
            st.executeUpdate();
            
        }catch(Exception e){
            throw e;
            
            
        }finally{
            this.Cerrar();
            
        }
        
        
    }
    
     
}
