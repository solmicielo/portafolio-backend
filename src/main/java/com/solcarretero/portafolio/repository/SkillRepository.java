
package com.solcarretero.portafolio.repository;

import com.solcarretero.portafolio.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends JpaRepository <Skill, Long> {
    
}
