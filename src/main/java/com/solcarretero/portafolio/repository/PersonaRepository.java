
package com.solcarretero.portafolio.repository;

import com.solcarretero.portafolio.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository <Persona, Long> {
    
}
