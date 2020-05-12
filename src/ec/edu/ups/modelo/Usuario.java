/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

import ec.edu.ups.vista.VistaTelefono;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 *
 * @author ariel
 */
public class Usuario {
    
    private String cedula;
    private String nombre;
    private String apellido;
    private String correo;
    private String contraseña;
    private Map<String, Telefono> telefonos;
    private VistaTelefono vistaTelefono;

    public Usuario(String cedula, String nombre, String apellido, String correo, String contraseña) {
        vistaTelefono = new VistaTelefono();
        telefonos = new HashMap<String, Telefono>();
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contraseña = contraseña;
    }

    public Usuario() {
        
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    public void agregarTelefono() {
        Telefono telefono = vistaTelefono.ingresarTelefono();
        telefonos.put(telefono.getNumero(), telefono);
    }
    
    public void editarTelefono() {
        Telefono telefono = vistaTelefono.actualizarTelefono();
        telefonos.put(telefono.getNumero(), telefono);
    }
    
    public void eliminarTelefono() {
        Telefono telefono = vistaTelefono.eliminarTelefono();
        telefonos.remove(telefono.getNumero());
    }
    
    public Telefono buscarTelefono() {
        Telefono telefono = vistaTelefono.buscarTelefono();
        Collection<Telefono> telefonos = this.telefonos.values();
        for (Telefono telefono1 : telefonos) {
            if (telefono1.equals(telefono)) {
                return telefono1;
            }
        }
        return null;
    }
    
    public void listarTelefonos() {
        Collection<Telefono> telefonos = this.telefonos.values();
        for (Telefono telefono1 : telefonos) {
            System.out.println(telefono1);
        }
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.correo);
        hash = 53 * hash + Objects.hashCode(this.contraseña);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.correo, other.correo)) {
            return false;
        }
        if (!Objects.equals(this.contraseña, other.contraseña)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Usuario{" + "cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + ", correo=" + correo + ", contrase\u00f1a=" + contraseña + '}';
    }
    
}
