
package com.empresa.gestionvehiculos;

import com.empresa.gestionvehiculos.servicios.GestionVehiculos;
import java.util.Scanner;

/**
 * Clase principal que contiene el punto de entrada de la aplicación (main).
 * Controla el menú de usuario y la interacción con el sistema de gestión.
 */
public class Main {

    public static void main(String[] args) {
        GestionVehiculos gestion = new GestionVehiculos();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        // Datos de ejemplo para iniciar
        cargarDatosDeEjemplo(gestion);

        do {
            mostrarMenu();
            try {
                System.out.print("Seleccione una opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea

                switch (opcion) {
                    case 1:
                        gestion.crearVehiculo();
                        break;
                    case 2:
                        System.out.print("Ingrese la patente a buscar: ");
                        String patente = scanner.nextLine().toUpperCase();
                        var vehiculo = gestion.buscarVehiculoPorPatenteRecursivo(patente, 0);
                        if (vehiculo != null) {
                            System.out.println("Vehículo encontrado: ");
                            vehiculo.mostrarInformacion(true); // Usa método sobrecargado
                        } else {
                            System.out.println("No se encontró ningún vehículo con esa patente.");
                        }
                        break;
                    case 3:
                        gestion.actualizarVehiculo();
                        break;
                    case 4:
                        gestion.eliminarVehiculo();
                        break;
                    case 5:
                        gestion.leerVehiculos();
                        break;
                    case 6:
                        gestion.filtrarVehiculosPorKm();
                        break;
                    case 7:
                        gestion.demostrarBuclesYControl();
                        break;
                    case 0:
                        System.out.println("Saliendo del sistema...");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                        break;
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Error: Debe ingresar un número. Intente de nuevo.");
                scanner.nextLine(); // Limpiar el buffer del scanner
                opcion = -1; // Asignar un valor para que el bucle continúe
            }
            if (opcion != 0) {
                System.out.println("\nPresione Enter para continuar...");
                scanner.nextLine();
            }

        } while (opcion != 0);

        scanner.close();
    }

    /**
     * Muestra el menú principal de la aplicación en la consola.
     */
    private static void mostrarMenu() {
        System.out.println("\n--- Sistema de Gestión de Vehículos ---");
        System.out.println("1. Crear Vehículo");
        System.out.println("2. Buscar Vehículo por Patente (Recursivo)");
        System.out.println("3. Actualizar Vehículo");
        System.out.println("4. Eliminar Vehículo");
        System.out.println("5. Listar todos los Vehículos");
        System.out.println("6. Filtrar Vehículos por Kilometraje");
        System.out.println("7. Demostración de Bucles");
        System.out.println("0. Salir");
    }

    /**
     * Carga datos de ejemplo en el sistema para facilitar las pruebas.
     * Este método no es parte de los requisitos principales, pero es útil para la depuración.
     * @param gestion La instancia del gestor de vehículos.
     */
    private static void cargarDatosDeEjemplo(GestionVehiculos gestion) {
        try {
            // Usamos un método interno de la clase para añadir vehículos sin pasar por el Scanner
            // Esto es una simplificación. En un sistema real, esto podría venir de una base de datos.
            java.lang.reflect.Field flotaField = gestion.getClass().getDeclaredField("flota");
            flotaField.setAccessible(true);
            @SuppressWarnings("unchecked")
            java.util.ArrayList<com.empresa.gestionvehiculos.modelos.Vehiculo> flota =
                (java.util.ArrayList<com.empresa.gestionvehiculos.modelos.Vehiculo>) flotaField.get(gestion);

            flota.add(new com.empresa.gestionvehiculos.modelos.Auto("Toyota", "Corolla", 2021, "AE123RT", 15000, 4));
            flota.add(new com.empresa.gestionvehiculos.modelos.Camion("Volvo", "FH16", 2019, "BC456DF", 120000, 25.5));
            flota.add(new com.empresa.gestionvehiculos.modelos.Auto("Ford", "Focus", 2022, "GH789JK", 5000, 5));
        } catch (Exception e) {
            // La reflexión puede lanzar varias excepciones
            System.out.println("Error al cargar datos de ejemplo: " + e.getMessage());
        }
    }
}
