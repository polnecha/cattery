package ru.cat.cattery.service;

import org.springframework.stereotype.Service;
import ru.cat.cattery.entity.Pet;
import ru.cat.cattery.repository.PetRepository;

import java.util.List;

@Service
public class PetService {

    private final PetRepository repository;

    public PetService(PetRepository repository) {
        this.repository = repository;
    }

    public List<Pet> findAll() {
        return repository.findAll();
    }

    public Pet save(Pet pet) {
        return repository.save(pet);
    }

    public Pet findById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
    // В класс PetService
    public List<Pet> search(String query) {
        return repository.findByNameContainingIgnoreCaseOrOwnerNameContainingIgnoreCase(query, query);
    }
}