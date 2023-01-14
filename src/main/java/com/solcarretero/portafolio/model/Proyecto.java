
package com.solcarretero.portafolio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Proyecto {
    
    // Primary Key ----------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    //-----------Atributos----------------------
    @NotNull
    @Size(min = 1, max= 75, message = "Debe tener entre 1 y 75 caracteres")
    private String titulo;   
       
   
    @NotNull
    @Size(min = 1,  message = "Debe tener entre 1 y 255 caracteres")
    private String urlImg; 
        
    @NotNull
    @Size(min = 1, max= 200, message = "Debe tener entre 1 y 200 caracteres")
    private String urlLive;
        
    @NotNull
    @Size(min = 1, max= 200, message = "Debe tener entre 1 y 200 caracteres")
    private String urlRepositorio;
        
    //------Foreign key----------------------
    
    @Column(name = "id_persona", nullable=false)    
    private Long persona;
        
    //------Constructores----------------------

    public Proyecto() {
    }

    public Proyecto(Long id, String titulo, String urlImg, String urlLive, String urlRepositorio, Long persona) {
        this.id = id;
        this.titulo = titulo;
        this.urlImg = urlImg;
        this.urlLive = urlLive;
        this.urlRepositorio = urlRepositorio;
        this.persona = persona;
    }

    

    
    
    
}
