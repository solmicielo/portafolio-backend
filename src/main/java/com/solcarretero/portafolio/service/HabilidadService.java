
package com.solcarretero.portafolio.service;

import com.solcarretero.portafolio.model.Habilidad;
import com.solcarretero.portafolio.repository.HabilidadRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HabilidadService implements IHabilidadService {
    
    @Autowired
    public HabilidadRepository habilidadRepo;

    @Override
    public List<Habilidad> verHabilidades() {
        return habilidadRepo.findAll();
    }

    @Override
    public void crearHabilidad(Habilidad habilidad) {
        habilidadRepo.save(habilidad);
    }

    @Override
    public void borrarHabilidad(Long id) {
        habilidadRepo.deleteById(id);
    }

    @Override
    public Habilidad buscarHabilidad(Long id) {
        return habilidadRepo.findById(id).orElse(null);
    }

    @Override
    public void editarHabilidad(Habilidad habilidad) {
        habilidadRepo.save(habilidad);
    }
    
}
