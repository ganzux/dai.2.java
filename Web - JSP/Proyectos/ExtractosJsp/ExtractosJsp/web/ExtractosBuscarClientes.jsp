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
        <title>Gestión de Extractos - Zona de Selección</title>
    </head>
    <body>

    <h1>Gestión de Extractos</h1>
    
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
            
       // Lo primero va a ser crear un objeto de tipo Cliente y recuperar el año del sistema

       HttpSession sesion = request.getSession();
       sesion.setAttribute("cliente",cli);
       int ano_actual = Integer.valueOf((String)sesion.getAttribute("ano_actual")).intValue();
    
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
    <h1>Fechas del Extracto</h1>
    
    <table width="50%"  border="0" cellspacing="5">
  <tr>
    <td><u>Desde</u></td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td><u>Hasta</u></td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td><b>A&ntilde;o</b></td>
    <td><b>Mes</b></td>
    <td><b>D&iacute;a</b></td>
    <td>&nbsp;</td>
    <td><b>A&ntilde;o</b></td>
    <td><b>Mes</b></td>
    <td><b>D&iacute;a</b></td>
  </tr>
  <tr><form name="desde">
    <td><select name="anios" onchange="CompruebaDesde()">
        <%int i=0;
        for (i=0;i<6;i++){%>
      <option value="<%=ano_actual-i%>"><%=ano_actual-i%></option>
      <%}%>
    </select></td>
    <td><select name="meses" onchange="CompruebaDesde()">
        <%
        for (i=1;i<13;i++){%>
      <option value="<%=i%>"><%=i%></option>
      <%}%>
    </select></td>
    <td><select name="dias">
       <%
        for (i=1;i<32;i++){%>
      <option value="<%=i%>"><%=i%></option>
      <%}%>
    </select></td>
	</form>
    <td>&nbsp;</td>
    <form name="hasta">
    <td><select name="anios" onchange="CompruebaHasta()">
       <%
        for (i=0;i<6;i++){%>
      <option value="<%=ano_actual-i%>"><%=ano_actual-i%></option>
      <%}%>
    </select></td>
    <td><select name="meses" onchange="CompruebaHasta()">
       <%
        for (i=1;i<13;i++){%>
      <option value="<%=i%>"><%=i%></option>
      <%}%>
    </select></td>
    <td><select name="dias">
       <%
        for (i=1;i<32;i++){%>
      <option value="<%=i%>"><%=i%></option>
      <%}%>
    </select></td>
	</form>
        
  </tr>
</table>

        <form name="envio" method="GET" action="ExtracosValidarFechas.jsp">
            <input type="submit" value="Enviar" onclick="Actualiza()">
            
            <input type=hidden name="dia_desde">
            <input type=hidden name="mes_desde">
            <input type=hidden name="ano_desde">
            <input type=hidden name="dia_hasta">
            <input type=hidden name="mes_hasta">
            <input type=hidden name="ano_hasta">
            
        </form>

 <%}// Else de que Sí exista Cliente%>
 
  <br>
    <a href="PedidosCodCli.jsp?opcion=Extractos">Nuevo Cliente</a> | <a href="index.jsp">Página Principal</a>
 
    <script language="JavaScript" type="text/javascript">
        
        // Recibe los días y genera todo en el formulario desde
        function CambiaDesde(dias_reales)
            {
            var a=0
            
            // Primero añadimos los días, del 1 al dias_reales
            for (a=0;a<dias_reales;a=a+1)
                {
                document.desde.dias.options[a]=new Option(a+1,a+1)
                }
            
            // Ahora eliminamos lo que sobran; hay que tener en cuenta que el array
            // se corre automáticamente, por ello siempre eliminaremos el elemento
            // que ocupe la posición siguiente al número de días reales.
            for (a=dias_reales;a<31;a++)
                {
                document.desde.dias.options[dias_reales]=null
                }
            }
 
            
        // Recibe los días y genera todo en el formulario hasta
        function CambiaHasta(dias_reales)
            {
            var a=0
            
            // Primero añadimos los días, del 1 al dias_reales
            for (a=0;a<dias_reales;a=a+1)
                {
                document.hasta.dias.options[a]=new Option(a+1,a+1)
                }
            
            // Ahora eliminamos lo que sobran; hay que tener en cuenta que el array
            // se corre automáticamente, por ello siempre eliminaremos el elemento
            // que ocupe la posición siguiente al número de días reales.
            for (a=dias_reales;a<31;a++)
                {
                document.hasta.dias.options[dias_reales]=null
                }
            }           
        
        function CompruebaDesde()
        {
        
        if (document.desde.meses.value == '2')
            {
            if ( Number(document.desde.anios.value) % 4 == 0)
                {
                CambiaDesde(29)
                }
            else
                {
                CambiaDesde(28)
                }
            }
        
        else 
            {
            switch (document.desde.meses.value)
            {
            // Meses de 31 días
            case '1':
            case '3':
            case '5':
            case '7':
            case '8':
            case '10':
            case '12':
                CambiaDesde(31)
            break
            
            // Meses de 30 días
            case '4':
            case '6':
            case '9':
            case '11':
                CambiaDesde(30)
            break  
            }
           }
        }
        
        
        
        function CompruebaHasta()
        {
        
        if (document.hasta.meses.value == '2')
            {
            if ( Number(document.hasta.anios.value) % 4 == 0)
                {
                CambiaHasta(29)
                }
            else
                {
                CambiaHasta(28)
                }
            }
        
        else 
            {
            switch (document.hasta.meses.value)
            {
            // Meses de 31 días
            case '1':
            case '3':
            case '5':
            case '7':
            case '8':
            case '10':
            case '12':
                CambiaHasta(31)
            break
            
            // Meses de 30 días
            case '4':
            case '6':
            case '9':
            case '11':
                CambiaHasta(30)
            break  
            }
           }
        }
        
        function Actualiza()
            {
            document.envio.dia_desde.value = document.desde.dias.value
            document.envio.mes_desde.value = document.desde.meses.value
            document.envio.ano_desde.value = document.desde.anios.value
            
            document.envio.dia_hasta.value = document.hasta.dias.value
            document.envio.mes_hasta.value = document.hasta.meses.value
            document.envio.ano_hasta.value = document.hasta.anios.value            
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
