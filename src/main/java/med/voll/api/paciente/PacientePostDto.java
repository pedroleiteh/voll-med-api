package med.voll.api.paciente;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import med.voll.api.endereco.EnderecoDto;

public record PacientePostDto(
    @NotBlank
    String nome, 
    @NotBlank
    @Email
    String email, 
    @NotBlank
    String telefone,
    @NotBlank
    String cpf, 
    @NotNull
    @Valid
    EnderecoDto endereco
) {

}
