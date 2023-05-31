<%-- 
    Document   : Libro
    Created on : 28/05/2023, 12:06:57 PM
    Author     : Alejandro Bernal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Libros de la BIBLIOTECA UPC</h1>
        <form action="./LibroServlet" method="POST">
            <table>
                <tr>
                    <td>Nombre Libro</td>
                    <td><input type="text" name="nombre" value=${libro.nombre} /> </td>
                    
                </tr>
                <tr>
                    <td>Fecha de Publicacion</td>
                    <td><input type="text" name="fecha" value=${libro.fecha} /></td>
                </tr>
                <tr>
                    <td>Autor del Libro</td>
                    <td><input type="text" name="autor" value="${libro.autor}" /></td>
                </tr>
                <tr>
                    <td>Estado</td>
                    <td><input type="text" name="estado" value="${estado}" /></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" name="action" value="Add" />
                        <input type="submit" name="action" value="Edit" />
                        <input type="submit" name="action" value="Delete" />
                        <input type="submit" name="action" value="Search" />
                    </td>
                </tr>
            </table>              
        </form>
        <br>
   
        <table border="1">
            <th>NOMBRE</th>
            <th>FECHA</th>
            <th>AUTOR</th>
                <c:forEach items="${allLibros}" var="lib" begin="0">
                <tr>
                    <td>${libro.nombre}</td>
                    <td>${libro.fecha}</td>
                    <td>${libro.autor}</td>
                </tr>
            </c:forEach> 
        </table>
    </body>
</html>
