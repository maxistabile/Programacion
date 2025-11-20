package Ejercicios;
public class Prueba3 {
   public static void main (String[] args) {
      Hola hola = new Hola(152, "Maxi");
      Hola hola2 = new Hola(152, "Maxi");
      Hola hola3 = new Hola(152, "Maxi");
      if (hola.equals(hola2)){
         System.out.println("Los objetos son iguales");
      }
      else{
         System.out.println("Los objetos son diferentes");
      }
      if (hola2.equals(null)){
         System.out.println("Los objetos son iguales");
      }
      else{
         System.out.println("Los objetos son diferentes");
      }
      
}
}
class Hola {
    int dni;
    String nombre;
    public Hola(){}
    public Hola(int dni, String nombre){
        this.dni = dni;
        this.nombre = nombre;
    }
    public boolean equals(Hola hola){
        return this.dni == hola.dni && this.nombre.equals(hola.nombre);
    }
}

