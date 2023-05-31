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
public interface LibroDAO {
    
    public List<Libro> getAllLibros();
    public void updateLibro (Libro lib);
    public void deleteLibro (Libro lib);
    public void addLibro (Libro lib);
    public Libro searchLibro(String nombreBuscar);
    
}
