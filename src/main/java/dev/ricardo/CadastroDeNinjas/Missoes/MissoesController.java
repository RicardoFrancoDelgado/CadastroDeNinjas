package dev.ricardo.CadastroDeNinjas.Missoes;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
@Tag(name = "Missões", description = "Endpoints para o gerenciamento de missões dos ninjas")
public class MissoesController {

    private MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    @PostMapping("/criar")
    @Operation(summary = "Criar uma nova missão", description = "Cadastra uma nova missão no sistema.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Missão criada com sucesso")
    })
    public ResponseEntity<MissoesDTO> criarMissoes(@RequestBody MissoesDTO missoes) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(missoesService.criarMissoes(missoes));
    }

    @GetMapping("/listar")
    @Operation(summary = "Listar todas as missões", description = "Retorna uma lista com todas as missões cadastradas.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de missões retornada com sucesso")
    })
    public ResponseEntity<List<MissoesDTO>> listarMissoes() {
        return ResponseEntity.ok(missoesService.listarMissoes());
    }

    // Listar missoes por id
    @GetMapping("/listar/{id}")
    @Operation(summary = "Buscar missão por ID", description = "Busca os detalhes de uma missão específica usando o ID informado.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Missão encontrada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Missão não encontrada")
    })
    public ResponseEntity<?> listarMissoesPorID(
            @Parameter(description = "ID da missão a ser buscada", example = "1")
            @PathVariable Long id
    ) {
        MissoesDTO missoes = missoesService.listarMissoesPorID(id);
        if (missoes != null) {
            return ResponseEntity.ok(missoes);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("missão não encontrada");
        }
    }

    @PutMapping("/alterar/{id}")
    @Operation(summary = "Alterar uma missão existente", description = "Atualiza os dados de uma missão baseada no ID fornecido.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Missão atualizada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Missão não encontrada para atualização")
    })
    public ResponseEntity<?> alterarMissoes(
            @Parameter(description = "ID da missão a ser alterada", example = "1")
            @PathVariable Long id,
            @RequestBody MissoesDTO missoesDTO
    ) {
        MissoesDTO missoes = missoesService.listarMissoesPorID(id);
        if (missoes != null) {
            missoesService.atualizarMissoes(id, missoesDTO);
            return ResponseEntity.ok(missoesDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missão  de id " + id + " não encontrada, não foi possível atualizar");
        }
    }

    @DeleteMapping("/deletar/{id}")
    @Operation(summary = "Deletar uma missão", description = "Remove uma missão do sistema pelo ID ou retorna aviso caso não exista.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada (pode indicar sucesso ou que a missão não foi encontrada)")
    })
    public ResponseEntity<String> deletarMissoes(
            @Parameter(description = "ID da missão a ser deletada", example = "1")
            @PathVariable Long id
    ) {
        if (missoesService.listarMissoesPorID(id) != null) {
            missoesService.deletarMissoes(id);
            return ResponseEntity.ok()
                    .body("Missão de id: " + id + " deletada com sucesso");
        } else {
            return ResponseEntity.ok()
                    .body("Missão  de id " + id + " não encontrada, não foi possível deletar");
        }
    }
}
