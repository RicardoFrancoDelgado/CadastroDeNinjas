package dev.ricardo.CadastroDeNinjas.Missoes;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    private MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    @PostMapping("/criar")
    public ResponseEntity<MissoesDTO> criarMissoes(@RequestBody MissoesDTO missoes) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(missoesService.criarMissoes(missoes));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<MissoesDTO>> listarMissoes() {
        return ResponseEntity.ok(missoesService.listarMissoes());
    }

    // Listar missoes por id
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarMissoesPorID(@PathVariable Long id) {
        MissoesDTO missoes = missoesService.listarMissoesPorID(id);
        if (missoes != null) {
            return ResponseEntity.ok(missoes);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("missão não encontrada");
        }
    }

    // Atualizar missoes
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarMissoes(@PathVariable Long id, @RequestBody MissoesDTO missoesDTO) {
        MissoesDTO missoes = missoesService.listarMissoesPorID(id);
        if (missoes != null) {
            missoesService.atualizarMissoes(id, missoesDTO);
            return ResponseEntity.ok(missoesDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missão  de id " + id + " não encontrada, não foi possível atualizar");
        }
    }

    // Deletar missoes
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarMissoes(@PathVariable Long id) {
        if (missoesService.listarMissoesPorID(id) != null) {
            missoesService.deletarMissoes(id);
            return ResponseEntity.ok().body("Missão de id: " + id + " deletada com sucesso");
        } else {
            return ResponseEntity.ok().body("Missão  de id " + id + " não encontrada, não foi possível deletar");
        }

    }
}
