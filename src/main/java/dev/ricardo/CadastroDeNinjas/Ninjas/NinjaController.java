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
    public String criarNinja() {
        return "Ninja criado";
    }

    // Mostrar ninja por id - READ
    @GetMapping("/listar/{id}")
    public NinjaModel listarNinjasPorId(@PathVariable Long id) {
        return ninjaService.listarNinjaPorId(id);
    }

    // Mostrar todos o ninjas - READ
    @GetMapping("/listar")
    public List<NinjaModel> MostrarTodosOsNinjas() {
        return ninjaService.listarNinjas();
    }
    // Alterar dados dos ninjas - UPDATE
    @PutMapping("/alterar")
    public String AlterarNinja() {
        return "Alterar ninja";
    }

    // Deletar ninja - DELETE
    @DeleteMapping("/deletar/:id")
    public String DeletarNinjaPorID() {
        return "Deletar";
    }
}
