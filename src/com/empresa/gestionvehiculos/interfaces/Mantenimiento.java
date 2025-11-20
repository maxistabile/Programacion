
package com.empresa.gestionvehiculos.interfaces;

/**
 * Interfaz para definir el comportamiento de mantenimiento de los vehículos.
 * Permite calcular el costo de mantenimiento y obtener un identificador.
 */
public interface Mantenimiento {
    /**
     * Calcula el costo del mantenimiento del vehículo.
     * La implementación variará según el tipo de vehículo.
     *
     * @return El costo del mantenimiento.
     */
    double calcularCostoMantenimiento();

    /**
     * Obtiene un identificador único para el objeto.
     *
     * @return Un string con el identificador.
     */
    default String getIdentificador() {
        return "ID-" + hashCode();
    }
}
