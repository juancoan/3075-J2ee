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
import model.Medico;



/**
 *
 * @author A
 */
public class MedicoCNX extends conector {
    
    public void registrar(Medico _medico)
    {
        try {
          this.Conectar();  
          PreparedStatement st = this.getCn().prepareStatement("insert into medico (cod_especialidad, cod_loc, nombre, apellido, email) values (?, ?, ?, ?, ?)" );
          st.setInt(1, _medico.getCod_especialidad());
          st.setInt(2, _medico.getCod_loc());
          st.setString(3, _medico.getNombre());
          st.setString(4, _medico.getApellido());
          st.setString(5, _medico.getEmail());
          st.executeUpdate();
          
        }catch (Exception e){
            System.out.println("Hay un Error Insertando");
            System.out.println(e);
        } finally {
            this.Cerrar();
        }
        
    }
    
       public List<Medico> listar() throws Exception{
        List<Medico> lista;
        ResultSet rs;
        
        try{
            this.Conectar();
            PreparedStatement st = this.getCn().prepareCall("select cod_medico, cod_especialidad, cod_loc, nombre, apellido, email from medico");
            System.out.println(st);
            rs = st.executeQuery();
            lista = new ArrayList();
            while(rs.next()){
                Medico _medico = new Medico();
                _medico.setCod_medico(rs.getInt("cod_medico"));
                _medico.setCod_especialidad(rs.getInt("cod_especialidad"));
                _medico.setCod_loc(rs.getInt("cod_loc"));
                _medico.setNombre(rs.getString("nombre"));
                _medico.setApellido(rs.getString("apellido"));
                _medico.setEmail(rs.getString("email"));
                
                lista.add(_medico);
                                
            }
        }catch(Exception e){
            System.out.println(e);
            throw e;
            
            
        }finally{
        this.Cerrar();
        }
        return lista;
    }
       
    public Medico leerID(Medico _medico) throws Exception{
    
    ResultSet rs;
    Medico _medicoout = null;
    
    try{
        this.Conectar();
        PreparedStatement st = this.getCn().prepareStatement("select cod_medico, cod_especialidad, cod_loc, nombre, apellido, email from medico where cod_medico = ?");
        st.setInt(1, _medico.getCod_medico());
        rs = st.executeQuery();
        while (rs.next()){
            
            _medicoout = new Medico();
            _medicoout.setCod_medico(rs.getInt("cod_medico"));
            _medicoout.setCod_especialidad(rs.getInt("cod_especialidad"));
            _medicoout.setCod_loc(rs.getInt("cod_loc"));
            _medicoout.setNombre(rs.getString("nombre"));
            _medicoout.setApellido(rs.getString("apellido"));
            _medicoout.setEmail(rs.getString("email"));
            
         }
        
    }catch(Exception e){
        throw e;
    }finally{
        this.Cerrar();
        
    }
            
    return _medicoout;
    
    }
    
    public void modificar(Medico _medico) throws Exception{
        
        try{
            this.Conectar();
            System.out.println("Conectado");
            System.out.println("EStoy en modificacion medicos");
            PreparedStatement st = this.getCn().prepareStatement("update medico set cod_especialidad = ?, cod_loc = ?, nombre = ?, apellido = ?, email = ? where cod_medico = ?");
            st.setInt(1, _medico.getCod_especialidad());
            st.setInt(2, _medico.getCod_loc());
            st.setString(3, _medico.getNombre());
            st.setString(4, _medico.getApellido());
            st.setString(5, _medico.getEmail());
            st.setInt(6, _medico.getCod_medico());
            st.executeUpdate();
            
        }catch(Exception e){
            System.out.println("No me pude conectar en la modificacion");
        }finally{
            
            this.Cerrar();
            
        }
       
    }
     
    public void eliminar(Medico _medico) throws Exception{
        
        try{
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("delete from medico where cod_medico = ?");
            st.setInt(1, _medico.getCod_medico());
            st.executeUpdate();
            
        }catch(Exception e){
            throw e;
            
            
        }finally{
            this.Cerrar();
            
        }
        
        
    }
    
     
}
