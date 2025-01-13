package med.voll.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import jakarta.validation.Valid;
import med.voll.api.paciente.Paciente;
import med.voll.api.paciente.PacienteDetailsDto;
import med.voll.api.paciente.PacienteGetDto;
import med.voll.api.paciente.PacientePostDto;
import med.voll.api.paciente.PacienteRepository;

@RestController
@RequestMapping("pacientes")
public class PacienteController {
    
    @Autowired
    private PacienteRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<PacienteDetailsDto> cadastrar(@RequestBody @Valid PacientePostDto dados, UriComponentsBuilder uriBuilder) {
        var paciente = new Paciente(dados);
        repository.save(paciente);

        var uri = uriBuilder.path("/pacientes/{id}").buildAndExpand(paciente.getId()).toUri();

        return ResponseEntity.created(uri).body(new PacienteDetailsDto(paciente));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteDetailsDto> detalhar(@PathVariable Long id) {
        var paciente = repository.getReferenceById(id);
        return ResponseEntity.ok(new PacienteDetailsDto(paciente));
    }

    @GetMapping
    public ResponseEntity<List<PacienteGetDto>> listar() {
        return ResponseEntity.ok(repository.findAll().stream().map(p -> new PacienteGetDto(p)).toList());
    }
}
