package org.example.api_personas.model.dao;

import org.example.api_personas.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Long> {

}
