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
import model.Ponencia_Medico;



/**
 *
 * @author A
 */
public class Ponencia_MedicoCNX extends conector {
    
    public void registrar(Ponencia_Medico _ponencia_medico)
    {
        try {
          this.Conectar();  
          PreparedStatement st = this.getCn().prepareStatement("insert into ponencia_medico (cod_medico, cod_ponencia) values (?,?)" );
          st.setInt(1, _ponencia_medico.getCod_medico());
          st.setInt(2, _ponencia_medico.getCod_ponencia());
          st.executeUpdate();
          
        }catch (Exception e){
            System.out.println("Hay un Error Insertando");
            System.out.println(e);
        } finally {
            this.Cerrar();
        }
        
    }
    
       public List<Ponencia_Medico> listar() throws Exception{
        List<Ponencia_Medico> lista;
        ResultSet rs;
        
        try{
            this.Conectar();
            PreparedStatement st = this.getCn().prepareCall("select cod_pm, cod_medico, cod_ponencia from Ponencia_Medico");
            System.out.println(st);
            rs = st.executeQuery();
            lista = new ArrayList();
            while(rs.next()){
                Ponencia_Medico _ponencia_medico = new Ponencia_Medico();
                _ponencia_medico.setCod_pm(rs.getInt("cod_pm"));
                _ponencia_medico.setCod_medico(rs.getInt("cod_medico"));
                _ponencia_medico.setCod_ponencia(rs.getInt("cod_ponencia"));
                lista.add(_ponencia_medico);
                                                              
            }
        }catch(Exception e){
            System.out.println("Hubo un problema listando");
            System.out.println(e);
            throw e;
            
            
        }finally{
        this.Cerrar();
        }
        return lista;
    }
       
    public Ponencia_Medico leerID(Ponencia_Medico _ponencia_medico) throws Exception{
    
    ResultSet rs;
    Ponencia_Medico _ponencia_medicoout = null;
    
    try{
        this.Conectar();
        PreparedStatement st = this.getCn().prepareStatement("select cod_pm, cod_medico, cod_ponencia from ponencia_medico where cod_pm = ?");
        st.setInt(1, _ponencia_medico.getCod_pm());
        rs = st.executeQuery();
        while (rs.next()){
            
            _ponencia_medicoout = new Ponencia_Medico();
            _ponencia_medicoout.setCod_pm(rs.getInt("cod_pm"));
            _ponencia_medicoout.setCod_medico(rs.getInt("cod_medico"));
            _ponencia_medicoout.setCod_ponencia(rs.getInt("cod_ponencia"));
        }
        
    }catch(Exception e){
        throw e;
    }finally{
        this.Cerrar();
        
    }
            
    return _ponencia_medicoout;
    
    }
    
    public void modificar(Ponencia_Medico _ponencia_medico) throws Exception{
        
        try{
            this.Conectar();
            System.out.println("Conectado");
            PreparedStatement st = this.getCn().prepareStatement("update ponencia_medico set cod_medico = ?, cod_ponencia = ? where cod_pm = ?");
            
            st.setInt(1, _ponencia_medico.getCod_medico());
            st.setInt(2, _ponencia_medico.getCod_ponencia());
            st.setInt(3, _ponencia_medico.getCod_pm());
            st.executeUpdate();
            
        }catch(Exception e){
            System.out.println("No me pude conectar en la modificacion");
        }finally{
            
            this.Cerrar();
            
        }
       
    }
     
    public void eliminar(Ponencia_Medico _ponencia_medico) throws Exception{
        
        try{
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("DELETE FROM ponencia_medico WHERE cod_pm = ?");
            st.setInt(1, _ponencia_medico.getCod_pm());
            st.executeUpdate();
            
        }catch(Exception e){
            throw e;
            
            
        }finally{
            this.Cerrar();
            
        }
        
        
    }
    
     
}
