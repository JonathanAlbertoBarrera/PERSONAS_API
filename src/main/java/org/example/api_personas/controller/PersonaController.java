package org.example.api_personas.controller;

import org.example.api_personas.model.Persona;
import org.example.api_personas.response.ApiResponse;
import org.example.api_personas.service.PersonaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personas")
public class PersonaController {

    private final PersonaService personaService;

    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Persona>>> listarPersonas() {
        List<Persona> personas = personaService.listarPersonas();
        return ResponseEntity.ok(new ApiResponse<>("Listado obtenido exitosamente", personas));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Persona>> guardarPersona(@RequestBody Persona persona) {
        Persona nuevaPersona = personaService.guardarPersona(persona);
        return ResponseEntity.ok(new ApiResponse<>("Persona registrada exitosamente", nuevaPersona));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Persona>> obtenerPersonaPorId(@PathVariable Long id) {
        Persona persona = personaService.obtenerPersonaPorId(id);
        return ResponseEntity.ok(new ApiResponse<>("Persona encontrada", persona));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Persona>> actualizarPersona(@PathVariable Long id, @RequestBody Persona persona) {
        Persona personaActualizada = personaService.actualizarPersona(id, persona);
        return ResponseEntity.ok(new ApiResponse<>("Persona actualizada exitosamente", personaActualizada));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> eliminarPersona(@PathVariable Long id) {
        personaService.eliminarPersona(id);
        return ResponseEntity.ok(new ApiResponse<>("Persona eliminada exitosamente", null));
    }
}
