
package com.solcarretero.portafolio.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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

