package org.example.sistemavotos.aplication.service;

import org.example.sistemavotos.domain.Votante;
import org.example.sistemavotos.interfaces.VotanteRepository;

import java.util.List;


//Llamados de los métodos para funcionalidad de la persistencia en archivos
public class VotanteServiceImpl implements VotanteService{
    private final VotanteRepository votanteRepository;

    public VotanteServiceImpl(VotanteRepository votanteRepository){
        this.votanteRepository = votanteRepository;
    }


    @Override
    public List<Votante> findAll() {
        return votanteRepository.findAll();
    }

    @Override
    public Votante findById(int id) {
        return votanteRepository.findById(id);
    }

    @Override
    public void save(Votante votante) {
        votanteRepository.save(votante);
    }

    @Override
    public void update(Votante votante) {
        votanteRepository.update(votante);
    }

    @Override
    public void delete(int id) {
        votanteRepository.delete(id);
    }
}
