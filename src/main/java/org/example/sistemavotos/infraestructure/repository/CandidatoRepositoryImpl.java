package org.example.sistemavotos.infraestructure.repository;

import org.example.sistemavotos.domain.Candidato;
import org.example.sistemavotos.domain.Votante;
import org.example.sistemavotos.interfaces.CandidatoRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

    //Métodos para persistencia en archivos para los objetos candidato

public class CandidatoRepositoryImpl implements CandidatoRepository {
    private static final String FILE_NAME = "candidatos.dat";

    @Override
    public List<Candidato> findAll() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (ArrayList<Candidato>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }
    @Override
    public Candidato findById(int id) {
        return findAll().stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }
    @Override
    public void save(Candidato candidato) {
        List<Candidato> candidatos = findAll();
        candidatos.add(candidato);
        saveAll(candidatos);
    }

    @Override
    public void update(Candidato candidato) {
        List<Candidato> candidatos = findAll();
        candidatos = candidatos.stream()
                .map(p -> p.getId() == candidato.getId() ? candidato : p)
                .collect(Collectors.toList());
        saveAll(candidatos);
    }

    @Override
    public void delete(int id) {
        List<Candidato> candidatos = findAll();
        candidatos = candidatos.stream()
                .filter(p -> p.getId() != id)
                .collect(Collectors.toList());
        saveAll(candidatos);
    }

    private void saveAll(List<Candidato> candidatos) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(candidatos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
