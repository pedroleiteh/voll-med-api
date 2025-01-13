package med.voll.api.paciente;

import jakarta.validation.constraints.NotNull;
import med.voll.api.endereco.EnderecoDto;

public record PacientePutDto(
    @NotNull
    Long id,
    String nome,
    String telefone,
    EnderecoDto endereco) {

}
