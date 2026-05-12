package dev.ricardo.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    private MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    // Criar missoes
    @PostMapping("/criar")
    public MissoesModel criarMissoes(@RequestBody MissoesModel missoes) {
        return missoesService.criarMissoes(missoes);
    }

    // Listar missoes
    @GetMapping("/listar")
    public List<MissoesModel> listarMissoes() {
        return missoesService.listarMissoes();
    }

    // Listar missoes por id
    @GetMapping("/listar/{id}")
    public MissoesModel listarMissoesPorID(@PathVariable Long id) {
        return missoesService.listarMissoesPorID(id);
    }

    // Atualizar missoes
    @PutMapping("/alterar")
    public String alterarMissoes() {
        return "alterar missoes";
    }

    // Deletar missoes
    @DeleteMapping("/deletar/{id}")
    public String deletarMissoes(@PathVariable Long id) {
        missoesService.deletarMissoes(id);
        return "Missão deletada com sucesso";
    }
}
