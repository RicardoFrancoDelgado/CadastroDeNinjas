package dev.ricardo.CadastroDeNinjas;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/boasvindas")
    public String boasVindas() {
        return "Essa é a mensagem de boas vindas";
    }


}
