
package com.solcarretero.portafolio.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Habilidad {
    
    // Primary Key ----------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    
    //-----------Atributos----------------------
    @NotNull
    @Size(min = 1, max= 75, message = "Debe tener entre 1 y 75 caracteres")
    private String nombreHabilidad;
    
    @NotNull
    @Min(0)
    @Max(100)
    private int porcentaje;
    
    //------Foreign key----------------------
    
    @Column(name = "id_persona", nullable=false)    
    private Long persona;
    
    //------Constructores----------------------

    public Habilidad() {
    }

    public Habilidad(Long id, String nombreHabilidad, int porcentaje, Long persona) {
        this.id = id;
        this.nombreHabilidad = nombreHabilidad;
        this.porcentaje = porcentaje;
        this.persona = persona;
    }
 
    
    
}

