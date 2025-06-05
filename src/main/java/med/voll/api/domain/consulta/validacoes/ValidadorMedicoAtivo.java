package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidException;
import med.voll.api.domain.consulta.AgendamentoConsultaDto;
import med.voll.api.domain.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMedicoAtivo implements ValidadorAgendamentoDeConsulta {

    @Autowired
    private MedicoRepository repository;

    public void validar(AgendamentoConsultaDto dto) {
        //escolha do medico opcional
        if (dto.idMedico() == null) {
            return;
        }

        var medicoEstaAtivo = repository.findAtivoById(dto.idMedico());
        if(!medicoEstaAtivo) {
            throw new ValidException("Consulta não pode ser agendada com médico excluído");
        }
    }
}
