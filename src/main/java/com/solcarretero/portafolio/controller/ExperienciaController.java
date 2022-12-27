
package com.solcarretero.portafolio.controller;

import com.solcarretero.portafolio.model.Experiencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import com.solcarretero.portafolio.service.IExperienciaService;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("experiencia/")
@CrossOrigin (origins = "http://localhost:4200/")
public class ExperienciaController {
    
    @Autowired
    IExperienciaService expeServ;
    
    @PostMapping ("new")
    public void agregarExperiencia (@RequestBody Experiencia experiencia){
        expeServ.crearExperiencia(experiencia);
    }
    
    @GetMapping ("ver")
    @ResponseBody
    public List<Experiencia> verExperiencias () {
        return expeServ.verExperiencia();
    }
    
    @GetMapping ("buscar/{id}")
    @ResponseBody
    public Experiencia buscarExperiencia (@PathVariable Long id) {
        return expeServ.buscarExperiencia(id);
    }
    
    @DeleteMapping("delete/{id}")
    public void borrarExperiencia (@PathVariable Long id){
        expeServ.borrarExperiencia(id);
    
    }
    
   @PutMapping("editar")
   public Experiencia editarExperiencia (@RequestBody Experiencia experiencia){  
      
       expeServ.editarExperiencia(experiencia);
       
       return experiencia;
       
   }
    
}
