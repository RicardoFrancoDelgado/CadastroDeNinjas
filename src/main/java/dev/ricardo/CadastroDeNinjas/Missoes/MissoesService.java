package dev.ricardo.CadastroDeNinjas.Missoes;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MissoesService {
    private MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    // listar missoes
    public List<MissoesModel> listarMissoes() {
        return missoesRepository.findAll();
    }

    // listar missoes por id
    public MissoesModel listarMissoesPorID(Long id) {
        return missoesRepository.findById(id).orElse(null);
    }
}
