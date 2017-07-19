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

/**
 *
 * @author A
 */
public class CongresoCNX extends conector {
    
    public void registrar(Congreso _congreso)
    {
        try {
          this.Conectar();  
          PreparedStatement st = this.getCn().prepareStatement("INSERT INTO congreso (cod_loc, fecha, titulo) VALUES(?, ?, ? )" );
          System.out.println("-----------------------");
          System.out.println(st);
          st.setInt(1, _congreso.getCod_loc());
          st.setDate(2, _congreso.getFechaSQL());
          st.setString(3, _congreso.getTitulo());
          st.executeUpdate();
          
        }catch (Exception e){
            System.out.println("Hay un Error Insertandoxxx");
            System.out.println(e);
        } finally {
            this.Cerrar();
        }
        
    }
    
       public List<Congreso> listar() throws Exception{
        List<Congreso> lista;
        ResultSet rs;
        
        try{
            this.Conectar();
            PreparedStatement st = this.getCn().prepareCall("SELECT cod_congreso, cod_loc, fecha, titulo FROM congreso");
            System.out.println(st);
            rs = st.executeQuery();
            lista = new ArrayList();
            while(rs.next()){
                Congreso _congreso = new Congreso();
                
                _congreso.setCod_congreso(rs.getInt("cod_congreso"));
                _congreso.setCod_loc(rs.getInt("cod_loc"));
                _congreso.setFecha(rs.getDate("fecha"));
                _congreso.setTitulo(rs.getString("titulo"));
               
                lista.add(_congreso);
                                
            }
        }catch(Exception e){
            System.out.println(e);
            throw e;
            
            
        }finally{
        this.Cerrar();
        }
        return lista;
    }
       
    public Congreso leerID(Congreso _congreso) throws Exception{
    
    ResultSet rs;
    Congreso _congresoout = null;
    
   
    try{
        this.Conectar();
        PreparedStatement st = this.getCn().prepareStatement("SELECT cod_congreso, cod_loc, fecha, titulo from congreso where cod_congreso = ?");
        st.setInt(1, _congreso.getCod_congreso());
        rs = st.executeQuery();
        while (rs.next()){
            
            _congresoout = new Congreso();
            _congresoout.setCod_congreso(rs.getInt("cod_congreso"));
            _congresoout.setCod_loc(rs.getInt("cod_loc"));
            _congresoout.setFecha(rs.getDate("fecha"));
            _congresoout.setTitulo(rs.getString("titulo"));
            
         }
        
    }catch(Exception e){
        throw e;
    }finally{
        this.Cerrar();
        
    }
            
    return _congresoout;
    
    }
    
    public void modificar(Congreso _congreso) throws Exception{
        
        try{
            this.Conectar();
            System.out.println("Conectado");
            PreparedStatement st = this.getCn().prepareStatement("UPDATE congreso SET cod_loc = ?, fecha = ?, titulo = ? WHERE cod_congreso = ?");
            st.setInt(1, _congreso.getCod_loc());
            st.setDate(2, _congreso.getFechaSQL());
            st.setString(3, _congreso.getTitulo());
            st.setInt(4, _congreso.getCod_congreso());
            st.executeUpdate();
            
        }catch(Exception e){
            System.out.println("No me pude conectar en la modificacion");
        }finally{
            
            this.Cerrar();
            
        }
       
    }
     
    public void eliminar(Congreso _congreso) throws Exception{
        
        try{
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("DELETE FROM congreso WHERE cod_congreso = ?");
            st.setInt(1, _congreso.getCod_congreso());
            st.executeUpdate();
            
        }catch(Exception e){
            throw e;
            
            
        }finally{
            this.Cerrar();
            
        }
        
    }
     
}
