/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;
import static java.lang.Math.*;

/**
 *
 * @author A
 */
public class modelo_calculo {
    
    private String operacion;
    private String operador;
    private String[] expresion_matematica;
    private double primernumero;
    private double segundonumero;
    private double memoria;
    
    
    //El siguiente metodo toma una expresion matematica y la hace en un arreglo
    
    public modelo_calculo(String operacion, Double memoria) {
        this.operacion = operacion;
        this.memoria = memoria;
        expresion_matematica = operacion.split("\\s+"); // Se guarda en un array.
        
        
    }
    
    public Double getMemoria(){
        return memoria;
    }
    
    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

   
    public String resultado(){
        
        String resultado="";
        int longitud;
        
        //Longitud de la frase matematica recibida:
        longitud = expresion_matematica.length;
        
        if (longitud == 2)
            
        {
            
            operador = expresion_matematica[0];
           
            
            //El siguiente Try-Catch elimina muchos dolobres de cabeza
            // en cuanto a validaciones.
            
             try {
                    primernumero = Double.parseDouble(expresion_matematica[1]);
        
                 } catch (NumberFormatException ignore) {
                    operador = "error";
                    primernumero = 0;
                }
           
            //Discrimina si son las teclas de memoria.
            if ("MC".equals(operador) || "M+".equals(operador) || "M-".equals(operador) || "MR".equals(operador))
            {
                resultado = memory_func(operador, primernumero);   
            }
            
             else
            {
                resultado = String.valueOf(calculo_una(operador, primernumero));
            }
            
            if ("error".equals(operador)){
               resultado = "Error";
            }
           
         
            
            
        }
        
        if (longitud == 3)
            
        {
            operador = expresion_matematica[1];
            
            //Los siguientes try catch eliminan mucho dolor de cabeza
            // en cuanto a errores
            
             try {
                    primernumero = Double.parseDouble(expresion_matematica[0]);
        
                } catch (NumberFormatException ignore) {
                    operador = "error";
                    primernumero = 0;
                }
            
               try {
                    segundonumero = Double.parseDouble(expresion_matematica[2]);
        
                } catch (NumberFormatException ignore) {
                    operador = "error";
                    segundonumero = 0;
                }
                  
               if ("error".equals(operador)){
               resultado = "Error";
               }
               else{
               resultado = String.valueOf(calculo_bin(primernumero, segundonumero, operador));    
               }
            
            
        }
        
        if (longitud > 3)
        {
            
            resultado = "Too Many Arguments";
            
        }
    
        return resultado;
    }           
                
        
       
    
    
    //El siguiente metodo va a discernir que tipo de operacion debe de realizar
    // con un select case y devuelve un valor.
    public double calculo_bin(double primernumero, double segundonumero, String operador)
    {
        
        double calculo = 0;
        switch (operador)
        {
            case "+":
                calculo = primernumero + segundonumero;
                break;
            case "-":
                calculo = primernumero - segundonumero;
                break;
            case "/":
                calculo = primernumero / segundonumero;
                break;
            case "*":
                calculo = primernumero * segundonumero;
                break;
            case "xy":
                calculo = pow(primernumero, segundonumero);
                break;
            case "sqrt":
                calculo = pow(segundonumero, 1/primernumero);
                    
        }
        
        
        return calculo;
        
    }
    
    public double calculo_una(String operador, double primernumero)
    {
        
        
        double calculo = 0;
        switch (operador)
        {
            case "log":
                calculo = log(primernumero);
                break;
            case "ln":
                calculo = log(primernumero)/log(10);
                 break;
            case "sqrt":
                calculo = sqrt(primernumero);
                break;
            case "sin":
                calculo = sin(primernumero);
                break;
            case "cos":
                calculo = cos(primernumero);
                break;
            case "tan":
                calculo = tan(primernumero);
                break;
            case "x3":
                calculo = pow(primernumero, 3);
                break;
            case "asin":
                calculo = asin(primernumero);
                break;
            case "acosin":
                calculo = acos(primernumero);
                break;
            case "atan":
                calculo = atan(primernumero);
                break;
            case "%":
                calculo = primernumero/100;
                break;
            case "10x":
                calculo = pow(10, primernumero);
                break;
            case "x2":
                calculo = pow(primernumero, 2);
                break;
        
            
            
                
        }
        
        
        return calculo;
        
    }
    
    public String memory_func(String operador, double primernumero)
    {
        String memory_status="";
        
        if ("M+".equals(operador))
        {
            
            memoria = memoria + primernumero;
            memory_status = "Memory Added";
            
        }
        
        if ("M-".equals(operador))
        {
            memoria = memoria - primernumero;
            memory_status = "Memory Diminished";
        }
        
        if ("MR".equals(operador)){
            memory_status = String.valueOf(memoria);
            
        }
        
          if ("MC".equals(operador)){
            memoria = 0;
            memory_status = "Memory Cleared";
        }
        
        
        
        return memory_status;
    }
    
}
