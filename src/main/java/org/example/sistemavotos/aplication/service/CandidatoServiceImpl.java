package org.example.sistemavotos.aplication.service;

import org.example.sistemavotos.domain.Candidato;
import org.example.sistemavotos.interfaces.CandidatoRepository;

import java.util.List;


//Llamados de los métodos para funcionalidad de la persistencia en archivos
public class CandidatoServiceImpl implements CandidatoService{
    private final CandidatoRepository candidatoRepository;

    public CandidatoServiceImpl(CandidatoRepository candidatoRepository) {
        this.candidatoRepository = candidatoRepository;
    }

    @Override
    public List<Candidato> findAll() {
        return candidatoRepository.findAll();
    }

    @Override
    public Candidato findById(int id) {
        return candidatoRepository.findById(id);
    }

    @Override
    public void save(Candidato candidato) {
        candidatoRepository.save(candidato);
    }

    @Override
    public void update(Candidato candidato) {
        candidatoRepository.update(candidato);
    }

    @Override
    public void delete(int id) {
        candidatoRepository.delete(id);
    }
}
