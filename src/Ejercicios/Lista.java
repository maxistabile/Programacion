package Ejercicios;

import java.util.ArrayList;

public class Lista {
    public static void main(String[] args) {
        // Creando una lista ArrayList
        ArrayList<String> lista = new ArrayList<>();
        //Agregando elementos a la lista
        lista.add("Manzana");
        lista.add("Banana");
        lista.add("Naranja");
        // Asignando un elemento de la posicion 1 a la variable "fruta"
        String fruta = lista.get(1);
        //Mostrando el elemento fruta pos 1 de la lista
        System.out.println(fruta);
        //Mostrando la lista completa a traves de un for adaptado
        System.out.println("\nPrimera lista \n");
        for (String f: lista) {
            System.out.println(f);
        }
        System.out.println("Tamaño de la lista: " +lista.size());
        //Eliminando el elemento "Naranja" de la lista
        lista.remove("Naranja");
        //Mostrando la lista completa a traves de un for adaptado ya con el elemento eliminado
        System.out.println("\nSegunda lista \n");
        for (String f: lista) {
            System.out.println(f);

        
        }
        System.out.println("Tamaño de la lista: " + lista.size());

        Integer [] arreglo = new Integer[5];
        //saber el tamaño del arreglo
        int tamaño = arreglo.length;
        System.out.println("Tamaño del arreglo: " + tamaño);
    
    }
    }
    
