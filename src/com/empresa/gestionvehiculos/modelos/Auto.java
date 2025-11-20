
package com.empresa.gestionvehiculos.modelos;

/**
 * Subclase que representa un Auto, extendiendo la clase Vehiculo.
 */
public class Auto extends Vehiculo {

    private int numeroPuertas;

    /**
     * Constructor para la clase Auto.
     *
     * @param marca         La marca del auto.
     * @param modelo        El modelo del auto.
     * @param anio          El año de fabricación.
     * @param patente       La patente única.
     * @param kilometraje    El kilometraje actual.
     * @param numeroPuertas El número de puertas del auto.
     */
    public Auto(String marca, String modelo, int anio, String patente, double kilometraje, int numeroPuertas) {
        super(marca, modelo, anio, patente, "Auto", kilometraje);
        this.numeroPuertas = numeroPuertas;
    }

    public int getNumeroPuertas() {
        return numeroPuertas;
    }

    public void setNumeroPuertas(int numeroPuertas) {
        this.numeroPuertas = numeroPuertas;
    }

    /**
     * Implementación del método abstracto para realizar mantenimiento específico para autos.
     */
    @Override
    public void realizarMantenimiento() {
        System.out.printf("Realizando mantenimiento del auto %s %s (Patente: %s). Cambio de aceite y filtros.\n",
                this.getMarca(), this.getModelo(), this.getPatente());
    }

    /**
     * Sobrescritura del método para calcular el costo de mantenimiento.
     * El costo para un auto se calcula como un costo base más un extra por cada 10,000 km.
     */
    @Override
    public double calcularCostoMantenimiento() {
        return 150.0 + (getKilometraje() / 10000) * 25.0;
    }

    /**
     * Sobrescritura del método toString para incluir información específica del auto.
     */
    @Override
    public String toString() {
        return super.toString() + ", Puertas: " + numeroPuertas;
    }
}
