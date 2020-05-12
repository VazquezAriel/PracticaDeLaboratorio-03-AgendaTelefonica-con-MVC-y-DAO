/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.vista;

import ec.edu.ups.modelo.Usuario;
import java.util.Collection;
import java.util.Scanner;

/**
 *
 * @author ariel
 */
public class VistaUsuario {

    private Scanner leer;

    public VistaUsuario() {
        leer = new Scanner(System.in);
    }

    public Usuario ingresarUsuario() {
        System.out.println("Ingrese los datos del usuario\n");
        System.out.print("Cedula:  ");
        String cedula = leer.nextLine();
        System.out.print("Nombre:  ");
        String nombre = leer.nextLine();
        System.out.print("Apellido:  ");
        String apellido = leer.nextLine();
        System.out.print("Correo Electronico:  ");
        String correo = leer.nextLine();
        System.out.print("Contraseña:  ");
        String contraseña = leer.nextLine();
        return new Usuario(cedula, nombre, apellido, correo, contraseña);
    }

    public Usuario inicioSecion() {
        System.out.println("Ingrese sus datos:\n");
        System.out.print("Correo Electronico:  ->");
        String correo = leer.nextLine();
        System.out.print("Contraseña:  ->");
        String contraseña = leer.nextLine();
        return new Usuario(null, null, null, correo, contraseña);
    }

    public Usuario actualizarUsuario(String cedula) {
        System.out.println("\nIngrese los nuevos datos\n");
        System.out.print("Nombre:  ");
        String nombre = leer.nextLine();
        System.out.print("Apellido:  ");
        String apellido = leer.nextLine();
        System.out.print("Correo Electronico:  ");
        String correo = leer.nextLine();
        System.out.print("Contraseña:  ");
        String contraseña = leer.nextLine();
        return new Usuario(cedula, nombre, apellido, correo, contraseña);
    }

    public Usuario eliminarUsuario(String cedula) {
        return new Usuario(cedula, null, null, null, null);
    }

    public void verUsuario(Usuario usuario) {
        System.out.println("Datos del Usuario: " + usuario);
    }

    public void verUsuarios(Collection<Usuario> usuarios) {
        for (Usuario usuario : usuarios) {
            System.out.println("Datos del Usuario: " + usuario);
        }
    }
}
