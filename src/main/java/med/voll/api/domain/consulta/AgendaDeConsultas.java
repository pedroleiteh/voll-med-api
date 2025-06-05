package med.voll.api.domain.consulta;

import med.voll.api.domain.ValidException;
import med.voll.api.domain.consulta.validacoes.ValidadorAgendamentoDeConsulta;
import med.voll.api.domain.medico.Medico;
import med.voll.api.domain.medico.MedicoRepository;
import med.voll.api.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendaDeConsultas {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private List<ValidadorAgendamentoDeConsulta> validadores;

    public AgendamentoConsultaDetailsDto agendar(AgendamentoConsultaDto consultaDto) {
        if (!pacienteRepository.existsById(consultaDto.idPaciente())) {
            throw new ValidException("Id do paciente informado não existe");
        }

        if (consultaDto.idMedico() != null && !medicoRepository.existsById(consultaDto.idMedico())) {
            throw new ValidException("Id do medico informado não existe");
        }

        validadores.forEach(v -> v.validar(consultaDto));

        var paciente = pacienteRepository.getReferenceById(consultaDto.idPaciente());
        var medico = escolherMedico(consultaDto);

        if(medico == null) {
            throw new ValidException("Não existe médico disponível nessa data!");
        }

        var consulta = new Consulta(null, medico, paciente, consultaDto.data());
        consultaRepository.save(consulta);

        return new AgendamentoConsultaDetailsDto(consulta);
    }

    private Medico escolherMedico(AgendamentoConsultaDto consultaDto) {
        if (consultaDto.idMedico() != null) {
            return medicoRepository.getReferenceById(consultaDto.idMedico());
        }

        if (consultaDto.especialidade() == null ) {
            throw new ValidException("Especialidade é obrigatória quando médico não for escolhido!");
        }

        return medicoRepository.escolherMedicoAleatorioLivreNaData(consultaDto.especialidade(), consultaDto.data());
    }
}
