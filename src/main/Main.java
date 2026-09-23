package main;

import java.util.Scanner;
// import java.util.ArrayList; Eliminamos

import modelo.Ciudadano;
import modelo.Requisito;
import modelo.SolicitudLicencia;
import dao.CiudadanoDAO;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //ArrayList<SolicitudLicencia> listaSolicitudes = new ArrayList<>(); Eliminamos
        boolean salir = false;
        // int cFolio = 1000; Eliminamos

        System.out.println("\n-------------------- Base de Datos Atención Ciudadana --------------------");

        while (!salir) {
            System.out.println("\n-------------------- Menú Principal\n");
			System.out.print("1. Registrar nuevo trámite de licencia.\n2. Consultar historial de trámites.\n3. Salir del sistema.\nElija una opción: ");
            
            int opcion = sc.nextInt();
            sc.nextLine(); 

            if (opcion == 1) {
                System.out.println("\n[A] Datos del ciudadano");
				System.out.print("-> Nombre completo: ");
				String nombre = sc.nextLine();
				System.out.print("-> CURP: ");
				String curp = sc.nextLine();
				System.out.print("-> Teléfono: ");
				String telefono = sc.nextLine();
                
                Ciudadano ciudadano = new Ciudadano(nombre, curp, telefono);
                
                System.out.println("\n[B] Datos del trámite");
				System.out.print("-> Tipo de licencia:\n	1. Primera vez.\n	2. Renovación.\nElija una opción: ");
                
                int opLicencia = sc.nextInt();
                sc.nextLine();
                String tipoLicencia = "";

                if (opLicencia == 1) {
                    tipoLicencia = "PRIMERA VEZ";
                } else if (opLicencia == 2) {
                    tipoLicencia = "RENOVACIÓN";
                } else {
                    tipoLicencia = "NO ESPECIFICADO";
                    System.out.println("\n¡Advertencia! Opción no válida, trámite marcado como no especificado.");
                }
                
                Requisito requisito = new Requisito("Identificación Oficial y Comprobante de domicilio");
                System.out.print("\n-> ¿El ciudadano entregó todos los documentos? 1. Si - 2. No: ");
                int entrego = sc.nextInt();
                sc.nextLine();
                
                if (entrego == 1) {
                    requisito.marcarComoEntregado();
                }
                
                SolicitudLicencia nuevaSolicitud = new SolicitudLicencia(001, tipoLicencia, ciudadano, requisito);
                nuevaSolicitud.procesarSolicitud();

                //listaSolicitudes.add(nuevaSolicitud); Eliminamos
                //cFolio++; Eliminamos
                
                CiudadanoDAO ciudadanoDAO = new CiudadanoDAO(); // AGREGAMOS EL OBJETO DE LA CLASE
                ciudadanoDAO.registrarCiudadano(ciudadano, nuevaSolicitud, requisito);
            } else if (opcion == 2) {
				/*System.out.println("\n -------------------- Historial de trámites");
				if (listaSolicitudes.isEmpty()) {
					System.err.println("\n -> Aún no hay ningún trámite registrado en el sistema.");
				} else {
					for (int i = 0; i < listaSolicitudes.size(); i++) {
						System.out.println("\n	>> Registro #" + (i + 1) + " <<");
						listaSolicitudes.get(i).consultarEstado();
					}
				}*/

                CiudadanoDAO ciudadanoDAO = new CiudadanoDAO();
                ciudadanoDAO.consultarHistorial();
            } else if (opcion == 3) {
                salir = true;
                //System.out.println("\n-> Cerrando la ventanilla... ¡Se han guardado " + listaSolicitudes.size() + " trámites hoy!\n");
				System.out.println("\n-> Cerrando la ventanilla... ¡Hasta pronto!\n");
            } else {
                System.out.println("\n-> Opción no válida. Por favor intenta de nuevo.");
            }
        }
        sc.close();
    }
}