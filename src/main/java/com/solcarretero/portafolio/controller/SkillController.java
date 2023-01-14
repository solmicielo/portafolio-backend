
package com.solcarretero.portafolio.controller;

import com.solcarretero.portafolio.model.Skill;
import com.solcarretero.portafolio.security.controller.Mensaje;
import com.solcarretero.portafolio.service.ISkillService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
    
    @PreAuthorize("hasRole('ADMIN')") 
    @PostMapping ("new")
    public ResponseEntity agregarSkill (@RequestBody Skill skill){
        try {
            skillServ.crearSkill(skill);
            return new ResponseEntity(skill, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity(new Mensaje("Error: No se ha podido crear el elemento Skill, revise que los campos sean correctos "), HttpStatus.BAD_REQUEST);
        }
        
    }
    
    @GetMapping ("ver")
    @ResponseBody
    public List<Skill> verSkills () {
        return skillServ.verSkills();
    }
    
    @GetMapping ("buscar/{id}")
    @ResponseBody
    public ResponseEntity buscarSkill (@PathVariable Long id) {
        try {
            Skill skill = skillServ.buscarSkill(id);
            if (skill != null) {

                return new ResponseEntity(skill, HttpStatus.OK);

            } else {
                return new ResponseEntity(new Mensaje("Error: No se ha podido encontrar el elemento Skill  en la Base de Datos "), HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            return new ResponseEntity(new Mensaje("Error: No se ha podido encontrar el elemento Skill  en la Base de Datos "), HttpStatus.NOT_FOUND);
        }
        
    }
    
    @PreAuthorize("hasRole('ADMIN')") 
    @DeleteMapping("delete/{id}")
    public ResponseEntity borrarSkill (@PathVariable Long id){
        try {
            skillServ.borrarSkill(id);
            return new ResponseEntity(new Mensaje("El elemento Skill se Elimino correctamente "), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity(new Mensaje("Error: No se ha podido encontrar el elemento Skill  en la Base de Datos "), HttpStatus.NOT_FOUND);
        }
        
    
    }
    
    @PreAuthorize("hasRole('ADMIN')") 
    @PutMapping("editar")
    public ResponseEntity editarSkill (@RequestBody Skill skill){  
        try {

            if (skillServ.buscarSkill(skill.getId()) != null) {

                skillServ.editarSkill(skill);
                return new ResponseEntity(skill, HttpStatus.OK);

            } else {
                return new ResponseEntity(new Mensaje("Error: No se ha podido encontrar el elemento Skill  en la Base de Datos "), HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            return new ResponseEntity(new Mensaje("Error: No se ha podido encontrar el elemento Skill  en la Base de Datos "), HttpStatus.NOT_FOUND);
        }
      
       
       
    }
    
}
