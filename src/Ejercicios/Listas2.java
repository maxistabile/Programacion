package Ejercicios;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

public class Listas2 {
public static void main(String[] args) {
    List<String> listas = new LinkedList<>();
    listas.addFirst("Hola");
    listas.add("Adios");
    listas.add( "Hola");
    System.out.println(listas);
    listas.addFirst("Hola de nuevo");
    listas.addLast("Adios de nuevo");
    System.out.println(listas);
    listas.removeFirst();
    System.out.println(listas);
    listas.removeLast();
    System.out.println(listas);
    listas.remove(2);

    listas.forEach(lista -> System.out.println(lista));
}
}
