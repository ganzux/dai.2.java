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
    <%@page import="gestionpedidos.*"%>
    
    <%!
        String Rellena(String cadena,int numerodeceros){
        while (cadena.length() < numerodeceros)
            cadena="0"+cadena;     // Concatenación ;)
        return cadena;
       }
    %>
    
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestión de Pedidos - Zona Cliente</title>
    </head>
    <body onload="document.formulario.txtArticulo.focus()">

    <h1>Gestión de Pedidos</h1>

    <%
        // Realizamos la conexion con la BD
        GestorBD conexion = new GestorBD();
        // Buscamos el cliente y lo guardamos
        String codigo = Rellena(request.getParameter("txtCodigo"),6);
        
        Cliente cli;
        
        cli = conexion.BuscarCliente(codigo,"clientes");
        
        // Si el cliente no existe que lo diga
        if (cli.getCodigo() == null){
    %>
        <h2>El Cliente con código <%=codigo%> No existe</h2>
    <%
        }
        
        // Sin embargo, si existe el cliente, que lo muestre
        else{
    
    %>

    <h2>Datos del Cliente</h2>
    <table width="75%"  border="0" cellspacing="2">
  <tr>
    <td><b>Código</b></td>
    <td><b>N.I.F.</b></td>
    <td><b>Nombre</b></td>
    <td><b>Apellidos</b></td>
  </tr>
  <tr>
    <td><%=cli.getCodigo()%></td>
    <td><%=cli.getNif()%></td>
    <td><%=cli.getNombre()%></td>
    <td><%=cli.getApellidos()%></td>
  </tr>
  <tr>
    <td><b>Domicilio</b></td>
    <td><b>C. Postal</b></td>
    <td><b>Localidad</b></td>
    <td><b>Total Ventas</b></td>
  </tr>
  <tr>
    <td><%=cli.getDomicilio()%></td>
    <td><%=cli.getCp()%></td>
    <td><%=cli.getLocalidad()%></td>
    <td><%=cli.getVentas()%></td>
  </tr>
</table>
<hr>
    <h2>Realizar Pedido</h2><br>
    <form name="formulario" action="PedidosBuscarArticulo.jsp" method="post" onsubmit="return Comprueba()">
        Artículo <input type="text" name="txtArticulo">
        <br><br>
        <input type="submit" value="Aceptar">
        
        <input type=hidden name="txtOCodigo" value="<%=cli.getCodigo()%>">
        <input type=hidden name="txtONif" value="<%=cli.getNif()%>">
        <input type=hidden name="txtONombre" value="<%=cli.getNombre()%>">
        <input type=hidden name="txtOApellidos" value="<%=cli.getApellidos()%>">
        <input type=hidden name="txtODomicilio" value="<%=cli.getDomicilio()%>">
        <input type=hidden name="txtOCp" value="<%=cli.getCp()%>">
        <input type=hidden name="txtOLocalidad" value="<%=cli.getLocalidad()%>">
        <input type=hidden name="txtOVentas" value="<%=cli.getVentas()%>">
        
        <input type="reset" value="Cancelar" onclick="document.formulario.txtArticulo.focus()">
    </form>
<hr>
    <%}// Else de que Sí exista Cliente%>
  
    
    <br>
    <a href="PedidosCodCli.jsp?opcion=Pedidos">Nuevo Cliente</a> | <a href="index.jsp">Página Principal</a>
    
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
    
    <script language="JavaScript" type="text/javascript">
            
    function Comprueba() {
            
        with (document.formulario.txtArticulo) {               
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
    
</html>
