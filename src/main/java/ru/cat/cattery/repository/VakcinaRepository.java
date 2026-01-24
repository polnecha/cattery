package ru.cat.cattery.repository;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.cat.cattery.entity.Vakcina;

public interface VakcinaRepository extends JpaRepository<Vakcina, Long> {
    List<Vakcina> findByNazvanieVakcinyContainingIgnoreCaseOrVeterinarniyVrachContainingIgnoreCase(
            String nazvanie, String vet
    );
}