
package com.solcarretero.portafolio.repository;

import com.solcarretero.portafolio.model.Formacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormacionRepository extends JpaRepository <Formacion, Long> {
    
}
