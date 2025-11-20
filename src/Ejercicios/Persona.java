package Ejercicios;
import java.io.Serializable;

// 1. La clase es pública y está en su propio archivo.
// 2. Implementa la interfaz Serializable.
public class Persona implements Serializable {
    
    // 3. Se añade un serialVersionUID, una buena práctica para clases serializables.
    private static final long serialVersionUID = 1L;

    // 4. Los atributos son privados (encapsulación).
    private String nombre;
    private String apellido;
    private int edad;

    // 5. Constructor público sin argumentos.
    public Persona(){
    }

    // Constructor con argumentos (opcional pero útil).
    public Persona(String nombre, String apellido, int edad){
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    // 6. Métodos getter y setter públicos para cada atributo.
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getApellido(){
        return apellido;
    }
    public void setApellido(String apellido){
        this.apellido = apellido;
    }
    public int getEdad(){
        return edad;
    }
    public void setEdad(int edad){
        this.edad = edad;
    }

    @Override
    public String toString(){
        return "Nombre: " + nombre + "\nApellido: " + apellido + "\nEdad: " + edad;
    }
    @Override
    public boolean equals(Object obj){
        if(obj instanceof Persona){
            Persona p = (Persona)obj;
            return p.getNombre().equals(this.nombre) && p.getApellido().equals(this.apellido) && p.getEdad() == this.edad;
        }
        return false;
    }
    //Hashcode basado en el nombre, apellido y edad.
    @Override
    public int hashCode(){
        return nombre.hashCode() + apellido.hashCode() + edad;
    }
}
