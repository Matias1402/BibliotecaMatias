package com.example.bibliotecaduoc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.bibliotecaduoc.model.libro;
import com.example.bibliotecaduoc.services.libroServices;
import java.util.List;

@RestController
@RequestMapping("/api/v1/libros")
public class libroController {
    @Autowired
    private libroServices libroService;

    @GetMapping
    public List<libro> listarLibros(){
        return libroService.getLibros();
    }
    @PostMapping
    public libro agregarLibros(@RequestBody libro libro){
        return libroService.saveLibro(libro);
    }
    @GetMapping("{id}")
    public libro buscarLibro(@PathVariable int id){
        return libroService.getLibroId(id);
    }
    @PutMapping("{id}")
    public libro actualizarLibro(@PathVariable int id, @RequestBody libro libro){
        //el id aun no se usara
        return libroService.updateLibro(libro);
    }
    @DeleteMapping("{id}")
    public String eliminarLibro(@PathVariable int id){
        return libroService.deleteLibro(id);
    }
    @GetMapping("/Total")
    public int totalLibrosV2(){
        return libroService.totalLibrosV2();
    }

    @GetMapping("/ISBN/{isbn}")
    public libro buscarLibroIsbn(@PathVariable String isbn) {
        return libroService.getLibroIsbn((isbn));
    }
    @GetMapping("/anio/{fechaPublicacion}")
    public Object[] buscarLibroAnio(@PathVariable int fechaPublicacion) {
        List<libro> libros = libroService.getLibroAnio(fechaPublicacion);
        return new Object[]{libros, "La Cantidad de libros con esta fecha es: " + libros.size()};
    }
    @GetMapping("/AUTOR/{autor}")
    public libro buscarLibroAutor(@PathVariable String autor) {
        return libroService.getLibroAutor((autor));
    }

    @GetMapping("/ANTIGUO")
    public libro buscarPorAntiguedadMayor(){
        return libroService.getMasAntiguo();
    }
    @GetMapping("/RECIENTE")
    public libro buscarPorAntiguedadReciente(){
        return libroService.getMasReciente();
    }
    @GetMapping("/OrdenASC")
    public List<libro> ListadoASC(){
        return libroService.getOrdenAsc();
    }
    @GetMapping("/OrdenDESC")
    public List<libro> ListadoDESC(){
        return libroService.getOrdenDesc();
    }

}


