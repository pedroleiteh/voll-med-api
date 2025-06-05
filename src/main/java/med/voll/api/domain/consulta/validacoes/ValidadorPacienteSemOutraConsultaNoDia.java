package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.consulta.AgendamentoConsultaDto;
import med.voll.api.domain.consulta.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorPacienteSemOutraConsultaNoDia implements ValidadorAgendamentoDeConsulta {

    @Autowired
    private ConsultaRepository repository;

    public void validar(AgendamentoConsultaDto dto) {
        var primeiraHorario = dto.data().withHour(7);
        var ultimoHorario = dto.data().withHour(18);
        var pacientePossuiOutraConsultaNoDia = repository.existsByPacienteIdAndDataBetween(dto.idPaciente(), primeiraHorario, ultimoHorario);
    }
}
