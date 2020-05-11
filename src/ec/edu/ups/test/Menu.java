/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.test;

import ec.edu.ups.controlador.ControladorUsuario;
import ec.edu.ups.vista.VistaUsuario;
import java.util.Scanner;

/**
 *
 * @author ariel
 */
public class Menu {

    public static void main(String[] args) {

        int opcion = 0;
        Scanner leer = new Scanner(System.in);
        VistaUsuario vistaUsuario = new VistaUsuario();
        ControladorUsuario controladorUsuario = new ControladorUsuario(vistaUsuario);

        while (opcion != 4) {

            System.out.println("------------------------------------------------------");
            System.out.println("              AGENDA TELEFONICA UPS");
            System.out.println("------------------------------------------------------\n");

            System.out.println("1).- Registrarse");
            System.out.println("2).- Iniciar Sesion");
            System.out.println("3).- Mostrar Usuarios Registrados");
            System.out.println("4).- Salir");
            System.out.print("\nSeleccione una opcion:  ->");
            opcion = leer.nextInt();

            switch (opcion) {

                case 1:
                    System.out.println("------------------------------------------------------");
                    System.out.println("                        REGISTRO");
                    System.out.println("------------------------------------------------------\n");
                    
                    controladorUsuario.registrar();
                    System.out.println("\n*********  Usuario registrado con exito  **************");
                    break;
                    
                case 2:
                    int opcion2 = 0;
                    System.out.println("------------------------------------------------------");
                    System.out.println("                   INICIO DE SESION");
                    System.out.println("------------------------------------------------------\n");
                    String cedula = controladorUsuario.Autentificar();
                    if (cedula == null) {
                        System.out.println("\n****  Correo electronico o contraseña incorrectos  ****");
                        break;
                    }
                 
                    while (opcion2 != 4) {
                        
                        System.out.println("\n1).- Editar Datos");
                        System.out.println("2).- Mostrar datos");
                        System.out.println("3).- Eliminar Usuario");
                        System.out.println("4).- Volver al menu");
                        System.out.print("\nSeleccione una opcion:  ->");
                        opcion2 = leer.nextInt();
                        
                        switch (opcion2 ){
                            
                            case 1:
                                controladorUsuario.actualizar();
                                break;
                                
                            case 2:
                                controladorUsuario.eliminar();
                                break;
                                
                            case 3:
                                controladorUsuario.verUsuario();
                                break;
                                
                            case 4:
                                break;
                            
                            default:
                                System.out.println("\n*****La opcion que eligio no existe*****\n");
                            
                        }
                    
                    }
                    break;
                    
                case 3:
                    System.out.println("------------------------------------------------------");
                    System.out.println("                 USUARIOS REGISTRADOS");
                    System.out.println("------------------------------------------------------\n");
                    controladorUsuario.verUsuarios();
                    break;
                    
                case 4:
                    System.out.println("------------------------------------------------------");
                    System.out.println("                EL PROGRAMA A FINALIZADO");
                    System.out.println("------------------------------------------------------\n");
                    break;
                    
                default :
                    System.out.println("\n*****La opcion que eligio no existe*****\n");
                        

            }

        }

    }

}
