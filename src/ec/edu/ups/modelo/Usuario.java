/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author ariel
 */
public class Usuario {

    //atributos
    private String cedula;
    private String nombre;
    private String apellido;
    private String correo;
    private String contraseña;
    //atributo de agregacion
    private List<Telefono> telefonos;

    //constructores
    public Usuario() {
        telefonos = new ArrayList<>();
    }

    public Usuario(String cedula, String nombre, String apellido, String correo, String contraseña) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contraseña = contraseña;
        telefonos = new ArrayList<>();
    }

    //Metodos Get y Set
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

    //Agrega un telefono a la lista telefonos
    public void agregarTelefono(Telefono telefono) {
        telefonos.add(telefono);
    }

    //Actualiza el telefono ingresado en la lista telefonos
    public void editarTelefono(Telefono telefono) {
        int index = telefonos.indexOf(telefono);
        telefonos.set(index, telefono);
    }

    //Elimina el telefono ingresado de la lista telefonos
    public void eliminarTelefono(Telefono telefono) {
        int index = telefonos.indexOf(telefono);
        telefonos.remove(index);
    }

    //Busca el Telefono correspondiente al codigo ingresado
    public Telefono buscarTelefono(int codigo) {
        return telefonos.get(codigo);
    }

    //debuelve la lista telefonos
    public List<Telefono> listarTelefonos() {
        return telefonos;
    }

    //Metodos de la clase Object
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
        if (!listarTelefonos().isEmpty()) {
            System.out.println("Telefonos: " + listarTelefonos());
        } else {
            System.out.println("Aun no tiene ningun telefono registrado");
        }
        return "{" + "cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + ", correo=" + correo + ", contrase\u00f1a=" + contraseña + '}';
    }

}
