
package com.solcarretero.portafolio.service;

import com.solcarretero.portafolio.model.Skill;
import com.solcarretero.portafolio.repository.SkillRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SkillService implements ISkillService {
    
    @Autowired
    public SkillRepository skillRepo;

    @Override
    public List<Skill> verSkills() {
        return skillRepo.findAll();
    }

    @Override
    public void crearSkill(Skill skill) {
        skillRepo.save(skill);
    }

    @Override
    public void borrarSkill(Long id) {
        skillRepo.deleteById(id);
    }

    @Override
    public Skill buscarSkill(Long id) {
        return skillRepo.findById(id).orElse(null);
    }

    @Override
    public void editarSkill(Skill skill) {
        skillRepo.save(skill);
    }
    
}

