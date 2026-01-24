package ru.cat.cattery.service;

import org.springframework.stereotype.Service;
import ru.cat.cattery.entity.Vakcina;
import ru.cat.cattery.repository.VakcinaRepository;

import java.util.List;

@Service
public class VakcinaService {

    private final VakcinaRepository repository;

    public VakcinaService(VakcinaRepository repository) {
        this.repository = repository;
    }

    public List<Vakcina> findAll() {
        return repository.findAll();
    }

    public Vakcina save(Vakcina vakcina) {
        return repository.save(vakcina);
    }

    public Vakcina findById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
    // В класс VakcinaService
    public List<Vakcina> search(String query) {
        return repository.findByNazvanieVakcinyContainingIgnoreCaseOrVeterinarniyVrachContainingIgnoreCase(
                query, query
        );
    }
}