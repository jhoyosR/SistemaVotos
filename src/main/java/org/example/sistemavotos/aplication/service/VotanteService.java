package org.example.sistemavotos.aplication.service;

import org.example.sistemavotos.domain.Votante;

import java.util.List;

public interface VotanteService {
    List<Votante> findAll();
    Votante findById(int id);
    void save(Votante votante);
    void update(Votante votante);
    void delete(int id);
}
