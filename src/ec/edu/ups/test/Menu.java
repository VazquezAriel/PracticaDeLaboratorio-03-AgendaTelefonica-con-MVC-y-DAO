/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.test;

import java.util.Scanner;

/**
 *
 * @author ariel
 */
public class Menu {

    public static void main(String[] args) {

        int opcion = 0;
        int opcion2 = 0;
        Scanner leer = new Scanner(System.in);

        while (opcion != 4) {

            System.out.println("------------------------------------------------------");
            System.out.println("              AGENDA TELEFONICA UPS");
            System.out.println("------------------------------------------------------\n");

            System.out.println("1).- Registrarse");
            System.out.println("2).- Iniciar Secion");
            System.out.println("3).- Mostrar Usuarios Registrados");
            System.out.println("4).- Salir");
            System.out.print("\nSeleccione una opcion:  ->");
            opcion = leer.nextInt();

            switch (opcion) {

                case 1:
                    System.out.println("------------------------------------------------------");
                    System.out.println("                        REGISTRO");
                    System.out.println("------------------------------------------------------\n");
                    break;
                    
                case 2:
                    System.out.println("------------------------------------------------------");
                    System.out.println("                   INICIO DE SESION");
                    System.out.println("------------------------------------------------------\n");
                    
                    while (opcion2 != 7) {
                        
                        System.out.println("1).- Editar numero de cedula");
                        System.out.println("2).- Editar nombre");
                        System.out.println("3).- Editar apellido");
                        System.out.println("4).- Editar correo electronico");
                        System.out.println("5).- Editar contraseña");
                        System.out.println("6).- Editar telefonos");
                        System.out.println("7).- Volver al menu");
                        System.out.print("\nSeleccione una opcion:  ->");
                        opcion2 = leer.nextInt();
                        
                        switch (opcion2 ){
                            
                            case 1:
                                break;
                                
                            case 2:
                                break;
                                
                            case 3:
                                break;
                                
                            case 4:
                                break;
                            
                            case 5:
                                break;
                                
                            case 6:
                                break;
                                
                            case 7:
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
