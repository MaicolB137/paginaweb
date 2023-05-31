<%-- 
    Document   : index
    Created on : 17/05/2023, 6:34:36 p. m.
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
               <h1>Student Information</h1>
        <form action="./StudentServlet" method="POST">
            <table>
                <tr>
                    <td>Student Id</td>
                    <td><input type="text" name="studentId" value=${student.id} /> </td>
                    
                </tr>
                <tr>
                    <td>First Name</td>
                    <td><input type="text" name="firstName" value=${student.nombre} /></td>
                </tr>
                <tr>
                    <td>Last Name</td>
                    <td><input type="text" name="lastName" value=${student.apellido} /></td>
                </tr>
                <tr>
                    <td>Year Level</td>
                    <td><input type="text" name="yearLevel" value="${student.semestre}" /></td>
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
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Year Level</th>
                <c:forEach items="${allStudents}" var="stud" begin="0">
                <tr>
                    <td>${stud.id}</td>
                    <td>${stud.nombre}</td>
                    <td>${stud.apellido}</td>
                    <td>${stud.semestre}</td>
                </tr>
            </c:forEach> 
        </table>
        
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
                    <td><input type="text" name="estado2" value="${estado2}" /></td>
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
                    <td>${lib.nombre}</td>
                    <td>${lib.fecha}</td>
                    <td>${lib.autor}</td>
                </tr>
            </c:forEach> 
        </table>
        
    </body>
</html>
