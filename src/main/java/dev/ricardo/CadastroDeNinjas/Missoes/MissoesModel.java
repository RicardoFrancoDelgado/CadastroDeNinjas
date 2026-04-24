package dev.ricardo.CadastroDeNinjas.Missoes;

import dev.ricardo.CadastroDeNinjas.Ninjas.NinjaModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String dificuldade;

    private List<NinjaModel> ninja;

    public MissoesModel() {
    }

    public MissoesModel(Long id, String titulo, String rank) {
        this.id = id;
        this.nome = titulo;
        this.dificuldade = rank;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String titulo) {
        this.nome = titulo;
    }

    public String getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(String rank) {
        this.dificuldade = rank;
    }
}
