/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.patterns.payaraweb.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alejandro Bernal
 */
public class LibroDAOImplementation implements LibroDAO {

    private String driver;
    private String url;
    private String login;
    private String password;
    private String sentencia;
    private Connection connection;
    private Statement Statement2;
    private ResultSet rs;
    private Libro lib;

    public LibroDAOImplementation() {
        driver = "org.apache.derby.jdbc.ClientDriver";
        url = "jdbc:derby://localhost:1527/sample";
        login = "app";
        password = "app";
        sentencia = "";
        connection = null;
        Statement2 = null;
        rs = null;
    }

    protected void conectar() {
        try {
            //Cargar los controladores para el acceso a la BD
            Class.forName(driver);
            System.out.println("Cargar los controladores para el acceso a la BD");
            //Establecer la conexión con la BD Empresa
            connection = DriverManager.getConnection(url, login, password);
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error 1-" + cnfe.getMessage());
        } catch (SQLException sqle) {
            System.out.println("Error 2-" + sqle.getMessage());
        }

    }

    public void desconectar(Connection con) {
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Libro> getAllLibros() {
        if (connection == null) {
            conectar();
        }
        List<Libro> lista = new ArrayList();

        sentencia = "SELECT * FROM APP.LIBRO";
        try {
            //Crear una sentencia
            Statement2 = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            //Crear un objeto ResultSet para guardar lo obtenido
            //y ejecutar la sentencia SQL
            rs = Statement2.executeQuery(sentencia);
            System.out.println("consulta ok");
            if (rs == null) {
                System.out.println("vacio");
            }
            System.out.println(rs.first() + " " + rs.getRow() + " " + rs.getCursorName());
            do {
                String nombre = rs.getString(1);
                System.out.println("Nombre " + nombre);
                String fecha = rs.getString(2);
                System.out.println("Fecha " + nombre);
                String autor = rs.getString(3);
                System.out.println("Autor " + autor);
                //Convierte el result set a un Array List
                lista.add(new Libro(nombre, fecha, autor));
                System.out.println(nombre + "\t\t" + fecha + "\t\t" + autor);
            } while (rs.next());

        } catch (SQLException sqle) {
            System.out.println("Excepcion " + sqle.getSQLState());
        }
        return lista;
    }

    @Override
    public void updateLibro(Libro lib) {
        if (connection == null) {
            conectar();
        }
        try {
            sentencia = "UPDATE APP.LIBRO SET "
                    + "NOMBRE = '" + lib.getNombre() + "',"
                    + "FECHA = '" + lib.getFecha() + "',"
                    + "AUTOR = " + lib.getAutor()
                    + " WHERE NOMBRE = " + lib.getNombre();

            System.out.println("Sentencia " + sentencia);
            //Crear una sentencia
            Statement2 = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            //Crear un objeto ResultSet para guardar lo obtenido
            //y ejecutar la sentencia SQL
            Statement2.executeUpdate(sentencia);
        } catch (SQLException sqle) {
            System.out.println("Error en " + sqle.getSQLState());
        }
    }

    @Override
    public void deleteLibro(Libro lib) {
        if (connection == null) {
            conectar();
        }
        System.out.println("Eliminar estudiante");
        try {
            sentencia = "DELETE FROM LIBRO WHERE NOMBRE = " + lib.getNombre();
            System.out.println("Sentencia " + sentencia);
            //Crear una sentencia
            Statement2 = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            //Crear un objeto ResultSet para guardar lo obtenido
            //y ejecutar la sentencia SQL
            Statement2.executeUpdate(sentencia);
        } catch (SQLException sqle) {
            System.out.println("Error en " + sqle.getSQLState());
        }
    }

    @Override
    public void addLibro(Libro lib) {
        if (connection == null) {
            conectar();
        }
        System.out.println("Guardar estudiante");

        try {
            sentencia = "INSERT INTO LIBRO VALUES("
                    + lib.getNombre() + ",'"
                    + lib.getFecha() + "','"
                    + lib.getAutor() + ""
                    + ")";

            System.out.println("Sentencia " + sentencia);
            //Crear una sentencia
            Statement2 = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            //Crear un objeto ResultSet para guardar lo obtenido
            //y ejecutar la sentencia SQL
            Statement2.executeUpdate(sentencia);
        } catch (SQLException sqle) {
            System.out.println("Error en " + sqle.getSQLState());
        }
    }

    @Override
    public Libro searchLibro(String nombreBuscar) {
        Libro lib = null;
        if (connection == null) {
            conectar();
        }
        sentencia = "SELECT * FROM APP.LIBRO WHERE NOMBRE=" + nombreBuscar + "";
        System.out.println("Sentencia: " + sentencia);
        try {
            Statement2 = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            System.out.println("Ejecutando query");
            rs = Statement2.executeQuery(sentencia);
            //no devuelve un resultado
            if (rs == null) {
                System.out.println("RS retorna vacio");
            }
            //Se coloca en la primer posicion del result set
            rs.first();
            //Extrae los datos de cada fila del result set
            String nombre = rs.getString(1);
            System.out.println("Nombre " + nombre);
            String fecha = rs.getString(2);
            System.out.println("Fecha " + nombre);
            String autor = rs.getString(3);
            System.out.println("Autor " + autor);
            lib = new Libro(nombre, fecha, autor);
            System.out.println(nombre + "\t\t" + fecha + "\t\t" + autor);
        } catch (SQLException sqle) {
            System.out.println("Excepcion " + sqle.getSQLState());
        }
        return lib;
    }
}
