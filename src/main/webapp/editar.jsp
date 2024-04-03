<%@page import="com.emergentes.modelo.Persona"%>
<%
    Persona reg = (Persona) request.getAttribute("miobjper");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Registro de persona</h1>
        <form action="MainServlet" method="post">
            <table>
                <tr>
                    <td>Id</td>
                    <td><input type="text" name="id" value="<%= reg.getId() %>" size="2" readonly></td>
                </tr>
                <tr>
                    <td>Nombre</td>
                    <td><input type="text" name="nombres" value="<%= reg.getNombres() %>"></td>
                </tr>
                <tr>
                    <td>P1</td>
                    <td><input type="text" name="P1" value="<%= reg.getP1() %>"></td>
                </tr>
                <tr>
                    <td>P2</td>
                    <td><input type="text" name="P2" value="<%= reg.getP2() %>"></td>
                </tr>
                <tr>
                    <td>P3</td>
                    <td><input type="text" name="P3" value="<%= reg.getP3() %>"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Enviar"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
