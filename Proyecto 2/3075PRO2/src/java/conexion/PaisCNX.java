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
import model.Pais;

/**
 *
 * @author A
 */
public class PaisCNX extends conector {
    
    public void registrar(Pais _pais)
    {
        try {
          this.Conectar();  
          PreparedStatement st = this.getCn().prepareStatement("INSERT INTO pais (nombre) values(?)" );
          st.setString(1, _pais.getNombre());
          st.executeUpdate();
          
        }catch (Exception e){
            System.out.println("Hay un Error Insertando");
            System.out.println(e);
        } finally {
            this.Cerrar();
        }
        
    }
        
    public List<Pais> listar() throws Exception{
        List<Pais> lista;
        ResultSet rs;
        
        try{
            this.Conectar();
            PreparedStatement st = this.getCn().prepareCall("SELECT cod_pais, nombre FROM pais");
            rs = st.executeQuery();
            lista = new ArrayList();
            while(rs.next()){
                Pais _pais = new Pais();
                _pais.setCod_pais(rs.getInt("cod_pais"));
                _pais.setNombre(rs.getString("nombre"));
                
                lista.add(_pais);
                
            }
        }catch(Exception e){
            System.out.println("No pude listar nada");
            throw e;
            
            
        }finally{
        this.Cerrar();
        }
        return lista;
    }
    
    public Pais leerID(Pais _pais) throws Exception{
    
    
    ResultSet rs;
    Pais _paisout = null;
    
    try{
        this.Conectar();
        PreparedStatement st = this.getCn().prepareStatement("SELECT cod_pais, nombre FROM Pais WHERE cod_pais = ?");
        st.setInt(1, _pais.getCod_pais());
              
        rs = st.executeQuery();
        while (rs.next()){
           _paisout = new Pais();
            _paisout.setCod_pais(rs.getInt("cod_pais"));
            _paisout.setNombre(rs.getString("nombre"));
            
         }
        
    }catch(Exception e){
        throw e;
    }finally{
        this.Cerrar();
        
    }
            
    return _paisout;
    }
   
    
    public void modificar(Pais _pais) throws Exception{
        
        try{
            this.Conectar();
            System.out.println("Conectado");
            PreparedStatement st = this.getCn().prepareStatement("UPDATE pais SET nombre = ? WHERE cod_pais = ?");
            st.setString(1, _pais.getNombre());
            st.setInt(2, _pais.getCod_pais());
            st.executeUpdate();
            
            
        }catch(Exception e){
            System.out.println("No me pude conectar en la modificacion");
        }finally{
            
            this.Cerrar();
            
        }
       
    }
     
    public void eliminar(Pais _pais) throws Exception{
        
        try{
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("DELETE FROM pais WHERE cod_pais = ?");
            st.setInt(1, _pais.getCod_pais());
            st.executeUpdate();
            
        }catch(Exception e){
            throw e;
            
            
        }finally{
            this.Cerrar();
            
        }
        
        
    }
    
    
    public String paisbyid(int cod_pais) throws Exception{
    
    
    ResultSet rs;
    String _nombrepais = null;
    
    
    try{
        this.Conectar();
        PreparedStatement st = this.getCn().prepareStatement("SELECT nombre FROM Pais WHERE cod_pais = ?");
        st.setInt(1, cod_pais);
              
        rs = st.executeQuery();
        while (rs.next()){
           
           _nombrepais = rs.getString("nombre");
            
         }
        
    }catch(Exception e){
        throw e;
    }finally{
        this.Cerrar();
        
    }
            
    return _nombrepais;
    }
}
    

