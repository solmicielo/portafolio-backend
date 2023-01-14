
package com.solcarretero.portafolio.controller;

import com.solcarretero.portafolio.model.Experiencia;
import com.solcarretero.portafolio.security.controller.Mensaje;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("experiencia/")
@CrossOrigin (origins = "http://localhost:4200/")
public class ExperienciaController {
    
    @Autowired
    IExperienciaService expeServ;
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping ("new")
    public ResponseEntity agregarExperiencia (@RequestBody Experiencia experiencia){
        try {
            expeServ.crearExperiencia(experiencia);
            return new ResponseEntity(experiencia, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity(new Mensaje("Error: No se ha podido crear el elemento Experiencia, revise que los campos sean correctos "), HttpStatus.BAD_REQUEST);
        }
        
    }
    
    @GetMapping ("ver")
    @ResponseBody
    public List<Experiencia> verExperiencias () {
        return expeServ.verExperiencia();
    }
    
    @GetMapping ("buscar/{id}")
    @ResponseBody
    public ResponseEntity buscarExperiencia (@PathVariable Long id) {
        try {
            Experiencia experiencia = expeServ.buscarExperiencia(id);
            if (experiencia != null) {

                return new ResponseEntity(experiencia, HttpStatus.OK);

            } else {
                return new ResponseEntity(new Mensaje("Error: No se ha podido encontrar el elemento Experiencia  en la Base de Datos "), HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            return new ResponseEntity(new Mensaje("Error: No se ha podido encontrar el elemento Experiencia  en la Base de Datos "), HttpStatus.NOT_FOUND);
        }
        
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("delete/{id}")
    public ResponseEntity borrarExperiencia (@PathVariable Long id){
        try {
            expeServ.borrarExperiencia(id);
            return new ResponseEntity(new Mensaje("El elemento Experiencia se Elimino correctamente "), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity(new Mensaje("Error: No se ha podido encontrar el elemento Experiencia  en la Base de Datos "), HttpStatus.NOT_FOUND);
        }
        
    
    }
    
   @PreAuthorize("hasRole('ADMIN')") 
   @PutMapping("editar")
   public ResponseEntity editarExperiencia (@RequestBody Experiencia experiencia){
       try {

            if (expeServ.buscarExperiencia(experiencia.getId()) != null) {

                expeServ.editarExperiencia(experiencia);
                return new ResponseEntity(experiencia, HttpStatus.OK);

            } else {
                return new ResponseEntity(new Mensaje("Error: No se ha podido encontrar el elemento Experiencia  en la Base de Datos "), HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            return new ResponseEntity(new Mensaje("Error: No se ha podido encontrar el elemento Experiencia  en la Base de Datos "), HttpStatus.NOT_FOUND);
        }
      
       
       
   }
    
}
