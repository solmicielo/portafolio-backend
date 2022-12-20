
package com.solcarretero.portafolio.service;

import com.solcarretero.portafolio.model.Habilidad;
import java.util.List;


public interface IHabilidadService {
    
    public List<Habilidad> verHabilidades ();
    public void crearHabilidad (Habilidad habilidad);
    public void borrarHabilidad (Long id);
    public Habilidad buscarHabilidad (Long id);
    public void editarHabilidad (Habilidad habilidad);
    
}
