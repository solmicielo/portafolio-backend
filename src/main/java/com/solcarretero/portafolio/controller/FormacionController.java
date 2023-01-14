package com.solcarretero.portafolio.controller;

import com.solcarretero.portafolio.model.Formacion;
import com.solcarretero.portafolio.security.controller.Mensaje;
import com.solcarretero.portafolio.service.IFormacionService;
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
@RequestMapping("formacion/")
@CrossOrigin(origins = "http://localhost:4200/")
public class FormacionController {

    @Autowired
    IFormacionService formacionServ;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("new")
    public ResponseEntity agregarFormacion(@RequestBody Formacion formacion) {
        try {
            formacionServ.crearFormacion(formacion);
            return new ResponseEntity(formacion, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity(new Mensaje("Error: No se ha podido crear el elemento Formación, revise que los campos sean correctos "), HttpStatus.BAD_REQUEST);
        }
        
    }

    @GetMapping("ver")
    @ResponseBody
    public List<Formacion> verFormacion() {
        return formacionServ.verFormacion();
    }
    
    
    @GetMapping("buscar/{id}")
    @ResponseBody
    public ResponseEntity buscarFormacion(@PathVariable Long id) {
        try {
            Formacion formacion = formacionServ.buscarFormacion(id);
            if (formacion != null) {                
                
                return new ResponseEntity(formacion, HttpStatus.OK);
                
            } else {
                return new ResponseEntity(new Mensaje("Error: No se ha podido encontrar el elemento Formación  en la Base de Datos "), HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            return new ResponseEntity(new Mensaje("Error: No se ha podido encontrar el elemento Formación  en la Base de Datos "), HttpStatus.NOT_FOUND);
        }

    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("delete/{id}")
    public ResponseEntity borrarFormacion(@PathVariable Long id) {
        try {
            formacionServ.borrarFormacion(id);
            return new ResponseEntity(new Mensaje("El elemento Formación se Elimino correctamente "), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity(new Mensaje("Error: No se ha podido encontrar el elemento Formación  en la Base de Datos "), HttpStatus.NOT_FOUND);
        }
        

    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("editar")
    public ResponseEntity editarFormacion( @RequestBody Formacion formacion) {
        
        try {  
            
            if (formacionServ.buscarFormacion(formacion.getId())!= null) {
                
                formacionServ.editarFormacion(formacion);               
                return new ResponseEntity(new Mensaje("Formacion editada con exito "),  HttpStatus.OK);
                
            } else {
                return new ResponseEntity(new Mensaje("Error: No se ha podido encontrar el elemento Formación  en la Base de Datos "), HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            return new ResponseEntity(new Mensaje("Error: No se ha podido encontrar el elemento Formación  en la Base de Datos "), HttpStatus.NOT_FOUND);
        }      
       
}

}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         