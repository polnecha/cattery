package ru.cat.cattery.service;
import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Service;
import ru.cat.cattery.entity.Osmotr;
import ru.cat.cattery.repository.OsmotrRepository;

import java.util.List;

@Service
public class OsmotrService {

    private final OsmotrRepository repository;

    public OsmotrService(OsmotrRepository repository) {
        this.repository = repository;
    }

    public List<Osmotr> findAll() {
        return repository.findAll();
    }

    public Osmotr save(Osmotr osmotr) {
        return repository.save(osmotr);
    }

    public Osmotr findById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
    // В OsmotrService.java
    public List<Osmotr> findByDateBetween(LocalDate start, LocalDate end) {
        return repository.findByDataOsmotraBetween(start, end);
    }
    // В класс OsmotrService
    public List<Osmotr> search(String query) {
        return repository.findByPet_NameContainingIgnoreCaseOrVeterinarniyVrachContainingIgnoreCaseOrPredvaritelnyDiagnozContainingIgnoreCase(
                query, query, query
        );
    }
}