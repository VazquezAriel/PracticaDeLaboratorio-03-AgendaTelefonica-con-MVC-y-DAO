/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.vista;

import ec.edu.ups.modelo.Telefono;
import ec.edu.ups.modelo.Usuario;
import java.util.Collection;
import java.util.Scanner;

/**
 *
 * @author ariel
 */
public class VistaTelefono {
    
    private Scanner leer;

    public VistaTelefono() {
        leer = new Scanner(System.in);
    }
    
    public Telefono ingresarTelefono() {
        System.out.println("Ingrese los datos del Telefono\n");
        System.out.print("Codigo:  ");
        int codigo = leer.nextInt();
        leer.nextLine();
        System.out.print("Numero:  ");
        String numero = leer.nextLine();
        System.out.print("Tipo:  ");
        String tipo = leer.nextLine();
        System.out.print("Operadora:  ");
        String operadora = leer.nextLine();
        return new Telefono(codigo, numero, tipo, operadora);
    }
    
    public Telefono actualizarTelefono() {
        System.out.print("Ingrese el numero del telefono que decea editar:  ");
        String numero = leer.nextLine();
        System.out.println("\nIngrese los nuevos datos del Telefono\n");
        System.out.print("Codigo:  ");
        int codigo = leer.nextInt();
        leer.nextLine();
        System.out.print("Tipo:  ");
        String tipo = leer.nextLine();
        System.out.print("Operadora:  ");
        String operadora = leer.nextLine();
        return new Telefono(codigo, numero, tipo, operadora);
    }
    
    public Telefono eliminarTelefono() {
        System.out.print("Ingrese el numero del telefono que decea editar:  ");
        String numero = leer.nextLine();
        return new Telefono(0, numero, null, null);
    }
    
    public Telefono buscarTelefono() {
        System.out.print("Ingrese el numero de telefono que decea buscar:  ");
        String numero = leer.nextLine();
        return new Telefono(0, numero, null, null);
    }

    public void verTelefonos(Collection<Telefono> telefonos) {
        for (Telefono telefono : telefonos) {
            System.out.println("Datos del Usuario: " + telefono);
        }
    }
    
}
