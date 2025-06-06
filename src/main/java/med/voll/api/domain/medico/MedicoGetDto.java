package med.voll.api.domain.medico;

public record MedicoGetDto(Long id, String nome, String email, String crm, Especialidade especialidade) {

    public MedicoGetDto(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}