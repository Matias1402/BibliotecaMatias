package com.example.bibliotecaduoc.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.example.bibliotecaduoc.model.libro;
import com.example.bibliotecaduoc.repository.LibroRepository;

@Service
public class libroServices {
    @Autowired
    private LibroRepository libroRepository;

    public List<libro> getLibros(){
        return libroRepository.obtenerLibros();
    }

    public libro saveLibro(libro libro){
        return libroRepository.guardar(libro);
    }


    public libro getLibroId(int id){
        return libroRepository.buscarPorId(id);
    }

    public libro updateLibro(libro libro){
        return libroRepository.actualizar(libro);
    }

    public String deleteLibro(int id){
        libroRepository.eliminar(id);
        return "El producto fue eliminado";
    }

    public libro getLibroIsbn(String isbn){
        return libroRepository.buscarLibroPorIsbn(isbn);
    }

    public List<libro> getLibroAnio(int fechaPublicacion){
        return libroRepository.buscarLibroPorAnio(fechaPublicacion);
    }

    public int totalLibrosV1(){
        return libroRepository.obtenerLibros().size();
    }
    public int totalLibrosV2(){
        return libroRepository.TotalLibros();
    }



}

