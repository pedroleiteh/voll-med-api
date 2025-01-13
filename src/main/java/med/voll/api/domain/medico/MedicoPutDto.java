package med.voll.api.domain.medico;

import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.endereco.EnderecoDto;

public record MedicoPutDto(
    @NotNull
    Long id,
    String nome,
    String telefone,
    EnderecoDto endereco) {
    
}
