package dev.ricardo.CadastroDeNinjas.Ninjas;

import dev.ricardo.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

// Transforma uma classe em uma entidade do Banco de Dados
// JPA => Java Persistence API
@Entity
@Table(name = "tb_cadastro")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String nome;

    @Column(unique = true)
    private String email;

    @Column(name = "idade")
    private int idade;

    @Column(name = "img_url")
    private String imgUrl;

    // @ManyToOne - Um ninja tem uma única missão
    @ManyToOne
    @JoinColumn(name = "missoes_id") // foreign key ou chave estrangeira.
    private MissoesModel missoes;

}
