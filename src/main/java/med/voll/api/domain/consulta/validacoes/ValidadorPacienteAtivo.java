package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidException;
import med.voll.api.domain.consulta.AgendamentoConsultaDto;
import med.voll.api.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorPacienteAtivo implements ValidadorAgendamentoDeConsulta {

    @Autowired
    private PacienteRepository repository;

    public void validar(AgendamentoConsultaDto dto) {
        var pacienteEstaAtivo = repository.findAtivoById(dto.idPaciente());
        if (!pacienteEstaAtivo) {
            throw new ValidException("Consulta não pode ser agendada com paciente excluído");
        }
    }
}
