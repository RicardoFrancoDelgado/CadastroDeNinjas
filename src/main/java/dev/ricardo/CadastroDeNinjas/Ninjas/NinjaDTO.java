package dev.ricardo.CadastroDeNinjas.Ninjas;

import dev.ricardo.CadastroDeNinjas.Missoes.MissoesModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NinjaDTO {
    private Long id;
    private String nome;
    private String email;
    private Integer idade;
    private String imgUrl;
    private String rank;
    private MissoesModel missoes;
}
