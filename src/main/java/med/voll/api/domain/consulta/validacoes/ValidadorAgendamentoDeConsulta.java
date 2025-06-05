package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.consulta.AgendamentoConsultaDto;

public interface ValidadorAgendamentoDeConsulta {

    void validar(AgendamentoConsultaDto dto);
}
