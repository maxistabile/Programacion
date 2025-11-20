package Ejercicios;
public class Cadenas {
    private int cantidad;

    // Constructor
    public Cadenas() {
    }
    public Cadenas(int cantidad) {
        this.cantidad = cantidad;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }   
    public static void main(String[] args) {
    Cadenas c = new Cadenas();
    c.setCantidad(3);
    System.out.println(c.cantidad);
    }

}
