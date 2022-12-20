
package com.solcarretero.portafolio.service;

import com.solcarretero.portafolio.model.Formacion;
import java.util.List;


public interface IFormacionService {
    
    public List<Formacion> verFormacion ();
    public void crearFormacion (Formacion formacion);
    public void borrarFormacion (Long id);
    public Formacion buscarFormacion (Long id);
    public void editarFormacion (Formacion formacion);
    
}
