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
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestión de Pedidos - Zona Factura</title>
    </head>
    <body>

    <h1>Factura con fecha <%= new java.util.Date() %></h1>
    <hr>
    <h2>Datos del Cliente</h2>
    <table width="75%"  border="0" cellspacing="2">
  <tr>
    <td><b>Código</b></td>
    <td><b>N.I.F.</b></td>
    <td><b>Nombre</b></td>
    <td><b>Apellidos</b></td>
  </tr>
  <tr>
    <td><%=request.getParameter("txtOCodigo")%></td>
    <td><%=request.getParameter("txtONif")%></td>
    <td><%=request.getParameter("txtONombre")%></td>
    <td><%=request.getParameter("txtOApellidos")%></td>
  </tr>
  <tr>
    <td><b>Domicilio</b></td>
    <td><b>C. Postal</b></td>
    <td><b>Localidad</b></td>
    <td><b>Total Ventas</b></td>
  </tr>
  <tr>
    <td><%=request.getParameter("txtODomicilio")%></td>
    <td><%=request.getParameter("txtOCp")%></td>
    <td><%=request.getParameter("txtOLocalidad")%></td>
    <td><%=request.getParameter("txtOVentas")%></td>
  </tr>
</table>
    <hr>
    <h2>Datos del Pedido</h2>
    
    <%
       // Recuperamos el Vector con las lineas del pedido
       HttpSession sesion = request.getSession();
       Vector Vtmp = (Vector) sesion.getAttribute("VectorLineas");
       // Declaramos una variable para la suma Total
       int total = 0;
    %>

  <table width="75%"  border="0" cellspacing="2">
  <tr>
    <td><b>Artículo</b></td>
    <td><b>Descripción</b></td>
    <td><b>Unidades</b></td>
    <td><b>Precio</b></td>
    <td><b>Importe</b></td>

  </tr>
  <%

    // Bucle que se repite tantas veces como lineas de pedido tengamos
    for (int cont=0;cont<Vtmp.size();cont++)
       {
        // Metemos el elemento cont en un objeto LineaFacturaWeb temporal
        LineaFacturaWeb temp = (LineaFacturaWeb) Vtmp.elementAt(cont);
  %>
  <tr>
    <td><%=temp.getArticulo()%></td>
    <td><%=temp.getDescripcion()%></td>
    <td><%=temp.getUnidades()%></td>
    <td><%=temp.getPrecio()%></td>
    <td><%=temp.getImporte()%> €</td>
  </tr>
  <%
    // Sumamos al Total
    total = total + temp.ImporteEntero();
    }
    // Fin del bucle
  %>
</table>
<h2>Importe del Pedido: <%=total%></h2>
    
    <%
    GestorBD conexion = new GestorBD();
    conexion.PedidoWeb(Vtmp,request.getParameter("txtOCodigo"));    
    %>
    
    
    <hr>
    <h5>El pedido ha sido procesado y admitido a trámite.
    En el plazo de una semana lo recibirá en su domicilio.</h5>
    <br><br>
    <form><input type="button" name="imprimir" value="Imprimir" onclick="window.print();"> | <a href="index.jsp">Página Principal</a></form>
    
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
