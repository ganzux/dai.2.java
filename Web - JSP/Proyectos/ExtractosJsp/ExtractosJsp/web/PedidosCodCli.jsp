<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%--
The taglib directive below imports the JSTL library. If you uncomment it,
you must also add the JSTL library to the project. The Add Library... action
on Libraries node in Projects view can be used to add the JSTL 1.1 library.
--%>
<%--
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
--%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
    <%@page import="java.util.Vector"%>  

    <%

       // Vamos a crear un objeto de sesión, que almacenará un Vector de lineas
        HttpSession sesion = request.getSession();
       // Borramos todo elcontenido que pueda tener
        Vector lineas = new Vector();
        sesion.setAttribute("VectorLineas",lineas);

    %>    
   
   
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestión de 
        <% if (request.getParameter("opcion").compareTo("Pedidos")==0)
            {%>
                        Pedidos
        <% }else{%>
                        Extractos<%}%>
        - Introducir Cliente</title>
    </head>
    <body onload="document.formulario.txtCodigo.focus()">
    <h1>Gestión de<% if (request.getParameter("opcion").compareTo("Pedidos")==0)
            {%>
                        Pedidos
        <% }else{%>
                        Extractos<%}%>
    </h1>
    <br><br>
    <form name="formulario" action=<% if (request.getParameter("opcion").compareTo("Pedidos")==0)
            {%>    
                    "PedidosBuscarClientes.jsp"
           <% }else{%>
                    "ExtractosBuscarClientes.jsp"<%}%>      
                    
        method="post" onsubmit="return Comprueba()">
        Código de Cliente <input type="text" name="txtCodigo">
        <br><br>
        <input type="submit" value="Aceptar">
        <input type="reset" value="Cancelar" onclick="document.formulario.txtCodigo.focus()">
    </form>
    <br><br>
    <a href="index.jsp">Página Principal</a>
    
    
<script language="JavaScript" type="text/javascript">
            
    function Comprueba() {
            
        with (document.formulario.txtCodigo) {               
            if (value=="") {
                alert("No ha introducido el código")
                focus()
                return false
                            }

            else {
                return true
                }
        }
    }
            
</script>


    
    
    <%--
    This example uses JSTL, uncomment the taglib directive above.
    To test, display the page like this: index.jsp?sayHello=true&name=Murphy
    --%>
    <%--
    <c:if test="${param.sayHello}">
        <!-- Let's welcome the user ${param.name} -->
        Hello ${param.name}!
    </c:if>
    --%>
    
    </body>
</html>
