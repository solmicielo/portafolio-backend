
package com.solcarretero.portafolio.model;




import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@Entity
public class Formacion {
    
    // Primary Key ----------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    
    //-----------Atributos----------------------
    @NotNull
    @Size(min = 1, max= 75, message = "Debe tener entre 1 y 75 caracteres")
    private String nombreEstudio;
    
    @NotNull
    @Size(min = 1, max= 75, message = "Debe tener entre 1 y 75 caracteres")
    private String nombreAcademia;  
    
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
    private Boolean estasCursando;
    
    //------Foreign key----------------------
    
    @Column(name = "id_persona", nullable=false)    
    private Long persona;
    
    //------Constructores----------------------

    public Formacion() {
    }

    public Formacion(Long id, String nombreEstudio, String nombreAcademia, String descripcion, Date fechaInicio, Date fechaFin, Boolean estasCursando, Long persona) {
        this.id = id;
        this.nombreEstudio = nombreEstudio;
        this.nombreAcademia = nombreAcademia;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estasCursando = estasCursando;
        this.persona = persona;
    }

    
    
}
