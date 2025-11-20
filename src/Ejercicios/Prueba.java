
package Ejercicios;
public class Prueba {
public static void main(String[] args) {
	Producto p = new Producto();
	p.setNombre("Lavandina");
	p.setPrecio(135.56);
	p.setCantidad(5);
	System.out.println(p);

}
}
class Producto{
	private String nombre;
	private double precio;
	private int cantidad;
	public Producto() {
	}
	public Producto(String nombre, double precio, int cantidad) {
		this.nombre = nombre;
		this.precio = precio;
		this.cantidad = cantidad;
	}
	public String getNombre() {
		return nombre;
}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	@Override
	public String toString() {
		return "Producto\n nombre: " + nombre + ", precio: " + precio + ", cantidad: " + cantidad;
	}
	



}
