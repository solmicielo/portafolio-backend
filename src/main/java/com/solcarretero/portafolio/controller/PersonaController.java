
package com.solcarretero.portafolio.controller;

import com.solcarretero.portafolio.model.Persona;
import com.solcarretero.portafolio.security.controller.Mensaje;
import com.solcarretero.portafolio.service.IPersonaService;
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
@RequestMapping("persona/")
@CrossOrigin (origins = "http://localhost:4200/")
public class PersonaController {
    
    @Autowired
    IPersonaService persoServ;
    
    @PreAuthorize("hasRole('ADMIN')") 
    @PostMapping ("new")
    public ResponseEntity agregarPersona (@RequestBody Persona pers){
        try {
            persoServ.crearPersona(pers);
            return new ResponseEntity(pers, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity(new Mensaje("Error: No se ha podido crear el elemento Persona, revise que los campos sean correctos "), HttpStatus.BAD_REQUEST);
        }
        
    }
    
    @GetMapping ("ver")
    @ResponseBody
    public List<Persona> verPersonas () {
        return persoServ.verPersonas();
    }
    
    @GetMapping ("buscar/{id}")
    @ResponseBody
    public ResponseEntity buscarProyecto (@PathVariable Long id) {
        try {
            Persona pers = persoServ.buscarPersona(id);
            if (pers != null) {

                return new ResponseEntity(pers, HttpStatus.OK);

            } else {
                return new ResponseEntity(new Mensaje("Error: No se ha podido encontrar el elemento Persona  en la Base de Datos "), HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            return new ResponseEntity(new Mensaje("Error: No se ha podido encontrar el elemento Persona  en la Base de Datos "), HttpStatus.NOT_FOUND);
        }
        
    }
    
    @PreAuthorize("hasRole('ADMIN')") 
    @DeleteMapping("delete/{id}")
    public ResponseEntity borrarPersona (@PathVariable Long id){
        try {
            persoServ.borrarPersona(id);
            return new ResponseEntity(new Mensaje("El elemento Persona se Elimino correctamente "), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity(new Mensaje("Error: No se ha podido encontrar el elemento Persona  en la Base de Datos "), HttpStatus.NOT_FOUND);
        }
        
    
    }
   @PreAuthorize("hasRole('ADMIN')")  
   @PutMapping("editar")
   public ResponseEntity editarPersona (@RequestBody Persona pers){   
       try {

            if (persoServ.buscarPersona(pers.getId()) != null) {

                persoServ.editarPersona(pers);
                return new ResponseEntity(pers, HttpStatus.OK);

            } else {
                return new ResponseEntity(new Mensaje("Error: No se ha podido encontrar el elemento Persona  en la Base de Datos "), HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            return new ResponseEntity(new Mensaje("Error: No se ha podido encontrar el elemento Persona  en la Base de Datos "), HttpStatus.NOT_FOUND);
        }
              
       
       
   }   
    
}
