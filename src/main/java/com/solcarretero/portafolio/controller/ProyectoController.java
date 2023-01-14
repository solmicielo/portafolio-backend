
package com.solcarretero.portafolio.controller;

import com.solcarretero.portafolio.model.Proyecto;
import com.solcarretero.portafolio.security.controller.Mensaje;
import com.solcarretero.portafolio.service.IProyectoService;
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
@RequestMapping("proyecto/")
@CrossOrigin (origins = "http://localhost:4200/")
public class ProyectoController {
    
    @Autowired
    IProyectoService proyectoServ;
    
    @PreAuthorize("hasRole('ADMIN')") 
    @PostMapping ("new")
    public ResponseEntity agregarProyecto (@RequestBody Proyecto proyecto){
        try {
            proyectoServ.crearProyecto(proyecto);
            return new ResponseEntity(proyecto, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity(new Mensaje("Error: No se ha podido crear el elemento Proyecto, revise que los campos sean correctos "), HttpStatus.BAD_REQUEST);
        }
        
    }
    
    @GetMapping ("ver")
    @ResponseBody
    public List<Proyecto> verProyectos () {
        return proyectoServ.verProyectos();
    }
    
    @GetMapping ("buscar/{id}")
    @ResponseBody
    public ResponseEntity buscarProyecto (@PathVariable Long id) {
        try {
            Proyecto proyecto = proyectoServ.buscarProyecto(id);
            if (proyecto != null) {

                return new ResponseEntity(proyecto, HttpStatus.OK);

            } else {
                return new ResponseEntity(new Mensaje("Error: No se ha podido encontrar el elemento Proyecto  en la Base de Datos "), HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            return new ResponseEntity(new Mensaje("Error: No se ha podido encontrar el elemento Proyecto  en la Base de Datos "), HttpStatus.NOT_FOUND);
        }
        
    }
    
    @PreAuthorize("hasRole('ADMIN')") 
    @DeleteMapping("delete/{id}")
    public ResponseEntity borrarProyecto (@PathVariable Long id){
        try {
            proyectoServ.borrarProyecto(id);
            return new ResponseEntity(new Mensaje("El elemento Proyecto se Elimino correctamente "), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity(new Mensaje("Error: No se ha podido encontrar el elemento Proyecto  en la Base de Datos "), HttpStatus.NOT_FOUND);
        }
        
    
    }
    
    @PreAuthorize("hasRole('ADMIN')") 
    @PutMapping("editar")
    public ResponseEntity editarProyecto (@RequestBody Proyecto proyecto){  
        try {

            if (proyectoServ.buscarProyecto(proyecto.getId()) != null) {

                proyectoServ.editarProyecto(proyecto);
                return new ResponseEntity(proyecto, HttpStatus.OK);

            } else {
                return new ResponseEntity(new Mensaje("Error: No se ha podido encontrar el elemento Proyecto  en la Base de Datos "), HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            return new ResponseEntity(new Mensaje("Error: No se ha podido encontrar el elemento Proyecto  en la Base de Datos "), HttpStatus.NOT_FOUND);
        }
      
       
       
    }
    
}
