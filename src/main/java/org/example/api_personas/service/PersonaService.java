package org.example.api_personas.service;

import org.example.api_personas.model.Persona;
import java.util.List;

public interface PersonaService {
    List<Persona> listarPersonas();
    Persona guardarPersona(Persona persona);
    Persona obtenerPersonaPorId(Long id);
    Persona actualizarPersona(Long id, Persona persona);
    void eliminarPersona(Long id);
}
