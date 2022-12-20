
package com.solcarretero.portafolio.controller;

import com.solcarretero.portafolio.model.Formacion;
import com.solcarretero.portafolio.service.IFormacionService;
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
public class FormacionController {
    
    @Autowired
    IFormacionService formacionServ;
    
    @PostMapping ("/new/formacion")
    public void agregarFormacion (@RequestBody Formacion formacion){
        formacionServ.crearFormacion(formacion);
    }
    
    @GetMapping ("/ver/formacion")
    @ResponseBody
    public List<Formacion> verFormacion () {
        return formacionServ.verFormacion();
    }
    
    @GetMapping ("formacion/buscar/{id}")
    @ResponseBody
    public Formacion buscarFormacion (@PathVariable Long id) {
        return formacionServ.buscarFormacion(id);
    }
    
    @DeleteMapping("/formacion/delete/{id}")
    public void borrarFormacion (@PathVariable Long id){
        formacionServ.borrarFormacion(id);
    
    }
    
   @PutMapping("/formacion/editar")
   public Formacion editarFormacion (@RequestBody Formacion formacion){  
      
       formacionServ.editarFormacion(formacion);
       
       return formacion;
       
    }
    
}
