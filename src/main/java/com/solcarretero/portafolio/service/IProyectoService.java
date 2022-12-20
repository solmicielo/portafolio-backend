
package com.solcarretero.portafolio.service;

import com.solcarretero.portafolio.model.Proyecto;
import java.util.List;


public interface IProyectoService {
    
    public List<Proyecto> verProyectos ();
    public void crearProyecto (Proyecto proyecto);
    public void borrarProyecto (Long id);
    public Proyecto buscarProyecto (Long id);
    public void editarProyecto (Proyecto proyecto);
    
}
