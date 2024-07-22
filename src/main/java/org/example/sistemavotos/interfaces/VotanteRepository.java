package org.example.sistemavotos.interfaces;

import org.example.sistemavotos.domain.Votante;

import java.util.List;

public interface VotanteRepository {
    List<Votante> findAll();
    Votante findById(int id);
    void save(Votante votante);
    void update(Votante votante);
    void delete(int id);
}
