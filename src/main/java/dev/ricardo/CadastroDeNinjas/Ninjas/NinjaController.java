package dev.ricardo.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
public class NinjaController {

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
    @GetMapping("/mostrar/:id")
    public String MostrarTodosOsNinjasID() {
        return "Mostrar todos por id";
    }

    // Mostrar todos o ninjas - READ
    @GetMapping("/mostrar")
    public String MostrarTodosOsNinjas() {
        return "Mostrar todos";
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
