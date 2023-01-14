package com.solcarretero.portafolio.model;



import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@Entity
public class Persona {
    
    // Primary Key ----------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    //-----------Atributos----------------------
    @NotNull
    @Size(min = 1, max= 100, message = "Debe tener entre 1 y 100 caracteres")
    private String nombre_completo;
    
    @NotNull
    @Size(min = 1, max= 75, message = "Debe tener entre 1 y 75 caracteres")
    private String profesion;  
    
    @Lob
    @NotNull
    @Size(min = 1, max= 2500, message = "Debe tener entre 1 y 2500 caracteres")
    private String sobre_mi;
    
    @NotNull
    @Size(min = 1, message = "Debe tener entre 1 y 255 caracteres")
    private String url_foto; 
        
    @NotNull
    @Size(min = 1, max= 200, message = "Debe tener entre 1 y 200 caracteres")
    private String url_linkedin;
        
    @NotNull
    @Size(min = 1, max= 200, message = "Debe tener entre 1 y 200 caracteres")
    private String url_github;
        
    @NotNull
    @Size(min = 1, max= 200, message = "Debe tener entre 1 y 200 caracteres")
    private String url_curriculum;
        
    @NotNull
    @Size(min = 1, max= 100, message = "Debe tener entre 1 y 100 caracteres")
    private String correo;
    
    @NotNull
    @Size(min = 1, max= 20, message = "Debe tener entre 1 y 20 caracteres")
    private String telefono;
    
    //-----------Relaciones ----------------------
    
    @OneToMany( mappedBy="persona")    
    private List <Experiencia> experiencias = new ArrayList<>();    
    
    @OneToMany( mappedBy="persona")    
    private List<Formacion> educacion= new ArrayList<>();
    
    @OneToMany( mappedBy="persona")    
    private List<Skill> skills= new ArrayList<>();
    
    @OneToMany( mappedBy="persona")     
    private List<Habilidad> habilidades = new ArrayList<>();
    
    @OneToMany( mappedBy="persona")        
    private List<Proyecto> proyectos = new ArrayList<>();
    
    //------Constructores----------------------

    public Persona() {
    }

    public Persona(Long id, String nombre_completo, String profesion, String sobre_mi, String url_foto, String url_linkedin, String url_github, String url_curriculum, String correo, String telefono) {
        this.id = id;
        this.nombre_completo = nombre_completo;
        this.profesion = profesion;
        this.sobre_mi = sobre_mi;
        this.url_foto = url_foto;
        this.url_linkedin = url_linkedin;
        this.url_github = url_github;
        this.url_curriculum = url_curriculum;
        this.correo = correo;
        this.telefono = telefono;
    }

    

    

   
    
    
    
    
}

