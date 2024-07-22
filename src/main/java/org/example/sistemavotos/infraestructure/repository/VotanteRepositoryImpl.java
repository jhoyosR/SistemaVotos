package org.example.sistemavotos.infraestructure.repository;

import org.example.sistemavotos.domain.Votante;
import org.example.sistemavotos.interfaces.VotanteRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//Métodos para persistencia en archivos para los objetos votante

public class VotanteRepositoryImpl implements VotanteRepository {
    private static final String FILE_NAME = "votantes.dat";

    @Override
    public List<Votante> findAll() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (ArrayList<Votante>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }
    @Override
    public Votante findById(int id) {
        return findAll().stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }
    @Override
    public void save(Votante votante) {
        List<Votante> votantes = findAll();
        votantes.add(votante);
        saveAll(votantes);
    }

    @Override
    public void update(Votante votante) {
        List<Votante> votantes = findAll();
        votantes = votantes.stream()
                .map(p -> p.getId() == votante.getId() ? votante : p)
                .collect(Collectors.toList());
        saveAll(votantes);
    }

    @Override
    public void delete(int id) {
        List<Votante> votantes = findAll();
        votantes = votantes.stream()
                .filter(p -> p.getId() != id)
                .collect(Collectors.toList());
        saveAll(votantes);
    }

    private void saveAll(List<Votante> votantes) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(votantes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
