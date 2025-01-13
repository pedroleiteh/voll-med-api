package med.voll.api.domain.paciente;


public record PacienteGetDto(String nome, String email, String cpf) {

    public PacienteGetDto(Paciente paciente) {
        this(paciente.getNome(), paciente.getEmail(), paciente.getCpf());
    }

}