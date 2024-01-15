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
        <title>Gestión de Pedidos - Zona Pedidos</title>
    </head>
    <body>

    <h1>Gestión de Pedidos</h1>
    
    
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
    <h2>Pedido Realizado</h2><br>

    <%
       // Recuperamos el Vector con las lineas del pedido
       HttpSession sesion = request.getSession();
       Vector Vtmp = (Vector) sesion.getAttribute("VectorLineas");
       // Declaramos una variable para la suma Total
       int total = 0;
    %>

    <%
    // Guardamos El artículo, su descripción, las unidades, precio e importe
    // en un objeto de clase LineaFacturaWeb
         LineaFacturaWeb linea = new LineaFacturaWeb();
         linea.setArticulo(request.getParameter("txtOCodigoa"));
         linea.setDescripcion(request.getParameter("txtODescripcion"));
         linea.setUnidades(request.getParameter("txtUnidades"));
         linea.setPrecio(request.getParameter("txtOPrecio"));
         linea.setImporte(request.getParameter("txtPrecio"));

    // Añadimos la línea nueva
       Vtmp.addElement(linea);

    // Y restauramos el Vector
       sesion.setAttribute("VectorLineas",Vtmp);
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
<hr>
    <form name="formulariofinal" method="POST" action="Factura.jsp">
        
        <input type=hidden name="txtOCodigo" value="<%=request.getParameter("txtOCodigo")%>">
        <input type=hidden name="txtONif" value="<%=request.getParameter("txtONif")%>">
        <input type=hidden name="txtONombre" value="<%=request.getParameter("txtONombre")%>">
        <input type=hidden name="txtOApellidos" value="<%=request.getParameter("txtOApellidos")%>">
        <input type=hidden name="txtODomicilio" value="<%=request.getParameter("txtODomicilio")%>">
        <input type=hidden name="txtOCp" value="<%=request.getParameter("txtOCp")%>">
        <input type=hidden name="txtOLocalidad" value="<%=request.getParameter("txtOLocalidad")%>">
        <input type=hidden name="txtOVentas" value="<%=request.getParameter("txtOVentas")%>">
        
        <input type="submit" value="Aceptar Pedido" name="enviar">
    </form>
    <a href="PedidosBuscarClientes.jsp?txtCodigo=<%=request.getParameter("txtOCodigo")%>">Nuevo Artículo</a> | <a href="index.jsp">Página Principal</a>
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
