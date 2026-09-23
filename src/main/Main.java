// Declaración de paquete
package main;

// Importación de herramientas
import java.util.Scanner;
// import java.util.ArrayList; Eliminamos

// Importación de clases de otro paquete
import modelo.Ciudadano;
import modelo.Requisito;
import modelo.SolicitudLicencia;
import dao.CiudadanoDAO; // Agregamos

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //ArrayList<SolicitudLicencia> listaSolicitudes = new ArrayList<>(); Eliminamos
        
        boolean salir = false;
        // int cFolio = 1000; Eliminamos

        System.out.println("=".repeat(50));
        System.out.println("    VENTANILLA DE TRÁMITES CIUDADANOS");
        System.out.println("=".repeat(50));

        while (!salir) {
            System.out.println("\n");
            System.out.println("=".repeat(50));
            System.out.println("    MENÚ PRINCIPAL");
            System.out.println("=".repeat(50));
            System.out.println("[1] Registrar nuevo trámite de licencia.\n[2] Consultar historial de trámites.\n[3] Salir del sistema.\nElija una opción:");
            
            int opcion = sc.nextInt();
            sc.nextLine(); 

            if (opcion == 1) {
                System.out.println("\n");
                System.out.println("=".repeat(50));
                System.out.println("    [A]. Datos del Ciudadano");
                System.out.println("=".repeat(50));
                System.out.print(">> Nombre completo: ");
                String nombre = sc.nextLine();
                System.out.print(">> CURP: ");
                String curp = sc.nextLine();
                System.out.print(">> Teléfono: ");
                String telefono = sc.nextLine();
                
                Ciudadano ciudadano = new Ciudadano(nombre, curp, telefono);
                
                System.out.println("\n");
                System.out.println("=".repeat(50));
                System.out.println("    [B]. Datos del Trámite");
                System.out.println("=".repeat(50));
                System.out.println(">> Tipo de licencia:\n[1] Primera Vez.\n[2] Renovación.\nElija una opción:");
                
                int opLicencia = sc.nextInt();
                sc.nextLine();
                
                String tipoLicencia = "";

                if (opLicencia == 1) {
                    tipoLicencia = "Primera Vez";
                } else if (opLicencia == 2) {
                    tipoLicencia = "Renovación";
                } else {
                    tipoLicencia = "No Especificado";
                    System.out.println("\n>> ¡ADVERTENCIA!: Opción no válida, trámite marcado como NO ESPECIFICADO.");
                }
                
                Requisito requisito = new Requisito("Identificación Oficial y Comprobante de domicilio");
                System.out.println("\n¿El ciudadano entregó todos los documentos?\n[1] Sí.\n[2] No.\nElija una opción (1-2):");
                int entrego = sc.nextInt();
                sc.nextLine();
                
                if (entrego == 1) {
                    requisito.marcarComoEntregado();
                }
                
                SolicitudLicencia nuevaSolicitud = new SolicitudLicencia(0, tipoLicencia, ciudadano, requisito);
                nuevaSolicitud.procesarSolicitud();

                //listaSolicitudes.add(nuevaSolicitud); Eliminamos
                //cFolio++; Eliminamos
                
                CiudadanoDAO ciudadanoDAO = new CiudadanoDAO(); // Agregamos
                ciudadanoDAO.registrarCiudadano(ciudadano, nuevaSolicitud, requisito); // Agregamos
                
            } else if (opcion == 2) {

                /* ELIMINAMOS
                System.out.println("\n");    
                System.out.println("=".repeat(50));    
                System.out.println("    HISTORIAL DE TRÁMITES");    
                System.out.println("=".repeat(50));    

                if (listaSolicitudes.isEmpty()) {
                    System.out.println(">> Aún no hay ningún trámite registrado en el sistema.");
                } else {
                    for (int i = 0; i < listaSolicitudes.size(); i++) {
                        System.out.println("\nRegistro #" + (i+1) + ":");
                        listaSolicitudes.get(i).consultarEstado();
                    }
                }
                */

                CiudadanoDAO ciudadanoDAO = new CiudadanoDAO(); // Agregamos
                ciudadanoDAO.consultarHistorial(); // Agregamos
                
            } else if (opcion == 3) {
                salir = true;
                System.out.println("\nCerrando la ventanilla... ¡Hasta pronto!");
            } else {
                System.out.println("\nOpción no válida. Por favor, intente de nuevo.");
            }
        }

        sc.close();
    }
}