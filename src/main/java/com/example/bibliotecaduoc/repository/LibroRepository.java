package com.example.bibliotecaduoc.repository;

import com.example.bibliotecaduoc.model.libro;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LibroRepository {

    //Esto guardara todos los libros
    private List<libro> listaLibros = new ArrayList<>();

    //Metodo con el cual retornan todos los libros
    public List<libro> obtenerLibros() {
        return listaLibros;
    }


    public libro buscarPorId(int id) {
        for (libro libro : listaLibros) {
            if (libro.getId() == id) {
                return libro;
            }
        }
        return null;
    }

    public libro buscarPorIsbn(String isbn){
        for (libro libro : listaLibros){
            if (libro.getIsbn().equals(isbn)){
                return libro;
            }
        }
        return null;
    }









}

