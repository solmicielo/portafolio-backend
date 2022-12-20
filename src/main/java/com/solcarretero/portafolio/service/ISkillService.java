
package com.solcarretero.portafolio.service;

import com.solcarretero.portafolio.model.Skill;
import java.util.List;


public interface ISkillService {
    
    public List<Skill> verSkills ();
    public void crearSkill (Skill skill);
    public void borrarSkill (Long id);
    public Skill buscarSkill (Long id);
    public void editarSkill (Skill skill);
    
}
