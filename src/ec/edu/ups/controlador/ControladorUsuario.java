/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.idao.IUsuarioDAO;
import ec.edu.ups.modelo.Usuario;
import ec.edu.ups.vista.VistaUsuario;
import java.util.List;

/**
 *
 * @author ariel
 */
public class ControladorUsuario {
    
    private VistaUsuario vistaUsuario;
    private Usuario usuario;
    private IUsuarioDAO usuarioDAO;

    public ControladorUsuario(VistaUsuario vistaUsuario) {
        this.vistaUsuario = vistaUsuario;
        this.usuarioDAO = new UsuarioDAO();
    }
    
    public void registrar() {
        usuario = vistaUsuario.ingresarUsuario();
        usuarioDAO.create(usuario);
    }

    //llama al DAO para obtener un cliente por el id y luego los muestra en la vista
    public void verUsuario() {
        String cedula = vistaUsuario.buscarUsuario();
        usuario = usuarioDAO.read(cedula);
        vistaUsuario.verUsuario(usuario);
    }

    //llama al DAO para actualizar un cliente
    public void actualizar() {
        usuario = vistaUsuario.actualizarUsuario();
        usuarioDAO.update(usuario);
    }

    //llama al DAO para eliminar un cliente
    public void eliminar() {
        usuario = vistaUsuario.eliminarUsuario();
        usuarioDAO.delete(usuario);
    }

    //llama al DAO para obtener todos los clientes y luego los muestra en la vista
    public void verUsuarios() {
        List<Usuario> usuarios;
        usuarios = usuarioDAO.findAll();
        vistaUsuario.verUsuarios(usuarios);
    }

}
