
package com.solcarretero.portafolio.service;

import com.solcarretero.portafolio.model.Formacion;
import com.solcarretero.portafolio.repository.FormacionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FormacionService implements IFormacionService {
    
    @Autowired
    public FormacionRepository formacionRepo;

    @Override
    public List<Formacion> verFormacion() {
        return formacionRepo.findAll();
    }

    @Override
    public void crearFormacion(Formacion formacion) {
        formacionRepo.save(formacion);
    }

    @Override
    public void borrarFormacion(Long id) {
        formacionRepo.deleteById(id);
    }

    @Override
    public Formacion buscarFormacion(Long id) {
        return formacionRepo.findById(id).orElse(null);
    }

    @Override
    public void editarFormacion(Formacion formacion) {
        formacionRepo.save(formacion);
    }
    
}
