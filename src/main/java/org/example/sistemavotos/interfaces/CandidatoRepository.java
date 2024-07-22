package org.example.sistemavotos.interfaces;

import org.example.sistemavotos.domain.Candidato;
import org.example.sistemavotos.domain.Votante;

import java.util.List;

public interface CandidatoRepository {
    List<Candidato> findAll();
    Candidato findById(int id);
    void save(Candidato candidato);
    void update(Candidato candidato);
    void delete(int id);
}
