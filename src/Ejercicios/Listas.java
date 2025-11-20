package Ejercicios;
import java.util.ArrayList;
import java.util.List;

public class Listas {
    public static void main(String[] args) {
        // Creamos una lista para almacenar objetos de tipo Persona
        List<Persona> listaDePersonas = new ArrayList<>();
 
        // Creamos y añadimos personas a la lista
        listaDePersonas.add(new Persona("Juan", "Perez", 20));
        listaDePersonas.add(new Persona("Ana", "Gomez", 25));
 
        // Iteramos sobre la lista y mostramos cada persona
        for (Persona persona : listaDePersonas) {
            System.out.println(persona);
        }
    }
}