
package com.solcarretero.portafolio.controller;

import com.solcarretero.portafolio.model.Skill;
import com.solcarretero.portafolio.service.ISkillService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SkillController {
    
    @Autowired
    ISkillService skillServ;
    
    @PostMapping ("/new/skill")
    public void agregarSkill (@RequestBody Skill skill){
        skillServ.crearSkill(skill);
    }
    
    @GetMapping ("/ver/skills")
    @ResponseBody
    public List<Skill> verSkills () {
        return skillServ.verSkills();
    }
    
    @GetMapping ("/skill/buscar/{id}")
    @ResponseBody
    public Skill buscarSkill (@PathVariable Long id) {
        return skillServ.buscarSkill(id);
    }
    
    @DeleteMapping("/skill/delete/{id}")
    public void borrarSkill (@PathVariable Long id){
        skillServ.borrarSkill(id);
    
    }
    
    @PutMapping("/skill/editar")
    public Skill editarSkill (@RequestBody Skill skill){  
      
       skillServ.editarSkill(skill);
       
       return skill;
       
    }
    
}
