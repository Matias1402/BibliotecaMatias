package com.example.bibliotecaduoc.repository;

import com.example.bibliotecaduoc.model.libro;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Repository
public class LibroRepository {

    //Esto guarda todos los libros
    private List<libro> listaLibros = new ArrayList<>();

    public LibroRepository(){
        listaLibros.add(new libro(1, "9789569646638", "Fuego y Sangre", "Penguin Random House Grupo Editorial", 2018, "George R. R. Martin"));
        listaLibros.add(new libro(2, "9789563494150", "Quique Hache: El Mall Embrujado y Otras Historias", "Sm Ediciones", 2014, "Sergio Gomez"));
        listaLibros.add(new libro(3, "9781484256251", "Spring Boot Persistence Best Practices", "Apress", 2020, "Anghel Leonard"));
        listaLibros.add(new libro(4, "9789566075752", "Harry Potter y la piedra filosofal", "Salamandra", 2024, "J. K. Rowling"));
        listaLibros.add(new libro(5, "9780439139601", "Harry Potter y el prisionero de Azkaban", "Scholastic", 1999, "J. K. Rowling"));
        listaLibros.add(new libro(6, "9780439136365", "Harry Potter y el cáliz de fuego", "Scholastic", 2000, "J. K. Rowling"));
        listaLibros.add(new libro(7, "9780321127426", "Effective Java", "Addison-Wesley", 2008, "Joshua Bloch"));
        listaLibros.add(new libro(8, "9780134685991", "Clean Architecture", "Prentice Hall", 2017, "Robert C. Martin"));
        listaLibros.add(new libro(9, "9780201633610", "Design Patterns", "Addison-Wesley", 1994, "Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides"));
        listaLibros.add(new libro(10, "9780132350884", "Clean Code", "Prentice Hall", 2008, "Robert C. Martin"));

    }

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

    public List<libro> buscarLibroPorAnio(int fechaPublicacion){
        List<libro> listaAnioLibro =new ArrayList<>();
        for (libro libro : listaLibros){
            if (libro.getFechaPublicacion()==fechaPublicacion){
                listaAnioLibro.add(libro);
            }
        }
        return listaAnioLibro;
    }
    public libro buscarLibroPorIsbn(String isbn){
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
        //Ultima Alternativa
        listaLibros.removeIf(x -> x.getId() == id);
    }
    public int TotalLibros(){
        return listaLibros.size();
    }
    public libro buscarLibroPorAutor(String autor){
        for (libro libro : listaLibros){
            if (libro.getAutor().equals(autor)){
                return libro;
            }
        }
        return null;
    }
    public libro buscarLibroMasAntiguo() {

        libro MasAntiguo=null;//Anotacion recordatorio: Esto hace que el valor "mas antiguo" inicialmente no exista, es decir, que esta en null a la espera de un dato
        int menorAnio= Integer.MAX_VALUE;//Esto hara que haga una comparativa entre todos los valores para elegir el año menor, dada la logica de como funcionan los años

        for (libro libro : listaLibros) {
            if (libro.getFechaPublicacion()<menorAnio){
                menorAnio = libro.getFechaPublicacion();//para actualizar fecha por fecha
                MasAntiguo = libro;//para asignar a "libro" el mas antiguo
            }
        }
        return MasAntiguo;

    }
    public libro buscarLibroMasReciente() {

        libro MasReciente = null;//Anotacion recordatorio: Esto hace que el valor "mas antiguo" inicialmente no exista, es decir, que esta en null a la espera de un dato
        int MayorAnio = Integer.MIN_VALUE;//Esto hara que haga una comparativa entre todos los valores para elegir el año menor, dada la logica de como funcionan los años

        for (libro libro : listaLibros) {
            if (libro.getFechaPublicacion() > MayorAnio) {
                MayorAnio = libro.getFechaPublicacion();//para actualizar fecha por fecha
                MasReciente = libro;//para asignar a "libro" el mas antiguo
            }
        }
        return MasReciente;
    }

    public List<libro> ordenAsc(){
        List<libro> orden = new ArrayList<>(listaLibros);
        orden.sort(Comparator.comparing(libro::getFechaPublicacion));
        return orden;

    }
    public List<libro> ordenDesc(){
        List<libro> ordenDESC = new ArrayList<>(listaLibros);
        ordenDESC.sort(Comparator.comparing(libro::getFechaPublicacion).reversed());
        return ordenDESC;

    }








}

