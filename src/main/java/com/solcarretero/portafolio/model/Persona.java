package com.solcarretero.portafolio.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Persona {
    
    // Primary Key ----------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    //-----------Atributos----------------------
    @NotNull
    @Size(min = 1, max= 100, message = "Debe tener entre 1 y 100 caracteres")
    private String nombreCompleto;
    
    @NotNull
    @Size(min = 1, max= 75, message = "Debe tener entre 1 y 75 caracteres")
    private String profesion;  
    
    @Lob
    @NotNull
    @Size(min = 1, max= 2500, message = "Debe tener entre 1 y 2500 caracteres")
    private String sobreMi;
    
    @NotNull
    @Size(min = 1, max= 200, message = "Debe tener entre 1 y 200 caracteres")
    private String urlFoto; 
        
    @NotNull
    @Size(min = 1, max= 200, message = "Debe tener entre 1 y 200 caracteres")
    private String urlLinkedin;
        
    @NotNull
    @Size(min = 1, max= 200, message = "Debe tener entre 1 y 200 caracteres")
    private String urlGithub;
        
    @NotNull
    @Size(min = 1, max= 200, message = "Debe tener entre 1 y 200 caracteres")
    private String urlCurriculum;
        
    @NotNull
    @Size(min = 1, max= 100, message = "Debe tener entre 1 y 100 caracteres")
    private String correo;
    
    @NotNull
    @Size(min = 1, max= 20, message = "Debe tener entre 1 y 20 caracteres")
    private String telefono;
    
    //-----------Relaciones ----------------------
    
    @OneToMany(fetch= FetchType.LAZY, mappedBy="persona")
    @JsonProperty(access = Access.WRITE_ONLY)
    private List <Experiencia> experiencias = new ArrayList<>();    
    
    @OneToMany(fetch= FetchType.LAZY, mappedBy="persona")
    @JsonProperty(access = Access.WRITE_ONLY)
    private List<Formacion> educacion;
    
    @OneToMany(fetch= FetchType.LAZY, mappedBy="persona")
    @JsonProperty(access = Access.WRITE_ONLY)
    private List<Skill> skills;
    
    @OneToMany(fetch= FetchType.LAZY, mappedBy="persona") 
    @JsonProperty(access = Access.WRITE_ONLY)
    private List<Habilidad> habilidades;
    
    @OneToMany(fetch= FetchType.LAZY, mappedBy="persona")
    @JsonProperty(access = Access.WRITE_ONLY)    
    private List<Proyecto> proyectos;
    
    //------Constructores----------------------

    public Persona() {
    }

    public Persona(int id, String nombreCompleto, String profesion, String sobreMi, String urlFoto, String urlLinkedin, String urlGithub, String urlCurriculum, String correo, String telefono) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.profesion = profesion;
        this.sobreMi = sobreMi;
        this.urlFoto = urlFoto;
        this.urlLinkedin = urlLinkedin;
        this.urlGithub = urlGithub;
        this.urlCurriculum = urlCurriculum;
        this.correo = correo;
        this.telefono = telefono;
        
    }
    
    
    
    
}

