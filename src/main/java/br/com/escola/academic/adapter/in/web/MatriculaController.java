package br.com.escola.academic.adapter.in.web;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.escola.academic.application.dto.MatriculaRequest;
import br.com.escola.academic.application.port.in.MatricularAlunoUseCase;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

    private final MatricularAlunoUseCase matricularAlunoUseCase;

    public MatriculaController(MatricularAlunoUseCase matricularAlunoUseCase) {
        this.matricularAlunoUseCase = matricularAlunoUseCase;
    }

    @PostMapping
    public ResponseEntity<?> executar(@Valid @RequestBody MatriculaRequest request) {

        UUID id = matricularAlunoUseCase.executar(
                request.alunoId(),
                request.turmaId(),
                request.periodoLetivoId()
        );

        return ResponseEntity.ok(id);
    }
    
   
}