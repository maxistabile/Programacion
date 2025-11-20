package Ejercicios;
import java.util.*;

public class Arraylist {
  public static void main(String[] args) {
    List<String> test = new ArrayList<String>();
    String s = "hi";
    test.add("string");
    test.add(s);
    test.add(s+s);
    
    System.out.println(test.size());
    System.out.println(test.contains(42));
    System.out.println(test.contains("hihi"));
    Collections.sort(test);
    System.out.println(test);
    test.remove("hi");
    System.out.println(test.size());

    ArrayList<String> stuff = new ArrayList<String>(); // ArrayList de String
    stuff.add("Denver");
    stuff.add("Boulder");
    stuff.add("Vail");
    stuff.add("Aspen");
    stuff.add("Telluride");
    System.out.println("unsorted " + stuff);
    Collections.sort(stuff);                           // Ordenamos la colección de String
    System.out.println("sorted   " + stuff);

    }
 }


