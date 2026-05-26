package dev.ricardo.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninja")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasvindas")
    public String boasVindas() {
        return "Essa é a mensagem de boas vindas";
    }

    // Adicionar ninja - CREATE
    @PostMapping("/criar")
    public NinjaDTO criarNinja(@RequestBody NinjaDTO ninja) {
        return ninjaService.criarNinja(ninja);
    }

    // Mostrar ninja por id - READ
    @GetMapping("/listar/{id}")
    public NinjaDTO listarNinjasPorId(@PathVariable Long id) {
        return ninjaService.listarNinjaPorId(id);
    }

    // Mostrar todos o ninjas - READ
    @GetMapping("/listar")
    public List<NinjaDTO> MostrarTodosOsNinjas() {
        return ninjaService.listarNinjas();
    }

    // Alterar dados dos ninjas - UPDATE
    @PutMapping("/alterar/{id}")
    public NinjaDTO AlterarNinja(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado) {
        return ninjaService.atualizarNinja(id, ninjaAtualizado);
    }

    // Deletar ninja - DELETE
    @DeleteMapping("/deletar/{id}")
    public String DeletarNinjaPorID(@PathVariable Long id) {
        ninjaService.deletarNinja(id);
        return "Ninja deletado com sucesso";
    }
}
