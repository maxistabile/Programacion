package Ejercicios;
import java.util.*;

public class Prueba2 {
    public static void main(String[] args) {
        Integer [] arreglo = new Integer[10];
        int cantidad= 0;
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = new Random().nextInt(15);
        }
        Arrays.sort(arreglo, Collections.reverseOrder());
        for (int i = 0; i < arreglo.length-1; i++) {
            if(arreglo[i] == arreglo[i+1]){
                i++;
            }
            System.out.println(arreglo[i]);
            cantidad++;
        }
        System.out.println("La cantidad de numeros NO repetidos es: " + cantidad);
    }


}
