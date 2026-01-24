package ru.cat.cattery.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "spravochnik_porod")
public class SpravochnikPorod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPorodi;

    @NotBlank
    private String nazvanie; // Название породы

    // --- getters & setters ---

    public Long getIdPorodi() { return idPorodi; }
    public void setIdPorodi(Long idPorodi) { this.idPorodi = idPorodi; }

    public String getNazvanie() { return nazvanie; }
    public void setNazvanie(String nazvanie) { this.nazvanie = nazvanie; }
}