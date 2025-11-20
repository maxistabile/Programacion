
package com.empresa.gestionvehiculos.excepciones;

/**
 * Excepción personalizada para manejar formatos de patente inválidos.
 * Se lanza cuando una patente no cumple con el formato esperado (ej. 3 letras y 3 números).
 */
public class PatenteInvalidaException extends Exception {

    /**
     * Constructor que acepta un mensaje de error.
     *
     * @param mensaje El mensaje que describe la causa de la excepción.
     */
    public PatenteInvalidaException(String mensaje) {
        super(mensaje);
    }
}
