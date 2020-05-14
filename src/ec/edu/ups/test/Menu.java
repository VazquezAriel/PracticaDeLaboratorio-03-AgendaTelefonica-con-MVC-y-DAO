/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.test;

import ec.edu.ups.controlador.ControladorTelefono;
import ec.edu.ups.controlador.ControladorUsuario;
import ec.edu.ups.dao.TelefonoDAO;
import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.modelo.Usuario;
import ec.edu.ups.vista.VistaTelefono;
import ec.edu.ups.vista.VistaUsuario;
import java.util.Scanner;

/**
 *
 * @author ariel
 */
public class Menu {

    private static final Scanner leer = new Scanner(System.in);
    //DAO
    private static final TelefonoDAO telefonoDAO = new TelefonoDAO();
    private static final UsuarioDAO usarioDAO = new UsuarioDAO();
    //Vista
    private static final VistaUsuario vistaUsuario = new VistaUsuario();
    private static final VistaTelefono vistaTelefono = new VistaTelefono();
    //Controlador
    private static final ControladorTelefono controladorTelefono = new ControladorTelefono(vistaTelefono, telefonoDAO);
    private static final ControladorUsuario controladorUsuario = new ControladorUsuario(vistaTelefono, vistaUsuario, usarioDAO, telefonoDAO);

    //Metodo main
    public static void main(String[] args) {

        //Dato en el que se guardara la opcion que escoja el usuario 
        int opcion = 0;
        //Menu Principal
        while (opcion != 5) {

            System.out.println("------------------------------------------------------");
            System.out.println("              AGENDA TELEFONICA UPS");
            System.out.println("------------------------------------------------------");
            System.out.println("1)- Registrarse");
            System.out.println("2)- Iniciar Sesion");
            System.out.println("3)- Mostrar Usuarios Registrados");
            System.out.println("4)- Mostrar Telefonos Registrados");
            System.out.println("5)- Salir");
            System.out.println("------------------------------------------------------");
            System.out.print("Seleccione una opcion:  -> ");
            opcion = leer.nextInt();

            switch (opcion) {

                case 1:
                    System.out.println("------------------------------------------------------");
                    controladorUsuario.registrar();
                    System.out.println("\n*********  Te has registrado con exito  **************");
                    break;
                case 2:
                    System.out.println("------------------------------------------------------");
                    System.out.println("                   INICIO DE SESION");
                    System.out.println("------------------------------------------------------");
                    
                    String cedula = incioDeSesion();
                    if (cedula == null) {
                        break;
                    }

                    //Dato en en donde se guardar la opcion que escoja el usuario
                    int opcion2 = 0;
                    //Submenu
                    while (opcion2 != 9) {

                        System.out.println("\n1)- Añadir un Telefono");
                        System.out.println("2)- Editar telefono");
                        System.out.println("3)- Eliminar Telefono");
                        System.out.println("4)- Buscar Telefono");
                        System.out.println("5)- Listar Telefonos");
                        System.out.println("6)- Mostrar datos");
                        System.out.println("7)- Editar Datos");
                        System.out.println("8)- Eliminar Usuario");
                        System.out.println("9)- Volver al menu");
                        System.out.print("\nSeleccione una opcion:  -> ");
                        opcion2 = leer.nextInt();

                        switch (opcion2) {

                            case 1:
                                controladorUsuario.agregarTelefono(cedula, controladorTelefono.crear());
                                System.out.println("\n*********  Telefono añadido con exito  **************");
                                break;
                            case 2:
                                controladorUsuario.editarTelefono(cedula);
                                break;
                            case 3:
                                controladorUsuario.eliminarTelefono(cedula);
                                break;
                            case 4:
                                controladorUsuario.buscarTelefono(cedula);
                                break;
                            case 5:
                                controladorUsuario.listarTelefonos(cedula);
                                break;
                            case 6:
                                controladorUsuario.verUsuario(cedula);
                                break;
                            case 7:
                                controladorUsuario.actualizar(cedula);
                                System.out.println("\n******  Datos actualizados correctamente **********");
                                break;
                            case 8:
                                controladorUsuario.eliminar(cedula);
                                System.out.println("\n*************  Usuario Eliminado  ****************");
                                System.out.println("\n********   Volviendo al menu......   *************");
                                opcion2 = 6;
                                break;
                            case 9:
                                System.out.println("\n********   Volviendo al menu......   *************");
                                break;
                            default:
                                System.out.println("\n*****La opcion que eligio no existe*****\n");

                        }

                    }
                    break;
                case 3:
                    System.out.println("------------------------------------------------------");
                    System.out.println("                 USUARIOS REGISTRADOS");
                    System.out.println("------------------------------------------------------");
                    controladorUsuario.verUsuarios();
                    break;
                case 4:
                    System.out.println("------------------------------------------------------");
                    System.out.println("                TELEFONOS REGISTRADOS");
                    System.out.println("------------------------------------------------------");
                    controladorTelefono.verTelefonos();
                    break;
                case 5:
                    System.out.println("------------------------------------------------------");
                    System.out.println("                EL PROGRAMA A FINALIZADO");
                    System.out.println("------------------------------------------------------\n");
                    break;
                default:
                    System.out.println("\n*****La opcion que eligio no existe*****\n");

            }

        }

    }

    //Llama al metodo Autentificar para Generar un Usuario y si este es diferente de null obtener el nombre y la cedula de dicho usuario
    public static String incioDeSesion() {
        Usuario usuarioAutentificado = controladorUsuario.Autentificar();
        if (usuarioAutentificado == null) {
            System.out.println("\n****  Correo electronico o contraseña incorrectos  ****");
            return null;
        } else {
            System.out.println("\n******** Bienvenido de nuevo " + usuarioAutentificado.getNombre() + " ********");
            return usuarioAutentificado.getCedula();
        }
    }

}
