
package com.empresa.gestionvehiculos.servicios;

import com.empresa.gestionvehiculos.excepciones.PatenteInvalidaException;
import com.empresa.gestionvehiculos.modelos.Auto;
import com.empresa.gestionvehiculos.modelos.Camion;
import com.empresa.gestionvehiculos.modelos.Vehiculo;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.function.Predicate;

/**
 * Clase que gestiona todas las operaciones CRUD y la lógica de negocio
 * para la flota de vehículos.
 */
public class GestionVehiculos {

    // Variable global: ArrayList para almacenar la flota de vehículos.
    // Se justifica porque es la estructura de datos principal y es accedida
    // por la mayoría de los métodos de esta clase.
    private static ArrayList<Vehiculo> flota = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    /**
     * Método para crear un nuevo vehículo y agregarlo a la flota.
     * Pide los datos por consola y valida la patente.
     */
    public void crearVehiculo() {
        try {
            System.out.println("\n--- Crear Nuevo Vehículo ---");
            System.out.print("Tipo de vehículo (1: Auto, 2: Camion): ");
            int tipo = scanner.nextInt();
            scanner.nextLine(); // Consumir newline

            System.out.print("Marca: ");
            String marca = scanner.nextLine();
            System.out.print("Modelo: ");
            String modelo = scanner.nextLine();
            System.out.print("Año: ");
            int anio = scanner.nextInt();
            scanner.nextLine(); // Consumir newline

            System.out.print("Patente (formato ABC123): ");
            String patente = scanner.nextLine().toUpperCase();
            if (!patente.matches("[A-Z]{3}\\d{3}")) {
                throw new PatenteInvalidaException("Formato de patente inválido. Debe ser 3 letras seguidas de 3 números.");
            }
            // Verificar si la patente ya existe usando una lambda con anyMatch
            if (flota.stream().anyMatch(v -> v.getPatente().equalsIgnoreCase(patente))) {
                System.out.println("Error: Ya existe un vehículo con esa patente.");
                return;
            }

            System.out.print("Kilometraje: ");
            double kilometraje = scanner.nextDouble();
            scanner.nextLine(); // Consumir newline

            Vehiculo nuevoVehiculo = null;
            switch (tipo) {
                case 1:
                    System.out.print("Número de puertas: ");
                    int puertas = scanner.nextInt();
                    scanner.nextLine();
                    nuevoVehiculo = new Auto(marca, modelo, anio, patente, kilometraje, puertas);
                    break;
                case 2:
                    System.out.print("Capacidad de carga (toneladas): ");
                    double carga = scanner.nextDouble();
                    scanner.nextLine();
                    nuevoVehiculo = new Camion(marca, modelo, anio, patente, kilometraje, carga);
                    break;
                default:
                    System.out.println("Tipo de vehículo no válido.");
                    return;
            }

            flota.add(nuevoVehiculo);
            System.out.println("Vehículo creado y añadido a la flota exitosamente!");

        } catch (InputMismatchException e) {
            System.out.println("Error: Entrada inválida. Por favor, ingrese el tipo de dato correcto.");
            scanner.nextLine(); // Limpiar buffer
        } catch (PatenteInvalidaException e) {
            System.out.println("Error al crear el vehículo: " + e.getMessage());
        }
    }

    /**
     * Muestra todos los vehículos de la flota utilizando una lambda forEach.
     */
    public void leerVehiculos() {
        System.out.println("\n--- Listado de Vehículos en la Flota ---");
        if (flota.isEmpty()) {
            System.out.println("La flota está vacía.");
            return;
        }
        // Interfaz lambda: forEach para recorrer e imprimir
        flota.forEach(vehiculo -> System.out.println(vehiculo.toString()));
    }

    /**
     * Modifica un vehículo existente en la flota.
     * Demuestra el paso por referencia de objetos.
     */
    public void actualizarVehiculo() {
        System.out.print("\nIngrese la patente del vehículo a modificar: ");
        String patente = scanner.nextLine().toUpperCase();

        Vehiculo vehiculoAModificar = buscarVehiculoPorPatenteRecursivo(patente, 0);

        if (vehiculoAModificar != null) {
            System.out.println("Vehículo encontrado. Ingrese los nuevos datos (deje en blanco para no cambiar).");

            // Paso por referencia: el objeto vehiculoAModificar es una referencia
            // al objeto dentro del ArrayList. Cualquier cambio se reflejará en la lista.
            System.out.printf("Nuevo kilometraje (actual: %.2f): ", vehiculoAModificar.getKilometraje());
            String nuevoKmStr = scanner.nextLine();
            if (!nuevoKmStr.trim().isEmpty()) {
                try {
                    double nuevoKm = Double.parseDouble(nuevoKmStr);
                    vehiculoAModificar.setKilometraje(nuevoKm);
                    System.out.println("Kilometraje actualizado.");
                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida para kilometraje. No se actualizó.");
                }
            }

            // Ejemplo de modificación de un atributo específico de la subclase
            if (vehiculoAModificar instanceof Auto) {
                Auto auto = (Auto) vehiculoAModificar;
                System.out.printf("Nuevo número de puertas (actual: %d): ", auto.getNumeroPuertas());
                String nuevasPuertasStr = scanner.nextLine();
                if (!nuevasPuertasStr.trim().isEmpty()) {
                    try {
                        int nuevasPuertas = Integer.parseInt(nuevasPuertasStr);
                        auto.setNumeroPuertas(nuevasPuertas);
                        System.out.println("Número de puertas actualizado.");
                    } catch (NumberFormatException e) {
                        System.out.println("Entrada inválida para puertas. No se actualizó.");
                    }
                }
            }
            System.out.println("Vehículo actualizado con éxito.");
        } else {
            System.out.println("Vehículo no encontrado.");
        }
    }

    /**
     * Elimina un vehículo de la flota usando la patente.
     * Utiliza una lambda con removeIf.
     */
    public void eliminarVehiculo() {
        System.out.print("\nIngrese la patente del vehículo a eliminar: ");
        String patente = scanner.nextLine().toUpperCase();

        // Interfaz lambda: removeIf para eliminar un elemento que cumple una condición
        boolean eliminado = flota.removeIf(v -> v.getPatente().equalsIgnoreCase(patente));

        if (eliminado) {
            System.out.println("Vehículo eliminado con éxito.");
        } else {
            System.out.println("Vehículo no encontrado.");
        }
    }

    /**
     * Busca un vehículo por su patente de forma recursiva.
     *
     * @param patente La patente a buscar.
     * @param index   El índice actual en la búsqueda dentro del ArrayList.
     * @return El vehículo si se encuentra, o null si no.
     */
    public Vehiculo buscarVehiculoPorPatenteRecursivo(String patente, int index) {
        // Caso base: si el índice supera el tamaño de la lista, no se encontró.
        if (index >= flota.size()) {
            return null;
        }
        // Caso base: si la patente del vehículo en el índice actual coincide.
        if (flota.get(index).getPatente().equalsIgnoreCase(patente)) {
            return flota.get(index);
        }
        // Paso recursivo: llamar al método con el siguiente índice.
        return buscarVehiculoPorPatenteRecursivo(patente, index + 1);
    }

    /**
     * Filtra y muestra vehículos que cumplen con un criterio de kilometraje.
     * Utiliza una lambda con filter y forEach.
     */
    public void filtrarVehiculosPorKm() {
        System.out.print("\nMostrar vehículos con kilometraje mayor a: ");
        try {
            double km = scanner.nextDouble();
            scanner.nextLine(); // Consumir newline

            System.out.println("Vehículos con más de " + km + " km:");
            // Interfaz lambda: filter para seleccionar y forEach para imprimir
            flota.stream()
                 .filter(v -> v.getKilometraje() > km)
                 .forEach(System.out::println);

        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Por favor, ingrese un número.");
            scanner.nextLine();
        }
    }

    /**
     * Demuestra el uso de varios bucles y sentencias de control.
     */
    public void demostrarBuclesYControl() {
        System.out.println("\n--- Demostración de Bucles y Control ---");

        // do-while: se ejecuta al menos una vez
        int i = 0;
        System.out.println("Recorriendo con do-while y 'continue':");
        do {
            if (i % 2 != 0) {
                i++;
                continue; // Salta los vehículos en índices impares
            }
            if (i < flota.size()) {
                System.out.println("Vehículo en índice par " + i + ": " + flota.get(i).getMarca());
            }
            i++;
        } while (i < flota.size());

        // while y break
        System.out.println("\nBuscando el primer camión con 'while' y 'break':");
        int j = 0;
        boolean encontrado = false;
        while (j < flota.size()) {
            Vehiculo v = flota.get(j);
            if (v instanceof Camion) {
                System.out.println("Primer camión encontrado: " + v.getMarca() + " " + v.getModelo());
                encontrado = true;
                break; // Termina el bucle al encontrar el primer camión
            }
            j++;
        }
        if (!encontrado) {
            System.out.println("No hay camiones en la flota.");
        }
    }
}
