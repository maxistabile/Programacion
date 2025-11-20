
package com.empresa.gestionvehiculos.modelos;

/**
 * Subclase que representa un Camion, extendiendo la clase Vehiculo.
 */
public class Camion extends Vehiculo {

    private double capacidadCarga; // en toneladas

    /**
     * Constructor para la clase Camion.
     *
     * @param marca          La marca del camión.
     * @param modelo         El modelo del camión.
     * @param anio           El año de fabricación.
     * @param patente        La patente única.
     * @param kilometraje     El kilometraje actual.
     * @param capacidadCarga La capacidad de carga en toneladas.
     */
    public Camion(String marca, String modelo, int anio, String patente, double kilometraje, double capacidadCarga) {
        super(marca, modelo, anio, patente, "Camion", kilometraje);
        this.capacidadCarga = capacidadCarga;
    }

    public double getCapacidadCarga() {
        return capacidadCarga;
    }

    public void setCapacidadCarga(double capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }

    /**
     * Implementación del método abstracto para realizar mantenimiento específico para camiones.
     */
    @Override
    public void realizarMantenimiento() {
        System.out.printf("Realizando mantenimiento del camión %s %s (Patente: %s). Revisión de frenos y motor.\n",
                this.getMarca(), this.getModelo(), this.getPatente());
    }

    /**
     * Sobrescritura del método para calcular el costo de mantenimiento.
     * El costo para un camión es más elevado, basado en el kilometraje y la capacidad de carga.
     */
    @Override
    public double calcularCostoMantenimiento() {
        return 300.0 + (getKilometraje() / 5000) * 50.0 + capacidadCarga * 20.0;
    }

    /**
     * Sobrescritura del método toString para incluir información específica del camión.
     */
    @Override
    public String toString() {
        return super.toString() + ", Capacidad de Carga: " + capacidadCarga + "T";
    }
}
