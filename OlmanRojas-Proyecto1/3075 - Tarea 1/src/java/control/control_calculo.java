/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.modelo_calculo;



/**
 *
 * @author A
 */
public class control_calculo extends HttpServlet {
    
    Double memoria;

    

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         
        //La siguiente sesion es para crear la variable de memoria
        //Debido a que los metodos se destruyen, conservando la variable
        // En memoria y luego dirigiendola al metodo principal
        // Se puede conservar.
        
        HttpSession mySession = request.getSession();
        Double mem_ses = (Double)mySession.getAttribute("mem_ses");
        
        //La primera llamada será nula, se cambia por un valor numerico
        if (mem_ses == null){
            mem_ses = 0.00;
        }
       
        //Aqui se toma el valor de la pantalla para procesamiento
        String operacion = request.getParameter("pantalla");
        
        //Se manda el valor actual de la pantalla y la memoria en sesion
        //Este metodo hace toda la magia y sabe donde debe hacer el parsing.
        modelo_calculo mod_cal = new modelo_calculo(operacion, mem_ses);
        
        //El siguiente session toma la instancia y la guarda en sesion para
        //Poderla utilizar en el JSP principal
        request.getSession().setAttribute("gvar_mod_cal", mod_cal);
        request.getRequestDispatcher("index.jsp").forward(request, response);
        
        //Tomamos el nuevo valor de la memoria y actualizamos la sesion.
        Double mem_mod_cal = mod_cal.getMemoria();
        mySession.setAttribute("mem_ses", mem_mod_cal);
        
         
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
