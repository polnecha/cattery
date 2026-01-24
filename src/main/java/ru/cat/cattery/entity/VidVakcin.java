package ru.cat.cattery.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "vid_vakcin")
public class VidVakcin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVida;

    @NotBlank
    private String nazvanie;

    // getters & setters
    public Long getIdVida() { return idVida; }
    public void setIdVida(Long idVida) { this.idVida = idVida; }

    public String getNazvanie() { return nazvanie; }
    public void setNazvanie(String nazvanie) { this.nazvanie = nazvanie; }
}