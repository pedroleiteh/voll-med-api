package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidException;
import med.voll.api.domain.consulta.AgendamentoConsultaDto;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
public class ValidadorHorarioFuncionamentoClinica implements ValidadorAgendamentoDeConsulta {

    public void validar(AgendamentoConsultaDto dto) {
        var dataConsulta = dto.data();
        var domingo = dataConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var antesDaAberturaDaClinica =  dataConsulta.getHour() < 7;
        var depoisDoEncerramentoDaClinica = dataConsulta.getHour() > 18;
        if (domingo || antesDaAberturaDaClinica || depoisDoEncerramentoDaClinica) {
            throw new ValidException("Consulta fora do horário de funcionamento da clínica");
        }
    }
}
