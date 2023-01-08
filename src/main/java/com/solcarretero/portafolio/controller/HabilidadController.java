
package com.solcarretero.portafolio.controller;

import com.solcarretero.portafolio.model.Habilidad;
import com.solcarretero.portafolio.service.IHabilidadService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("habilidad/")
@CrossOrigin (origins = "http://localhost:4200/")
public class HabilidadController {
    
     @Autowired
    IHabilidadService habilidadServ;
    
    @PreAuthorize("hasRole('ADMIN')")  
    @PostMapping ("new")
    public void agregarHabilidad (@RequestBody Habilidad habilidad){
        habilidadServ.crearHabilidad(habilidad);
    }
    
    @GetMapping ("ver")
    @ResponseBody
    public List<Habilidad> verHabilidades () {
        return habilidadServ.verHabilidades();
    }
    
    @GetMapping ("buscar/{id}")
    @ResponseBody
    public Habilidad buscarHabilidad (@PathVariable Long id) {
        return habilidadServ.buscarHabilidad(id);
    }
    
    @PreAuthorize("hasRole('ADMIN')") 
    @DeleteMapping("delete/{id}")
    public void borrarHabilidad (@PathVariable Long id){
        habilidadServ.borrarHabilidad(id);
    
    }
    
    @PreAuthorize("hasRole('ADMIN')") 
    @PutMapping("editar")
    public Habilidad editarHabilidad (@RequestBody Habilidad habilidad){  
      
       habilidadServ.editarHabilidad(habilidad);
       
       return habilidad;
       
    }
    
}
