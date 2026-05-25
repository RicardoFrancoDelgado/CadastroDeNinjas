package dev.ricardo.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Component;

@Component
public class NinjaMapper {
    public NinjaModel map(NinjaDTO dto) {
        NinjaModel ninja = new NinjaModel();
        ninja.setId(dto.getId());
        ninja.setNome(dto.getNome());
        ninja.setEmail(dto.getEmail());
        ninja.setIdade(dto.getIdade());
        ninja.setRank(dto.getRank());
        ninja.setImgUrl(dto.getImgUrl());
        ninja.setMissoes(dto.getMissoes());

        return ninja;
    }

    public NinjaDTO map(NinjaModel model) {
        NinjaDTO dto = new NinjaDTO();
        dto.setId(model.getId());
        dto.setNome(model.getNome());
        dto.setEmail(model.getEmail());
        dto.setIdade(model.getIdade());
        dto.setRank(model.getRank());
        dto.setImgUrl(model.getImgUrl());
        dto.setMissoes(model.getMissoes());

        return dto;
    }
}
