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
import java.util.Collection;

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

    public void verUsuario(String cedula) {
        usuario = usuarioDAO.read(cedula);
        vistaUsuario.verUsuario(usuario);
    }

    public void actualizar(String cedula) {
        usuario = vistaUsuario.actualizarUsuario(cedula);
        usuarioDAO.update(usuario);
    }
    
    public void actualizar(Usuario usuario) {
        usuarioDAO.update(usuario);
    }

    public void eliminar(String cedula) {
        usuario = vistaUsuario.eliminarUsuario(cedula);
        usuarioDAO.delete(usuario);
    }

    public Usuario Autentificar() {
        Collection<Usuario> usuarios = usuarioDAO.findAll();
        usuario = vistaUsuario.inicioSecion();
        for (Usuario usuario1 : usuarios) {
            if (usuario.equals(usuario1)) {
                return usuario1;
            }
        }
        return null;
    }

    public Usuario mostrarUsuario(String cedula) {
        Collection<Usuario> usuarios = usuarioDAO.findAll();
        usuario = vistaUsuario.inicioSecion();
        for (Usuario usuario1 : usuarios) {
            if (usuario1.getCedula().equals(cedula)) {
                return usuario1;
            }
        }
        return null;
    }

    public void verUsuarios() {
        Collection<Usuario> usuarios;
        usuarios = usuarioDAO.findAll();
        vistaUsuario.verUsuarios(usuarios);
    }

}
