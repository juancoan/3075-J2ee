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
import model.Congreso;
import model.Hospital;



/**
 *
 * @author A
 */
public class HospitalCNX extends conector {
    
    public void registrar(Hospital _hospital)
    {
        try {
          this.Conectar();  
          PreparedStatement st = this.getCn().prepareStatement("insert into hospital (cod_loc, nombre) values (?, ?)" );
          st.setInt(1, _hospital.getCod_loc());
          st.setString(2, _hospital.getNombre());
          st.executeUpdate();
          
        }catch (Exception e){
            System.out.println("Hay un Error Insertando");
            System.out.println(e);
        } finally {
            this.Cerrar();
        }
        
    }
    
       public List<Hospital> listar() throws Exception{
        List<Hospital> lista;
        ResultSet rs;
        
        try{
            this.Conectar();
            PreparedStatement st = this.getCn().prepareCall("select cod_hospital, cod_loc, nombre from hospital");
            System.out.println(st);
            rs = st.executeQuery();
            lista = new ArrayList();
            while(rs.next()){
                
                Hospital _hospital = new Hospital();
                _hospital.setCod_hospital(rs.getInt("cod_hospital"));
                _hospital.setCod_loc(rs.getInt("cod_loc"));
                _hospital.setNombre(rs.getString("nombre"));
                lista.add(_hospital);
                                
            }
        }catch(Exception e){
            System.out.println(e);
            throw e;
            
            
        }finally{
        this.Cerrar();
        }
        return lista;
    }
       
    public Hospital leerID(Hospital _hospital) throws Exception{
    
    ResultSet rs;
    Hospital _hospitalout = null;
       
   
    try{
        this.Conectar();
        PreparedStatement st = this.getCn().prepareStatement("select cod_hospital, cod_loc, nombre from hospital where cod_hospital = ?");
        st.setInt(1, _hospital.getCod_hospital());
        rs = st.executeQuery();
        while (rs.next()){
            
            _hospitalout = new Hospital();
            _hospitalout.setCod_hospital(rs.getInt("cod_hospital"));
            _hospitalout.setCod_loc(rs.getInt("cod_loc"));
            _hospitalout.setNombre(rs.getString("nombre"));
            
         }
        
    }catch(Exception e){
        throw e;
    }finally{
        this.Cerrar();
        
    }
            
    return _hospitalout;
    
    }
    
    public void modificar(Hospital _hospital) throws Exception{
        
        try{
            this.Conectar();
            System.out.println("Conectado");
            PreparedStatement st = this.getCn().prepareStatement("update hospital set cod_loc = ?, nombre = ? where cod_hospital = ?");
            st.setInt(1, _hospital.getCod_loc());
            st.setString(2, _hospital.getNombre());
            st.setInt(3, _hospital.getCod_hospital());
            st.executeUpdate();
            
        }catch(Exception e){
            System.out.println("No me pude conectar en la modificacion");
        }finally{
            
            this.Cerrar();
            
        }
       
    }
     
    public void eliminar(Hospital _hospital) throws Exception{
        
        try{
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("DELETE FROM hospital WHERE cod_hospital = ?");
            st.setInt(1, _hospital.getCod_hospital());
            st.executeUpdate();
            
        }catch(Exception e){
            throw e;
            
            
        }finally{
            this.Cerrar();
            
        }
        
        
    }
    
     
}
