/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author A
 */
public class conector {
    
    private Connection cn;
    private String host="localhost";
    private String database="congresos";
    private String usuario="root";
    private String contrasena="123456";
    private String port="3306";
    private String url="jdbc:mysql://localhost/" + database;
    
   

    public Connection getCn() {
        return cn;
    }

    public void setCn(Connection cn) {
        this.cn = cn;
    }
    
    public void Conectar() throws SQLException{
        
       try {
            System.out.println("Cargando Driver");
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver cargado");
            System.out.println("Conectando a Base de Datos");
            cn = DriverManager.getConnection(url, usuario, contrasena);
            System.out.println("Conectado");
            
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Cannot find the driver in the classpath!", e);
}


    }   
   
    public void Cerrar()
    {
        
        if (cn != null)
        {  
            try 
            {
                if (cn.isClosed() == false)
                {
                    cn.close();  
                }
            }
            catch(Exception e)
            {
                    System.out.println("No puedo cerrar conexion SQL");
                    System.out.println(e);
            }             
        }
    }
        
}
        

          
    
    

