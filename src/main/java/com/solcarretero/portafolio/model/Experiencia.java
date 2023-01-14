
package com.solcarretero.portafolio.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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

    public Experiencia( String nombrePuesto, String nombreEmpresa, String descripcion, Date fechaInicio, Date fechaFin, Boolean esTrabajoActual, Long persona) {
        
        this.nombrePuesto = nombrePuesto;
        this.nombreEmpresa = nombreEmpresa;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.esTrabajoActual = esTrabajoActual;
        this.persona = persona;
    }

    
    
}
