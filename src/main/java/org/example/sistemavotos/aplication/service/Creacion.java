package org.example.sistemavotos.aplication.service;

import org.example.sistemavotos.domain.Candidato;
import org.example.sistemavotos.domain.Votante;
import org.example.sistemavotos.infraestructure.repository.CandidatoRepositoryImpl;
import org.example.sistemavotos.infraestructure.repository.VotanteRepositoryImpl;
import org.example.sistemavotos.interfaces.CandidatoRepository;
import org.example.sistemavotos.interfaces.VotanteRepository;

import java.util.List;
import java.util.Scanner;

public class Creacion {
    private static final Scanner scanner = new Scanner(System.in);
    private static final CandidatoService candidatoService;
    private static final VotanteService votanteService;

    static {
        CandidatoRepository candidatoRepository = new CandidatoRepositoryImpl();
        candidatoService = new CandidatoServiceImpl(candidatoRepository);

        VotanteRepository votanteRepository = new VotanteRepositoryImpl();
        votanteService = new VotanteServiceImpl(votanteRepository);
    }

    //Método para registrar candidatos
    private static void registrarCandidato(int id ,String nombre, String jornada){
        List<Candidato> candidatos = candidatoService.findAll();
        Candidato candidato = new Candidato(id, nombre, jornada);

        try {
            candidatoService.save(candidato);
        } catch (IllegalArgumentException ignored){
        }
    }

    //Método para registrar votantes
    private static void registrarVotante(int id, String jornada){
        List<Votante> votantes = votanteService.findAll();
        Votante votante = new Votante(id, jornada);

        try {
            votanteService.save(votante);
        } catch (IllegalArgumentException ignored){
        }
    }

    //Método para buscar candidatos por id en los archivos y asignarle un voto
    public static void sumarVoto(int id){
        Candidato candidato = candidatoService.findById(id);
        if (candidato == null) {
            System.out.println("No existe un candidato con ese id");
        } else {
            candidato.cantidadVotos++;
        }

        try {
            candidatoService.update(candidato);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    //Método para evitar votos duplicados con un boolean una vez se hace un voto
    public static void siVoto(int id){
        Votante votante = votanteService.findById(id);
        if (votante == null){
            System.out.println("No existe un votante con ese id");
        } else {
            votante.setYaVoto(true);
        }

        try {
            votanteService.update(votante);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    private static void borrarVotante(int id){

        Votante votante = votanteService.findById(id);
        if (votante == null) {
            System.out.println("Votante no encontrado con el id: " + id);
            return;
        }

        votanteService.delete(id);
        System.out.println("Votante borrado");
    }

    private static void borrarCandidato(int id){

        Candidato candidato = candidatoService.findById(id);
        if (candidato == null) {
            System.out.println("Candidato no encontrado con el id: " + id);
            return;
        }

        candidatoService.delete(id);
        System.out.println("Candidato borrado");
    }

    //Recorrer los archivos buscando una lista de objetos de votantes e imprimirlos
    private static void mostrarVotantes() {
        List<Votante> votantes = votanteService.findAll();
        if (votantes.isEmpty()) {
            System.out.println("No hay votantes");
        } else {
            System.out.println("Votantes Registrados: ");
            for (Votante votante : votantes) {
                System.out.println(votante);
            }
        }
    }

    //Recorrer los archivos buscando una lista de objetos de candidatos e imprimirlos
    public static void mostrarCandidatos() {
        List<Candidato> candidatos = candidatoService.findAll();
        if (candidatos.isEmpty()) {
            System.out.println("No hay candidatos");
        } else {
            System.out.println("Candidatos Registrados: ");
            for (Candidato candidato : candidatos) {
                System.out.println(candidato);
            }
        }
    }

    //Método para obtener el objeto de un candidato y mostrar los resultados en las alertas en tipo String
    public static String obtenerCandidatos() {
        List<Candidato> candidatos = candidatoService.findAll();
        if (candidatos.isEmpty()) {
            return "No hay candidatos";
        } else {
            StringBuilder sb = new StringBuilder("Candidatos Registrados:\n");
            for (Candidato candidato : candidatos) {
                sb.append(candidato).append("\n");
            }
            return sb.toString();
        }
    }

    //main para controlar votantes y candidatos
    public static void main(String[] args) {
       mostrarVotantes();
        mostrarCandidatos();
    }
}
