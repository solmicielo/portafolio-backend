
package com.solcarretero.portafolio.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Proyecto {
    
    // Primary Key ----------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    //-----------Atributos----------------------
    @NotNull
    @Size(min = 1, max= 75, message = "Debe tener entre 1 y 75 caracteres")
    private String titulo;   
       
   
    @NotNull
    @Size(min = 1, max= 200, message = "Debe tener entre 1 y 200 caracteres")
    private String urlImg; 
        
    @NotNull
    @Size(min = 1, max= 200, message = "Debe tener entre 1 y 200 caracteres")
    private String urlLiven;
        
    @NotNull
    @Size(min = 1, max= 200, message = "Debe tener entre 1 y 200 caracteres")
    private String urlRepositorio;
        
    //------Foreign key----------------------
    
    @Column(name = "id_persona", nullable=false)    
    private Long persona;
        
    //------Constructores----------------------

    public Proyecto() {
    }

    public Proyecto(int id, String titulo, String urlImg, String urlLiven, String urlRepositorio, Long persona) {
        this.id = id;
        this.titulo = titulo;
        this.urlImg = urlImg;
        this.urlLiven = urlLiven;
        this.urlRepositorio = urlRepositorio;
        this.persona = persona;
    }

    
    
    
}
