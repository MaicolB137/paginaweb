/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.patterns.payaraweb.model;

import java.util.List;

/**
 *
 * @author Alejandro Bernal
 */
public class Libro {
    private String nombre;
    private String fecha;
    private String autor;

    public Libro(String nombre, String fecha, String autor) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.autor = autor;
    }

    public Libro() {
        nombre= "";
        fecha ="";
        autor="";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
    
    
}
