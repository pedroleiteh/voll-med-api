package med.voll.api.domain.paciente;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    
    List<Paciente> findAllByAtivoTrue();
}
