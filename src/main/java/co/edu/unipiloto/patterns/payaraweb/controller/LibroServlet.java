/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.patterns.payaraweb.controller;

import co.edu.unipiloto.patterns.payaraweb.model.Libro;
import co.edu.unipiloto.patterns.payaraweb.model.LibroDAO;
import co.edu.unipiloto.patterns.payaraweb.model.LibroDAOImplementation;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alejandro Bernal
 */
public class LibroServlet extends HttpServlet {

    private LibroDAO libroDAO;
    private Libro libro;
    private List<Libro> libros;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        libroDAO = new LibroDAOImplementation();
        libros = new ArrayList<Libro>();

        String nombre = " ", fecha = " ", autor = " ";
        String resultado = " ";
        String nomStr = " ";
        String accion = request.getParameter("action");
        nomStr=request.getParameter(nombre);
        nombre=nomStr;
        
        if (!accion.equals("Search")) {
            nombre = request.getParameter("nombre");
            fecha = request.getParameter("fecha");
            autor = request.getParameter("autor");
        }

        if (accion.equals("Add")) {
            libro = new Libro(nombre, fecha, autor);
            if (libroDAO.searchLibro(nombre) == null) {
                libroDAO.addLibro(libro);
                resultado = "ADD ok";
            }
        }
        if (accion.equals("Edit")) {
            libro = new Libro(nombre, fecha, autor);
            if (libroDAO.searchLibro(nombre) != null) {
                System.out.println("Actualizando nombre " + nombre + " fecha " + fecha + " autor " + autor);
                libroDAO.updateLibro(libro);
                resultado = "EDIT ok";
            } else {
                System.out.println("Nombre no encontrado" + nombre + " NO se actualiza el registro ");
                resultado = "nombre no encontrado";
            }
        }
        if (accion.equals("Delete")) {
            libro = new Libro(nombre, fecha, autor);
            libroDAO.deleteLibro(libro);
            resultado = "DELETE ok";
        }
        if (accion.equals("Search")) {
            libro = libroDAO.searchLibro(nombre);
            if (libro == null) {
                resultado = "No encontrado";
            } else {
                resultado = "Se encontró";
            }
        }

        //Consultar la lista de libros
        libros = libroDAO.getAllLibros();
        //Asignar valores a variables en index.jsp
        request.setAttribute("estado", resultado);
        request.setAttribute("libro", libro);
        request.setAttribute("allLibros", libros);
        request.getRequestDispatcher("index.jsp").forward(request, response);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
