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

    public libro guardar(libro lib){
        listaLibros.add(lib);
        return lib;
    }

    public libro actualizar(libro lib) {
        int id = 0;
        int idPosicion = 0;

        for (int i = 0; i < listaLibros.size(); i++) {
            if (listaLibros.get(i).getId() == lib.getId()) {
                id = lib.getId();
                idPosicion = i;
            }
        }

        libro libro1 = new libro();
        libro1.setId(id);
        libro1.setTitulo(lib.getTitulo());
        libro1.setAutor(lib.getAutor());
        libro1.setFechaPublicacion(lib.getFechaPublicacion());
        libro1.setEditorial(lib.getEditorial());
        libro1.setIsbn(lib.getIsbn());

        listaLibros.set(idPosicion, libro1);
        return libro1;

    }
    public void eliminar(int id) {

        //Primera Alternativa
        libro libro = buscarPorId(id);
        if (libro != null) {
            listaLibros.remove(libro);
        }
        //Segunda Alternativa
        int idPosicion = 0;
        for (int i = 0; 1 < listaLibros.size(); i++) {
            if (listaLibros.get(i).getId() == id) {
                idPosicion = i;
                break;
            }
        }
        if (idPosicion > 0) {
            listaLibros.remove(idPosicion);
        }

        //Ultima Alternativa
        listaLibros.removeIf(x -> x.getId() == id);
    }








}

