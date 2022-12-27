
package com.solcarretero.portafolio.controller;

import com.solcarretero.portafolio.model.Skill;
import com.solcarretero.portafolio.service.ISkillService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("skill/")
@CrossOrigin (origins = "http://localhost:4200/")
public class SkillController {
    
    @Autowired
    ISkillService skillServ;
    
    @PostMapping ("new")
    public void agregarSkill (@RequestBody Skill skill){
        skillServ.crearSkill(skill);
    }
    
    @GetMapping ("ver")
    @ResponseBody
    public List<Skill> verSkills () {
        return skillServ.verSkills();
    }
    
    @GetMapping ("buscar/{id}")
    @ResponseBody
    public Skill buscarSkill (@PathVariable Long id) {
        return skillServ.buscarSkill(id);
    }
    
    @DeleteMapping("delete/{id}")
    public void borrarSkill (@PathVariable Long id){
        skillServ.borrarSkill(id);
    
    }
    
    @PutMapping("editar")
    public Skill editarSkill (@RequestBody Skill skill){  
      
       skillServ.editarSkill(skill);
       
       return skill;
       
    }
    
}
