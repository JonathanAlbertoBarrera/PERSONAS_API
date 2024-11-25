package org.example.api_personas.service;

import org.example.api_personas.model.Persona;
import org.example.api_personas.model.dao.PersonaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl implements PersonaService {

    private final PersonaRepository personaRepository;

    public PersonaServiceImpl(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    @Override
    public List<Persona> listarPersonas() {
        return personaRepository.findAll();
    }

    @Override
    public Persona guardarPersona(Persona persona) {
        return personaRepository.save(persona);
    }

    @Override
    public Persona obtenerPersonaPorId(Long id) {
        return personaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Persona no encontrada"));
    }

    @Override
    public Persona actualizarPersona(Long id, Persona persona) {
        Persona personaExistente = obtenerPersonaPorId(id);
        personaExistente.setNombre(persona.getNombre());
        personaExistente.setApellidos(persona.getApellidos());
        personaExistente.setFechaNacimiento(persona.getFechaNacimiento());
        personaExistente.setEstadoNacimiento(persona.getEstadoNacimiento());
        return personaRepository.save(personaExistente);
    }

    @Override
    public void eliminarPersona(Long id) {
        personaRepository.deleteById(id);
    }
}