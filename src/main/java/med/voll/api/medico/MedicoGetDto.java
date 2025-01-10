package med.voll.api.medico;

public record MedicoGetDto(String nome, String email, String crm, Especialidade especialidade) {

    public MedicoGetDto(Medico medico) {
        this(medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}