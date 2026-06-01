package dev.ricardo.CadastroDeNinjas.Ninjas;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/criar")
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja) {
        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED).body("Ninja criado com sucesso, nome: " + novoNinja.getNome());
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarNinjasPorId(@PathVariable Long id) {
        NinjaDTO ninja = ninjaService.listarNinjaPorId(id);
        if (ninja != null) {
            return ResponseEntity.ok(ninja);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja não encontrado");
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> MostrarTodosOsNinjas() {
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        return ResponseEntity.ok(ninjas);
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> AlterarNinja(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado) {
        if (ninjaService.listarNinjaPorId(id) != null) {
           NinjaDTO ninja = ninjaService.atualizarNinja(id, ninjaAtualizado);
           return ResponseEntity.ok(ninja);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja inexistente ou não encontrado");
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> DeletarNinjaPorID(@PathVariable Long id) {
        if (ninjaService.listarNinjaPorId(id) != null) {
            ninjaService.deletarNinja(id);
            return ResponseEntity.ok().body("Ninja com id " + id + " deletado com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja com id " + id + " não encontrado");
        }
    }
}
