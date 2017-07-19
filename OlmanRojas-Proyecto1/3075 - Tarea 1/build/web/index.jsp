<%-- 
    Document   : newjsp
    Created on : Feb 23, 2015, 7:40:00 PM
    Author     : A
--%>
<%@page import="model.modelo_calculo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% modelo_calculo mod_cal = (modelo_calculo)request.getSession().getAttribute("gvar_mod_cal");  %>
<!DOCTYPE html>
<html>
<body>
<head>
<script language="javascript" type="text/javascript">

        function display(valor){
            document.calculadora.pantalla.value+=valor;
            return false;
      
        }
       
        function memories(valor){
            
            variable = document.calculadora.pantalla.value;
            document.calculadora.pantalla.value = valor + variable;
            document.calculadora.submit();
            return false;
        }
		
        function cleardisplay(){
            document.calculadora.pantalla.value="";
            return false;
        }
		
        function submitform(){
            document.calculadora.submit();
        }

</script>  



<title> Calculadora </title>
<link rel="stylesheet" type="text/css" href="calculadora.css">
</head>

<br><br>
Calculadora <h1>
<br>


<form name="calculadora" action="control_calculo.do" method="post">
    <input type="hidden" name="initial" value="1">
<div class="box">


	<div class="pantalla_class">
        <%
        if(request.getParameter("initial") == null)
            {
               out.write("<input type=\"text\" name=\"pantalla\" value=\"\" size\"40\">"); 
            }
        else
            {
                out.write("<input type=\"text\" name=\"pantalla\" value=\"" + mod_cal.resultado() + "\" size\"40\">");
            }
        %> 
      	
	</div>

		
	<br>
	<div class="keys">
	
        <button class="button blue" onClick="return memories('MC 1')">MC</button>
        <button class="button blue" onClick="return memories('M+ ')">M+</button>
        <button class="button blue" onClick="return memories('M- ')">M-</button>
        <button class="button blue" onClick="return memories('MR 1')">MR</button>
        <button class="button red" onClick="return cleardisplay()">C</button>
        <br>
        <button class="button cal" onClick="return display('% ')">%</button>
        <button class="button cal" onClick="return display('asin ')">sin<sup>-1</sup></button>
        <button class="button cal" onClick="return display('sin ')">sin</button>
		<button class="button cal" onClick="return display('ln ')">ln</button>
		<button class="button num" onClick="return display('7')">7</button>
		<button class="button num" onClick="return display('8')">8</button>
        <button class="button num" onClick="return display('9')">9</button>
        <button class="button num" onClick="return display(' / ')">/</button>
		<br>
        <button class="button cal" onClick="return display('10x ')">10<sup>x</sup></button>
        <button class="button cal" onClick="return display('acosin ')">cos<sup>-1</sup></button>
        <button class="button cal" onClick="return display('cos ')">cos</button>
		<button class="button cal" onClick="return display('log ')">log</button>
		<button class="button num" onClick="return display('4')">4</button>
        <button class="button num" onClick="return display('5')">5</button>
		<button class="button num" onClick="return display('6')">6</button>
		<button class="button num" onClick="return display(' * ')">*</button>		
		<br>
        <button class="button cal" onClick="return display('x2 ')">x<sup>2</sup></button>	
        <button class="button cal" onClick="return display('atan ')">tan<sup>-1</sup></button>	
		<button class="button cal" onClick="return display('tan ')">tan</button>	
        <button class="button cal" onClick="return display('sqrt ')">&radic;</button>	
        <button class="button num" onClick="return display('1')">1</button>	
		<button class="button num" onClick="return display('2')">2</button>	
		<button class="button num" onClick="return display('3')">3</button>	
		<button class="button num" onClick="return display(' - ')">-</button>	
		<br>
        <button class="button cal"  onClick="return display('3 sqrt ')"> 
            <span class="radical"><span class="n-root">3</span>&radic;</span><span class="radicand">x</span>
        </button>
        <button class="button cal"  onClick="return display(' sqrt ')"> 
            <span class="radical"><span class="n-root">y</span>&radic;</span><span class="radicand">x</span>
        </button>
        <button class="button cal" onClick="return display('x3 ')">x<sup>3</sup></button>	
        <button class="button cal" onClick="return display(' xy ')">x<sup>y</sup></button>	
        <button class="button num" onClick="return display('0')">0</button>	
        <button class="button num" onClick="return display('.')">.</button>	
		<button class="button orange" onClick=submitform();>=</button>	
		<button class="button num" onClick="return display(' + ')">+</button>	
		
	</div>
</div>




</form>




</body>
</html>
