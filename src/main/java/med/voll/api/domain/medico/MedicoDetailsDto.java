package med.voll.api.domain.medico;

import med.voll.api.domain.endereco.Endereco;

public record MedicoDetailsDto(Long id, String nome, String email, String crm, String telefone, Especialidade especialidade, Endereco endereco) {

    public MedicoDetailsDto(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getTelefone(), medico.getEspecialidade(), medico.getEndereco());
    }
    
}
