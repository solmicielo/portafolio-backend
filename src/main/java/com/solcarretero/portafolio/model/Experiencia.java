
package com.solcarretero.portafolio.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Experiencia {
    
    // Primary Key ----------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    //-----------Atributos----------------------
    @NotNull
    @Size(min = 1, max= 75, message = "Debe tener entre 1 y 75 caracteres")
    private String nombrePuesto;
    
    @NotNull
    @Size(min = 1, max= 75, message = "Debe tener entre 1 y 75 caracteres")
    private String nombreEmpresa;  
    
    @Lob
    @NotNull
    @Size(min = 1, max= 2500, message = "Debe tener entre 1 y 2500 caracteres")
    private String descripcion;    
    
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date fechaInicio; 
    
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date fechaFin;    
    
    @NotNull    
    private Boolean esTrabajoActual;
    
    //------Foreign key----------------------
    
        
    @Column(name = "id_persona", nullable=false)    
    private Long persona;
    
    //------Constructores----------------------

    public Experiencia() {
    }

    public Experiencia(Long id, String nombrePuesto, String nombreEmpresa, String descripcion, Date fechaInicio, Date fechaFin, Boolean esTrabajoActual, Long persona) {
        this.id = id;
        this.nombrePuesto = nombrePuesto;
        this.nombreEmpresa = nombreEmpresa;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.esTrabajoActual = esTrabajoActual;
        this.persona = persona;
    }

    
    
}
