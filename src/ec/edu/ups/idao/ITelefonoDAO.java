/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.idao;

import ec.edu.ups.modelo.Telefono;
import java.util.Collection;

/**
 *
 * @author ariel
 */
public interface ITelefonoDAO {
    
    //Metodos CRUD
    public void create(Telefono telefono);
    public Telefono read(String codigo);
    public void update(Telefono telefono);
    public void delete(Telefono telefono);
    public Collection<Telefono> findAll();
}
