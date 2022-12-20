
package com.solcarretero.portafolio.controller;

import com.solcarretero.portafolio.model.Persona;
import com.solcarretero.portafolio.service.IPersonaService;
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


public class PersonaController {
    
    @Autowired
    IPersonaService persoServ;
    
    @PostMapping ("/new/persona")
    public void agregarPersona (@RequestBody Persona pers){
        persoServ.crearPersona(pers);
    }
    
    @GetMapping ("/ver/personas")
    @ResponseBody
    public List<Persona> verPersonas () {
        return persoServ.verPersona();
    }
    
    @GetMapping ("/buscar/persona")
    @ResponseBody
    public Persona buscarProyecto (@PathVariable Long id) {
        return persoServ.buscarPersona(id);
    }
    
    @DeleteMapping("/delete/{id}")
    public void borrarPersona (@PathVariable Long id){
        persoServ.borrarPersona(id);
    
    }
    
   @PutMapping("/editar/{id}")
   public Persona editarPersona (@RequestBody Persona pers){  
      
       persoServ.editarPersona(pers);
       
       return pers;
       
   }   
    
}
