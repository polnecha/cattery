

package ru.cat.cattery.repository;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.cat.cattery.entity.Osmotr;

public interface OsmotrRepository extends JpaRepository<Osmotr, Long> {
    // В OsmotrRepository.java
    List<Osmotr> findByDataOsmotraBetween(LocalDate start, LocalDate end);
    List<Osmotr> findByPet_NameContainingIgnoreCaseOrVeterinarniyVrachContainingIgnoreCaseOrPredvaritelnyDiagnozContainingIgnoreCase(
            String name, String vet, String diagnoz
    );
}