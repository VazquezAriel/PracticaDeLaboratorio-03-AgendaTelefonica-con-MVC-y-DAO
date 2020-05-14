/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.idao.ITelefonoDAO;
import ec.edu.ups.idao.IUsuarioDAO;
import ec.edu.ups.modelo.Telefono;
import ec.edu.ups.modelo.Usuario;
import ec.edu.ups.vista.VistaTelefono;
import ec.edu.ups.vista.VistaUsuario;
import java.util.Collection;

/**
 *
 * @author ariel
 */
public class ControladorUsuario {
    
    //Objetos vista
    private VistaTelefono vistaTelefono;
    private VistaUsuario vistaUsuario;
    //Objetos modelo
    private Usuario usuario;
    private Telefono telefono;
    //Objetos DAO
    private IUsuarioDAO usuarioDAO;
    private ITelefonoDAO telefonoDAO;

    //Constructor sin parametros
    public ControladorUsuario() {

    }
    
    //Constructor con parametros
    public ControladorUsuario(VistaTelefono vistaTelefono, VistaUsuario vistaUsuario, IUsuarioDAO usuarioDAO, ITelefonoDAO telefonoDAO) {
        this.vistaTelefono = vistaTelefono;
        this.vistaUsuario = vistaUsuario;
        this.usuarioDAO = usuarioDAO;
        this.telefonoDAO = telefonoDAO;
    }

    //Crea un Usuario atraves de la vista y lo agrega al diccionario creado en el DAO
    public void registrar() {
        usuario = vistaUsuario.ingresarUsuario();
        usuarioDAO.create(usuario);
    }

    //Llama al DAO para obtener el Usuario correspondiente a la clave ingresada y lo muestra en pantalla atraves de la vista
    public void verUsuario(String cedula) {
        usuario = usuarioDAO.read(cedula);
        vistaUsuario.verUsuario(usuario);
    }

    //Genera un Usuario con la clave ingresada atraves de la vista y lo remplaza atraves del DAO
    public void actualizar(String cedula) {
        usuario = vistaUsuario.actualizarUsuario(cedula);
        usuarioDAO.update(usuario);
    }
    
    //Genera un Usuario con la clave ingresada atraves de la vista y lo elimina atraves del DAO
    public void eliminar(String cedula) {
        usuario = vistaUsuario.eliminarUsuario(cedula);
        usuarioDAO.delete(usuario);
    }

    //Genera un Usuario atraves de la vista y compara con cada Usuario existente en el DAO
    public Usuario Autentificar() {
        usuario = vistaUsuario.iniciarSecion();
        Collection<Usuario> usuarios = usuarioDAO.findAll();
        for (Usuario usuario1 : usuarios) {
            if (usuario.equals(usuario1)) {
                return usuario1;
            }
        }
        return null;
    }

    //Muestra en pantalla todos los usuarios existentes en el DAO atraves de la vista
    public void verUsuarios() {
        Collection<Usuario> usuarios;
        usuarios = usuarioDAO.findAll();
        if (!usuarios.isEmpty()) {
            vistaUsuario.verUsuarios(usuarios);
        } else {
            System.out.println("Aun no tienes usuarios creados");
        }
    }

    //Genera un Usuario con la clave ingresada y a este se le agrega el telefono ingresado
    public void agregarTelefono(String cedula, Telefono telefono) {
        usuario = usuarioDAO.read(cedula);
        usuario.agregarTelefono(telefono);
        usuarioDAO.update(usuario);
    }

    //Obtiene un Usuario atraves del DAO con la clave ingresada, Obtiene un Telefono atraves de la vista y elimina dicho telefono del Usuario
    public void eliminarTelefono(String cedula) {
        usuario = usuarioDAO.read(cedula);
        vistaTelefono.verTelefonos(usuario.listarTelefonos());
        telefono = vistaTelefono.eliminarTelefono();
        if (usuario.listarTelefonos().contains(telefono)) {
            usuario.eliminarTelefono(telefono);
            telefonoDAO.delete(telefono);
            System.out.println("\n*********  Telefono eliminado exitosamente **********");
        } else {
            System.out.println("\nTelefono no encontrado en tu lista de telefonos");
        }
    }

    //Obtiene un Usuario atraves del DAO con la clave ingresada, Obtiene un Telefono atraves de la vista y actualiza dicho telefono del Usuario
    public void editarTelefono(String cedula) {
        System.out.println("\nTelefonos Disponibles: ");
        usuario = usuarioDAO.read(cedula);
        vistaTelefono.verTelefonos(usuario.listarTelefonos());
        telefono = vistaTelefono.actualizarTelefono();
        if (usuario.listarTelefonos().contains(telefono)) {
            usuario.editarTelefono(telefono);
            telefonoDAO.update(telefono);
            System.out.println("\n*********  Telefono Actualizado exitosamente **********");
        } else {
            System.out.println("\nTelefono no encontrado en tu lista de telefonos");
        }
    }
    
    //Obtiene un Usuario atraves del DAO con la clave ingresada, Obtiene un Telefono atraves de la vista y compara si dicho telefono esta agregado en el Usuario
    public void buscarTelefono(String cedula) {
        usuario = usuarioDAO.read(cedula);
        String codigo = vistaTelefono.buscarTelefono();
        telefono = telefonoDAO.read(codigo);
        if (usuario.listarTelefonos().contains(telefono)) {
            System.out.println("\nTelefono encontrado: ");
            System.out.println(telefono);
        } else {
            System.out.println("\nTelefono no encontrado");
        }
    }
    
    //Obtiene un Usuario atraves del DAO con la clave ingresada y muestra en pantalla todos los Telefonos agregados en el Usuario atraves de la vista
    public void listarTelefonos(String cedula) {
        usuario = usuarioDAO.read(cedula);
        if (!usuario.listarTelefonos().isEmpty()) {
            System.out.println(usuario.listarTelefonos());
        } else {
            System.out.println("\nAun no tienes telefonos registrados");
        }
    }

}
