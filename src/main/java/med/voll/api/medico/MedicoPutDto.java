package med.voll.api.medico;

import jakarta.validation.constraints.NotNull;
import med.voll.api.endereco.EnderecoDto;

public record MedicoPutDto(
    @NotNull
    Long id,
    String nome,
    String telefone,
    EnderecoDto endereco) {
    
}
