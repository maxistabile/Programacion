package Ejercicios;
public class Main {
    public static void main(String[] args) {
        Persona p1 = new Persona("Juan", "Perez", 20);
        System.out.println(p1);  
        Persona p2 = new Persona();
        System.out.println(p2);
        p2.setNombre("Maxi");
        p2.setApellido("Stabile");
        p2.setEdad(28);
        System.out.println(p2);

        
    }
}
        
     
    
   
    //List<Persona> lista = new ArrayList<>();
    // lista = new LinkedList<>();
    // lista = new Stack<>();
    // Operacion suma = new Suma();
    // suma = new Multiplicacion();

    // Animal 1 = new Perro();
   // 1 = new Gato();

