package ru.cat.cattery.service;

import org.springframework.stereotype.Service;
import ru.cat.cattery.entity.SpravochnikPorod;
import ru.cat.cattery.repository.SpravochnikPorodRepository;

import java.util.List;

@Service
public class SpravochnikPorodService {

    private final SpravochnikPorodRepository repository;

    public SpravochnikPorodService(SpravochnikPorodRepository repository) {
        this.repository = repository;
    }

    public List<SpravochnikPorod> findAll() {
        return repository.findAll();
    }

    public SpravochnikPorod save(SpravochnikPorod poroda) {
        return repository.save(poroda);
    }

    public SpravochnikPorod findById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}