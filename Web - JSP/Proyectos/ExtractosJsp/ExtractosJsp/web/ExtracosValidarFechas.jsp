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
 <%@page import="java.util.Vector"%>
 
     <%!
        String Rellena(String cadena,int numerodeceros){
        while (cadena.length() < numerodeceros)
            cadena="0"+cadena;     // Concatenación ;)
        return cadena;
       }
    %>
 
 
<html>
    
    <%
    // Recupero el cliente
    
    HttpSession sesion = request.getSession();
    Cliente cli = (Cliente) sesion.getAttribute("cliente");
    %>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestión de Extractos - Registros entre las dos Fechas</title>
    </head>
    <body>

    
    <h1>Gestión de Extractos</h1>
    
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

<%
    /* Ahora Realizaremos laconexión a la base de datos, y miraremos si existen
       pedidos entre las fechas, que recuperaremos mediante un request.       */

       String desde = new String();
       desde = desde + Rellena(request.getParameter("ano_desde"),4) + "/";
       desde = desde + Rellena(request.getParameter("mes_desde"),2) + "/";
       desde = desde + Rellena(request.getParameter("dia_desde"),2);

       String hasta = new String();
       hasta = hasta + Rellena(request.getParameter("ano_hasta"),4) + "/";
       hasta = hasta + Rellena(request.getParameter("mes_hasta"),2) + "/";
       hasta = hasta + Rellena(request.getParameter("dia_hasta"),2);      

       GestorBD conexion = new GestorBD();

       Vector Vlineas = new Vector();

       Vlineas = (Vector) conexion.ExtracosEntreFechas(desde,hasta,Rellena(cli.getCodigo(),6));

    %>
    
    <%
    if (Vlineas.size()==0)
        {
    %>
    <h2>No hay Extractos que mostrar</h2>
    <h3>entre las fechas <%=desde%> y <%=hasta%></h3>

    <%}
       
       else
       {%>
 <h2>Extracto de Pedidos</h2>
    <h3>entre las fechas <%=desde%> y <%=hasta%></h3>
  <table width="50%"  border="0" cellspacing="2">
  <tr>
    <td><b>Fecha</b></td>
    <td><b>Artículo</b></td>
    <td><b>Unidades</b></td>

  </tr>
  <%

    // Bucle que se repite tantas veces como lineas de pedido tengamos
    for (int cont=0;cont<Vlineas.size();cont++)
       {
        // Metemos el elemento cont en un objeto LineaFacturaWeb temporal
        LineaFacturaWeb temp = (LineaFacturaWeb) Vlineas.elementAt(cont);
  %>
  <tr>
    <td><%=temp.getFecha()%></td>
    <td><%=temp.getArticulo()%></td>
    <td><%=temp.getUnidades()%></td>
  </tr>
  <%}// Fin del bucle %>
</table>
    
    <%}
       // Fin del Else%>
    
    
       <hr>
       <form name="volver" method="get" action="ExtractosBuscarClientes.jsp">
           <input type="hidden" name="txtCodigo">
            <input type="submit" value="Nuevas Fechas" onclick="document.volver.txtCodigo.value=<%=cli.getCodigo()%>">
        </form>
    <a href="PedidosCodCli.jsp?opcion=Extractos">Nuevo Cliente</a> | <a href="index.jsp">Página Principal</a>
    
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
