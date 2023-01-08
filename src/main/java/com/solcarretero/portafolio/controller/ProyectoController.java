
package com.solcarretero.portafolio.controller;

import com.solcarretero.portafolio.model.Proyecto;
import com.solcarretero.portafolio.service.IProyectoService;
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
@RequestMapping("proyecto/")
@CrossOrigin (origins = "http://localhost:4200/")
public class ProyectoController {
    
    @Autowired
    IProyectoService proyectoServ;
    
    @PreAuthorize("hasRole('ADMIN')") 
    @PostMapping ("new")
    public void agregarProyecto (@RequestBody Proyecto proyecto){
        proyectoServ.crearProyecto(proyecto);
    }
    
    @GetMapping ("ver")
    @ResponseBody
    public List<Proyecto> verProyectos () {
        return proyectoServ.verProyectos();
    }
    
    @GetMapping ("buscar/{id}")
    @ResponseBody
    public Proyecto buscarProyecto (@PathVariable Long id) {
        return proyectoServ.buscarProyecto(id);
    }
    
    @PreAuthorize("hasRole('ADMIN')") 
    @DeleteMapping("delete/{id}")
    public void borrarProyecto (@PathVariable Long id){
        proyectoServ.borrarProyecto(id);
    
    }
    
    @PreAuthorize("hasRole('ADMIN')") 
    @PutMapping("editar")
    public Proyecto editarProyecto (@RequestBody Proyecto proyecto){  
      
       proyectoServ.editarProyecto(proyecto);
       
       return proyecto;
       
    }
    
}
