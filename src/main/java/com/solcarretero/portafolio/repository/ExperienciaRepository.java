
package com.solcarretero.portafolio.repository;


import com.solcarretero.portafolio.model.Experiencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienciaRepository extends JpaRepository < Experiencia, Long> {
    
}
