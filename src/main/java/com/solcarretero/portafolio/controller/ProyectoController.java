
package com.solcarretero.portafolio.controller;

import com.solcarretero.portafolio.model.Proyecto;
import com.solcarretero.portafolio.service.IProyectoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;


public class ProyectoController {
    
    @Autowired
    IProyectoService proyectoServ;
    
    @PostMapping ("/new/proyecto")
    public void agregarProyecto (@RequestBody Proyecto proyecto){
        proyectoServ.crearProyecto(proyecto);
    }
    
    @GetMapping ("/ver/proyectos")
    @ResponseBody
    public List<Proyecto> verProyectos () {
        return proyectoServ.verProyectos();
    }
    
    @GetMapping ("/buscar/proyecto")
    @ResponseBody
    public Proyecto buscarProyecto (@PathVariable Long id) {
        return proyectoServ.buscarProyecto(id);
    }
    
    @DeleteMapping("/delete/{id}")
    public void borrarProyecto (@PathVariable Long id){
        proyectoServ.borrarProyecto(id);
    
    }
    
    @PutMapping("/editar/{id}")
    public Proyecto editarProyecto (@RequestBody Proyecto proyecto){  
      
       proyectoServ.editarProyecto(proyecto);
       
       return proyecto;
       
    }
    
}
