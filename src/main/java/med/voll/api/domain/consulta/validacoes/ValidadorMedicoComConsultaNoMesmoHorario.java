package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidException;
import med.voll.api.domain.consulta.AgendamentoConsultaDto;
import med.voll.api.domain.consulta.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMedicoComConsultaNoMesmoHorario implements ValidadorAgendamentoDeConsulta {

    @Autowired
    private ConsultaRepository repository;

    public void validar(AgendamentoConsultaDto dto) {
        var medicoPossuiOutraConsultaNoMesmoHorario = repository.existsByMedicoIdAndData(dto.idMedico(), dto.data());

        if (medicoPossuiOutraConsultaNoMesmoHorario) {
            throw new ValidException("Médico já possui outra consulta agendada nesse mesmo horário");
        }
    }
}
