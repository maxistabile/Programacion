
package com.empresa.gestionvehiculos.modelos;

import com.empresa.gestionvehiculos.interfaces.Mantenimiento;
import java.util.Objects;

/*
 * Justificación del contexto:
 * Se ha elegido el contexto de una empresa de logística y transporte que necesita
 * gestionar su flota de vehículos. Esta elección se debe a que permite modelar
 * una variedad de tipos de vehículos (autos, camiones, etc.) con atributos
 * y comportamientos específicos, lo cual se alinea con los requisitos del proyecto.
 * La gestión de una flota implica operaciones CRUD, cálculos de mantenimiento y
 * la necesidad de identificar de forma única cada vehículo, justificando así
 * el uso de interfaces, herencia y la sobreescritura de métodos como equals() y hashCode().
 */

/**
 * Clase base abstracta que representa un vehículo de la flota.
 * Contiene los atributos y métodos comunes a todos los vehículos.
 */
public abstract class Vehiculo implements Mantenimiento {

    private String marca;
    private String modelo;
    private int anio;
    private String patente; // Formato ABC123
    private String tipo;
    private double kilometraje;

    /**
     * Constructor parametrizado para crear una nueva instancia de Vehiculo.
     *
     * @param marca       La marca del vehículo.
     * @param modelo      El modelo del vehículo.
     * @param anio        El año de fabricación del vehículo.
     * @param patente     La patente única del vehículo.
     * @param tipo        El tipo de vehículo (ej. "Auto", "Camion").
     * @param kilometraje El kilometraje actual del vehículo.
     */
    public Vehiculo(String marca, String modelo, int anio, String patente, String tipo, double kilometraje) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.patente = patente;
        this.tipo = tipo;
        this.kilometraje = kilometraje;
    }

    // Getters y Setters (Encapsulamiento)
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(double kilometraje) {
        this.kilometraje = kilometraje;
    }

    /**
     * Redefinición de equals() para identificar un vehículo por su patente.
     * Dos vehículos son iguales si sus patentes son iguales (ignorando mayúsculas/minúsculas).
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehiculo vehiculo = (Vehiculo) o;
        return patente.equalsIgnoreCase(vehiculo.patente);
    }

    /**
     * Redefinición de hashCode() para ser consistente con equals().
     * El hashCode se basa en la patente en mayúsculas.
     */
    @Override
    public int hashCode() {
        return Objects.hash(patente.toUpperCase());
    }

    @Override
    public String toString() {
        return String.format("Patente: %s, Marca: %s, Modelo: %s, Año: %d, Kilometraje: %.2f",
                patente, marca, modelo, anio, kilometraje);
    }

    // Métodos sobrecargados
    public void mostrarInformacion() {
        System.out.println(this.toString());
    }

    public void mostrarInformacion(boolean conTipo) {
        if (conTipo) {
            System.out.println(this.toString() + ", Tipo: " + this.getTipo());
        } else {
            mostrarInformacion();
        }
    }

    // Método abstracto que será implementado por las subclases
    public abstract void realizarMantenimiento();
}
