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

    @PostMapping("/criar")
    public MissoesDTO criarMissoes(@RequestBody MissoesDTO missoes) {
        return missoesService.criarMissoes(missoes);
    }

    @GetMapping("/listar")
    public List<MissoesDTO> listarMissoes() {
        return missoesService.listarMissoes();
    }

    // Listar missoes por id
    @GetMapping("/listar/{id}")
    public MissoesDTO listarMissoesPorID(@PathVariable Long id) {
        return missoesService.listarMissoesPorID(id);
    }

    // Atualizar missoes
    @PutMapping("/alterar/{id}")
    public MissoesDTO alterarMissoes(@PathVariable Long id, @RequestBody MissoesDTO missoesDTO)  {
        return missoesService.atualizarMissoes(id, missoesDTO);
    }

    // Deletar missoes
    @DeleteMapping("/deletar/{id}")
    public String deletarMissoes(@PathVariable Long id) {
        missoesService.deletarMissoes(id);
        return "Missão deletada com sucesso";
    }
}
