package dev.ricardo.CadastroDeNinjas.Ninjas;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "Mensagem de boas vindas", description = "Essa rota da uma mensagem de boas vindas para quem acessa")
    public String boasVindas() {
        return "Essa é a mensagem de boas vindas";
    }

    @PostMapping("/criar")
    @Operation(summary = "Criar um Ninja", description = "Essa rota cria um Ninja a partir de parâmetros fornecidos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ninja criado com sucesso!"),
            @ApiResponse(responseCode = "400", description = "Erro ao criar ninja")
    })
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja) {
        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED).body("Ninja criado com sucesso, nome: " + novoNinja.getNome());
    }

    @GetMapping("/listar/{id}")
    @Operation(summary = "Lista um ninja por ID", description = "Busca um ninja por seu ID e exibe o mesmo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja encontrado com sucesso!"),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado")
    })
    public ResponseEntity<?> listarNinjasPorId(@PathVariable Long id) {
        NinjaDTO ninja = ninjaService.listarNinjaPorId(id);
        if (ninja != null) {
            return ResponseEntity.ok(ninja);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja não encontrado");
        }
    }

    @GetMapping("/listar")
    @Operation(summary = "Listar todos os ninjas", description = "Exibe todos os ninjas cadastrados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninjas listados com sucesso!"),
            @ApiResponse(responseCode = "400", description = "Erro ao procurar ninjas")
    })
    public ResponseEntity<List<NinjaDTO>> MostrarTodosOsNinjas() {
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        return ResponseEntity.ok(ninjas);
    }

    @PutMapping("/alterar/{id}")
    @Operation(summary = "Alterar dados do ninja", description = "Altera elementos do ninja com base no seu ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninjas alterado com sucesso!"),
            @ApiResponse(responseCode = "404", description = "Erro ao alterar ninja, ele não foi encontrado")
    })
    public ResponseEntity<?> AlterarNinja(
            @Parameter(description = "Usuario manda o ID no caminho da requisição")
            @PathVariable Long id,
            @Parameter(description = "Usuário manda os dados do ninja a ser atualizado no corpo da requisição")
            @RequestBody NinjaDTO ninjaAtualizado
    ) {
        if (ninjaService.listarNinjaPorId(id) != null) {
           NinjaDTO ninja = ninjaService.atualizarNinja(id, ninjaAtualizado);
           return ResponseEntity.ok(ninja);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja inexistente ou não encontrado");
        }
    }

    @DeleteMapping("/deletar/{id}")
    @Operation(summary = "Deleta um ninja", description = "Deleta um ninja cadastrado por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninjas deletado com sucesso!"),
            @ApiResponse(responseCode = "404", description = "Erro ao procurar ninjas")
    })
    public ResponseEntity<String> DeletarNinjaPorID(@PathVariable Long id) {
        if (ninjaService.listarNinjaPorId(id) != null) {
            ninjaService.deletarNinja(id);
            return ResponseEntity.ok().body("Ninja com id " + id + " deletado com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja com id " + id + " não encontrado");
        }
    }
}
