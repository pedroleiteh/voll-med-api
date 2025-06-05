package med.voll.api.infra.exception;

import java.util.List;

import med.voll.api.domain.ValidException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class TratadorDeErros {
    
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Void> tratarErro404() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<dadosErroValidacao>> tratarErro400(MethodArgumentNotValidException ex) {
        var erros = ex.getFieldErrors();
        return ResponseEntity.badRequest().body(erros.stream().map(dadosErroValidacao::new).toList());
    }

    @ExceptionHandler(ValidException.class)
    public ResponseEntity tratarErroRegraDeNegocio(ValidException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    private record dadosErroValidacao(String campo, String msg) {
        public dadosErroValidacao(FieldError err){
            this(err.getField(), err.getDefaultMessage());
        }
    }
}
