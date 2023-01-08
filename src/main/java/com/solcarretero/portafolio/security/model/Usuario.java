
package com.solcarretero.portafolio.security.model;



import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;



@Setter
@Getter
@Entity
public class Usuario  {
    
    // Primary Key ----------------------------------
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotNull
    @Column(unique = true)
    private String nombreUsuario;
    @NotNull
    private String email;
    @NotNull
    private String password;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_rol",
     joinColumns = @JoinColumn(name = "usuario"),
     inverseJoinColumns = @JoinColumn(name = "rol"))
    private Set<Rol> roles = new HashSet<>();

    public Usuario() {
    }

    public Usuario( String nombreUsuario, String email, String password) {
        
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.password = password;
    }
    
    

   
    
    
    

    

    

    
    
    
    
}
