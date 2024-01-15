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
        <title>Gestión de Pedidos - Zona Artículos</title>
    </head>
    <body onload="document.formulario.txtUnidades.focus()">

    <h1>Gestión de Pedidos</h1>
    
        <%
        GestorBD conexion = new GestorBD();
        String codigo = Rellena(request.getParameter("txtArticulo"),6);
        Articulo art;
        art = conexion.BuscarArticulo(codigo);
        // Si el articulo no existe que lo diga
        if (art.getCodigo() == null){
    %>
        <h2>El Artículo con código <%=codigo%> No existe</h2>
    <%
        }
        
        // Sin embargo, si existe el articulo, que lo muestre, junto con el cliente
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
    <h2>Realizar Pedido</h2><br>
    
    <table width="75%"  border="0" cellspacing="2">
  <tr>
    <td><b>Artículo</b></td>
    <td><b>Descripción</b></td>
    <td><b>Unidades</b></td>
    <td><b>Precio</b></td>
    <td><b>Importe</b></td>

  </tr>
  <tr>
    <td><%=art.getCodigo()%></td>
    <td><%=art.getDescripcion()%></td>
    <td><form name="formulario" action="Pedidos.jsp" method="post" onsubmit="return Comprueba()">
    <input type="text" name="txtUnidades" size="9" maxlength="5" onkeyup="CalculaImporte(event)"></td>
    <td><%=art.getPrecioventa()%></td>
    <td><input type="text" name="txtPrecio"></td>
  </tr>
</table>

    <input type=hidden name="txtOCodigo" value="<%=request.getParameter("txtOCodigo")%>">
    <input type=hidden name="txtONif" value="<%=request.getParameter("txtONif")%>">
    <input type=hidden name="txtONombre" value="<%=request.getParameter("txtONombre")%>">
    <input type=hidden name="txtOApellidos" value="<%=request.getParameter("txtOApellidos")%>">
    <input type=hidden name="txtODomicilio" value="<%=request.getParameter("txtODomicilio")%>">
    <input type=hidden name="txtOCp" value="<%=request.getParameter("txtOCp")%>">
    <input type=hidden name="txtOLocalidad" value="<%=request.getParameter("txtOLocalidad")%>">
    <input type=hidden name="txtOVentas" value="<%=request.getParameter("txtOVentas")%>">

    <input type=hidden name="txtOCodigoa" value="<%=art.getCodigo()%>">
    <input type=hidden name="txtODescripcion" value="<%=art.getDescripcion()%>">
    <input type=hidden name="txtOPrecio" value="<%=art.getPrecioventa()%>">

    <input type="submit" name="aceptar" value="Aceptar">
    <input type="reset" name="cancelar" value="Cancelar" onclick="document.formulario.txtUnidades.focus()">
</form>

    <%}// Fin del Else, que exista el artículo%>

        <hr>
    <a href="PedidosBuscarClientes.jsp?txtCodigo=<%=request.getParameter("txtOCodigo")%>">Nuevo Artículo</a> | <a href="index.jsp">Página Principal</a>

    
    
    <script language="JavaScript" type="text/javascript">

    function CalculaImporte(event)
    {
        with (document.formulario.txtUnidades) 
        {
        
      //No saltará la alerta: Números normales, teclado numérico, del, supr, flechas e intro
        
            if ( (event.keyCode < 48 || event.keyCode > 57) && (event.keyCode < 96 || event.keyCode > 105) && event.keyCode != 8 && event.keyCode != 37 && event.keyCode != 38 && event.keyCode != 39 && event.keyCode != 40 && event.keyCode != 46 && event.keyCode != 13 )
                {
                alert("Sólo Números")
                value=""
                document.formulario.txtPrecio.value=""
                }

            else
                {
		document.formulario.txtPrecio.value=value*<%=art.getPrecioventa()%>
                }
        }
    }
    
        function Comprueba() {
            
        with (document.formulario.txtUnidades) {               
            if (value=="" || value=="0") {
                alert("No ha introducido Unidades")
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
