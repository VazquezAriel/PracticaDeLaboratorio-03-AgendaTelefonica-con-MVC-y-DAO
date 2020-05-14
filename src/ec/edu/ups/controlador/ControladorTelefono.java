/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.idao.ITelefonoDAO;
import ec.edu.ups.modelo.Telefono;
import ec.edu.ups.vista.VistaTelefono;
import java.util.Collection;

/**
 *
 * @author ariel
 */
public class ControladorTelefono {
    
    //Objetos vista
    private VistaTelefono vistaTelefono;
    //Objeto Telefono
    private Telefono telefono;
    //Objetos DAO
    private ITelefonoDAO telefonosDAO ;

    //Constructor sin parametros
    public ControladorTelefono() {
        
    }

    //Constructor con parametros
    public ControladorTelefono(VistaTelefono vistaTelefono, ITelefonoDAO telefonosDAO) {
        this.vistaTelefono = vistaTelefono;
        this.telefonosDAO = telefonosDAO;
    }

    //Crea un Telefono atraves de la vista y lo agrega al diccionario creado en el DAO
    public Telefono crear() {
        telefono = vistaTelefono.ingresarTelefono();
        telefonosDAO.create(telefono);
        return telefono;
    }
    
    //Llama al DAO para obtener Telefono y lo muestra en pantalla atraves de la vista
    public void verTelefono() {
        String codigo = vistaTelefono.buscarTelefono();
        telefono = telefonosDAO.read(codigo);
        vistaTelefono.verTelefono(telefono);
    }
    
    //Llama al DAO para actualizar un Telefono
    public void actualizar() {
        telefono = vistaTelefono.actualizarTelefono();
        telefonosDAO.update(telefono);
    }
    
    //Llama al DAO para eliminar un Telefono
    public void eliminar() {
        telefono = vistaTelefono.eliminarTelefono();
        telefonosDAO.delete(telefono);
    }
    
    //Muestra todos los Telefonos existentes en el DAO
    public void verTelefonos() {
        Collection<Telefono> telefonos;
        telefonos = telefonosDAO.findAll();
        if (!telefonos.isEmpty()) {
            vistaTelefono.verTelefonos(telefonos);
        } else {
            System.out.println("Aun no tienes telefonos creados");
        }
    }
}
