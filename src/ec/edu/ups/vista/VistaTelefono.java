/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.vista;

import ec.edu.ups.modelo.Telefono;
import java.util.Collection;
import java.util.Scanner;

/**
 *
 * @author ariel
 */
public class VistaTelefono {
    
    private Scanner leer;

    //Constructor
    public VistaTelefono() {
        leer = new Scanner(System.in);
    }
    
    //Obtiene los datos ingresados por teclado y genera un Telefono con dichos datos
    public Telefono ingresarTelefono() {
        System.out.println("\nIngrese los datos del Telefono\n");
        System.out.print("Codigo:  ");
        String codigo = leer.nextLine();
        System.out.print("Numero:  ");
        String numero = leer.nextLine();
        System.out.print("Tipo:  ");
        String tipo = leer.nextLine();
        System.out.print("Operadora:  ");
        String operadora = leer.nextLine();
        return new Telefono(codigo, numero, tipo, operadora);
    }
    
    //Obtiene los datos ingresados por teclado y genera un Telefono con dichos datos
    public Telefono actualizarTelefono() {
        System.out.print("Ingrese el codigo del telefono que decea editar:  ");
        String codigo = leer.nextLine();
        System.out.println("\nIngrese los nuevos datos del Telefono\n");
        System.out.print("Numero:  ");
        String numero = leer.nextLine();
        System.out.print("Tipo:  ");
        String tipo = leer.nextLine();
        System.out.print("Operadora:  ");
        String operadora = leer.nextLine();
        return new Telefono(codigo, numero, tipo, operadora);
    }
    
    //Obtiene la clave de un Telefono ingresado por teclado y genera un Telefono con dicha clave
    public Telefono eliminarTelefono() {
        System.out.print("Ingrese el codigo del telefono que decea eliminar:  ");
        String codigo = leer.nextLine();
        return new Telefono(codigo, null, null, null);
    }
    
    //Obtiene la clave de un Telefono ingresado por teclado
    public String buscarTelefono() {
        System.out.print("\nIngrese el codigo del Telefono buscado:  ");
        String codigo = leer.nextLine();
        return codigo;
    }

    //Muestra en pantalla una Coleccion de telefonos
    public void verTelefonos(Collection<Telefono> telefonos) {
        int aux = 0;
        System.out.println("");
        for (Telefono telefono : telefonos) {
            System.out.println("Telefono #" + ++aux + ":");
            System.out.println("Datos del Telefono: " + telefono);
            System.out.println("------------------------------------------------------");
        }
    }
    
    //Muestra en pantalla un Telefono
    public void verTelefono(Telefono telefono) {
        System.out.println("Telefono:  " + telefono);
    }
    
}
