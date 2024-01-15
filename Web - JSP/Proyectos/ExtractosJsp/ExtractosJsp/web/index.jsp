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

   <!-- Lo primero va a ser crearme un objeto con la fecha del sistema -->
   
   <%
        // Vamos a crear un objeto de sesión, que almacenará la fecha
        HttpSession sesion = request.getSession();
   
        java.sql.Date fechaSistema=new java.sql.Date((new java.util.Date()).getTime());
        /*obtengo la fecha actual del sistema y la convierto a String para poder imprimirla*/
        String fecha=String.valueOf(fechaSistema);
        
        String ano_actual=fecha.substring(0,4);
        String mes_actual=fecha.substring(5,7);
        String dia_actual=fecha.substring(8,10);
        
        sesion.setAttribute("ano_actual",ano_actual);
        sesion.setAttribute("mes_actual",mes_actual);
        sesion.setAttribute("dia_actual",dia_actual);
   
   %>
   
   
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Proyecto Web con Bases de Datos</title>
    </head>
    <body>

    <h1>Proyecto Web con Bases de Datos</h1>
    <br>
    <a href="PedidosCodCli.jsp?opcion=Pedidos"><h3>Gestión de pedidos</h3></a>
    <th>
    <a href="PedidosCodCli.jsp?opcion=Extractos"><h3>Gestión de Extractos</h3></a>
    <th>
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
      
</script>