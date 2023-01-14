package com.solcarretero.portafolio.controller;

import com.solcarretero.portafolio.model.Formacion;
import com.solcarretero.portafolio.model.Habilidad;
import com.solcarretero.portafolio.security.controller.Mensaje;
import com.solcarretero.portafolio.service.IHabilidadService;
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
@RequestMapping("habilidad/")
@CrossOrigin(origins = "http://localhost:4200/")
public class HabilidadController {

    @Autowired
    IHabilidadService habilidadServ;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("new")
    public ResponseEntity agregarHabilidad(@RequestBody Habilidad habilidad) {
        try {
            habilidadServ.crearHabilidad(habilidad);
            return new ResponseEntity(habilidad, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity(new Mensaje("Error: No se ha podido crear el elemento Habilidad, revise que los campos sean correctos "), HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("ver")
    @ResponseBody
    public List<Habilidad> verHabilidades() {
        return habilidadServ.verHabilidades();
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("buscar/{id}")
    @ResponseBody
    public ResponseEntity buscarHabilidad(@PathVariable Long id) {
        try {
            Habilidad habilidad = habilidadServ.buscarHabilidad(id);
            if (habilidad != null) {

                return new ResponseEntity(habilidad, HttpStatus.OK);

            } else {
                return new ResponseEntity(new Mensaje("Error: No se ha podido encontrar el elemento Habilidad  en la Base de Datos "), HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            return new ResponseEntity(new Mensaje("Error: No se ha podido encontrar el elemento Habilidad  en la Base de Datos "), HttpStatus.NOT_FOUND);
        }

    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("delete/{id}")
    public ResponseEntity borrarHabilidad(@PathVariable Long id) {
        try {
            habilidadServ.borrarHabilidad(id);
            return new ResponseEntity(new Mensaje("El elemento Habilidad se Elimino correctamente "), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity(new Mensaje("Error: No se ha podido encontrar el elemento Habilidad  en la Base de Datos "), HttpStatus.NOT_FOUND);
        }

    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("editar")
    public ResponseEntity editarHabilidad(@RequestBody Habilidad habilidad) {
        try {

            if (habilidadServ.buscarHabilidad(habilidad.getId()) != null) {

                habilidadServ.editarHabilidad(habilidad);
                return new ResponseEntity(habilidad, HttpStatus.OK);

            } else {
                return new ResponseEntity(new Mensaje("Error: No se ha podido encontrar el elemento Habilidad  en la Base de Datos "), HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            return new ResponseEntity(new Mensaje("Error: No se ha podido encontrar el elemento Habilidad  en la Base de Datos "), HttpStatus.NOT_FOUND);
        }

    }

}
