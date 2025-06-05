package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidException;
import med.voll.api.domain.consulta.AgendamentoConsultaDto;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidadorHorarioAntecedencia implements ValidadorAgendamentoDeConsulta {
    public void validar(AgendamentoConsultaDto dto) {
        var dataConsulta = dto.data();
        var agora = LocalDateTime.now();
        var diferencaEmMinutos = Duration.between(agora, dataConsulta).toMinutes();

        if(diferencaEmMinutos < 30) {
            throw new ValidException("Consulta deve ser agendada com antecedencia mínima de 30 minutos");
        }

    }
}
