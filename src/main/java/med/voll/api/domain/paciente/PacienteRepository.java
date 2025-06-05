package med.voll.api.domain.paciente;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    
    List<Paciente> findAllByAtivoTrue();

    @Query("select p.ativo from Paciente p where p.id = :id")
    boolean findAtivoById(Long id);
}
