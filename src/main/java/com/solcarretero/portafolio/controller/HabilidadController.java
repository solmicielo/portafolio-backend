
package com.solcarretero.portafolio.controller;

import com.solcarretero.portafolio.model.Habilidad;
import com.solcarretero.portafolio.service.IHabilidadService;
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
public class HabilidadController {
    
     @Autowired
    IHabilidadService habilidadServ;
    
    @PostMapping ("/new/habilidad")
    public void agregarHabilidad (@RequestBody Habilidad habilidad){
        habilidadServ.crearHabilidad(habilidad);
    }
    
    @GetMapping ("/ver/habilidades")
    @ResponseBody
    public List<Habilidad> verHabilidades () {
        return habilidadServ.verHabilidades();
    }
    
    @GetMapping ("/habilidad/buscar/{id}")
    @ResponseBody
    public Habilidad buscarHabilidad (@PathVariable Long id) {
        return habilidadServ.buscarHabilidad(id);
    }
    
    @DeleteMapping("/habilidad/delete/{id}")
    public void borrarHabilidad (@PathVariable Long id){
        habilidadServ.borrarHabilidad(id);
    
    }
    
    @PutMapping("/habilidad/editar")
    public Habilidad editarHabilidad (@RequestBody Habilidad habilidad){  
      
       habilidadServ.editarHabilidad(habilidad);
       
       return habilidad;
       
    }
    
}
