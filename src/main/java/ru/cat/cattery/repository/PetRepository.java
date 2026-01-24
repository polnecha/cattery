package ru.cat.cattery.repository;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.cat.cattery.entity.Pet;

public interface PetRepository extends JpaRepository<Pet, Long> {
    List<Pet> findByNameContainingIgnoreCaseOrOwnerNameContainingIgnoreCase(String name, String ownerName);
}