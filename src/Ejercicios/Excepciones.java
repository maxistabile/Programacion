package Ejercicios;

import java.io.IOException;

public class Excepciones {
    public static void main(String[] args) {
        int x;
        int suma;
        try {
            suma = 3 / 0 ;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Aca sigue");
    }
}
