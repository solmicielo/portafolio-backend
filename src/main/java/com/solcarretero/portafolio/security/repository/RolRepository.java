
package com.solcarretero.portafolio.security.repository;

import com.solcarretero.portafolio.security.enums.RolNombre;
import com.solcarretero.portafolio.security.model.Rol;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
    
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
    
}
