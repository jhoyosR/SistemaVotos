package org.example.sistemavotos.aplication.service;

import org.example.sistemavotos.domain.Candidato;

import java.util.List;

public interface CandidatoService {
    List<Candidato> findAll();
    Candidato findById(int id);
    void save(Candidato candidato);
    void update(Candidato candidato);
    void delete(int id);
}
