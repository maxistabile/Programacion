package Ejercicios;

public class ExpresionesLambda {
    public static void main(String[] args) {
        OperacionMatematica suma = (int a,int b) -> a+b;
        System.out.println(suma.calcular(5,3));
        OperacionMatematica resta = (int a,int b) -> a-b;
        System.out.println(resta.calcular(5,3));
        Cadena a = () -> "Hola Mundo";
        System.out.println(a.imprimir());
    }

}
@FunctionalInterface
interface OperacionMatematica {
    int calcular(int a, int b);
}

@FunctionalInterface
interface Cadena {
    String imprimir();
}









// class Persona {
//     private String nombre;
//     private String apellido;
//     private int edad;
//}
// public Persona (){}
// public Persona (String nombre, String apellido, int edad){
//     this.nombre = nombre;
//     this.apellido = apellido;
//     this.edad = edad;
// }
// public String getNombre(){
//     return nombre;
// }
// public void setNombre(String nombre){
//     this.nombre = nombre;
// }
// public String getApellido(){
//     return apellido;
// }
// public void setApellido(String apellido){
//     this.apellido = apellido;
// }
// public int getEdad(){
//     return edad;
// }
// public void setEdad(int edad){
//     this.edad = edad;
// }
// public String toString(){
//     return "Nombre: " + nombre + " Apellido: " + apellido + " Edad: " + edad;
// }

// public static void main(String[] args) {
//     Persona p1 = new Persona();
// system.out.println(p1);
//     Persona p2 = new Persona("Juan", "Perez", 20);
//     p1.setNombre("Maxi");
//     p1.setApellido("Stabile");
//     p1.setEdad(28);