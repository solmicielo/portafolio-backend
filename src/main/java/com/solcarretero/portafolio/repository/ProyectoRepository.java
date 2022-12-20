
package com.solcarretero.portafolio.repository;

import com.solcarretero.portafolio.model.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyectoRepository extends JpaRepository < Proyecto, Long> {
    
}
