package ru.cat.cattery.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "vakcina")
public class Vakcina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVakcina;

    @ManyToOne
    @JoinColumn(name = "id_kot", nullable = false)
    private Pet pet;

    @NotBlank
    @Column(name = "nazvanie_vakciny")
    private String nazvanieVakciny;

    @NotNull
    @Column(name = "data_postanovki")
    private LocalDate dataPostanovki;

    @NotNull
    @Column(name = "data_sleduyuschey_vakcinacii")
    private LocalDate dataSleduyuscheyVakcinacii;

    @Column(name = "vremya_deystviya")
    private String vremyaDeystviya;

    @Column(name = "seriya_partiya")
    private String seriyaPartiya;

    @NotBlank
    @Column(name = "tip_vakciny")
    private String tipVakciny;

    @NotBlank
    @Column(name = "reakciya")
    private String reakciya;

    @NotBlank
    @Column(name = "veterinarniy_vrach")
    private String veterinarniyVrach;

    // --- getters & setters ---

    public Long getIdVakcina() { return idVakcina; }
    public void setIdVakcina(Long idVakcina) { this.idVakcina = idVakcina; }

    public Pet getPet() { return pet; }
    public void setPet(Pet pet) { this.pet = pet; }

    public String getNazvanieVakciny() { return nazvanieVakciny; }
    public void setNazvanieVakciny(String nazvanieVakciny) { this.nazvanieVakciny = nazvanieVakciny; }

    public LocalDate getDataPostanovki() { return dataPostanovki; }
    public void setDataPostanovki(LocalDate dataPostanovki) { this.dataPostanovki = dataPostanovki; }

    public LocalDate getDataSleduyuscheyVakcinacii() { return dataSleduyuscheyVakcinacii; }
    public void setDataSleduyuscheyVakcinacii(LocalDate dataSleduyuscheyVakcinacii) { this.dataSleduyuscheyVakcinacii = dataSleduyuscheyVakcinacii; }

    public String getVremyaDeystviya() { return vremyaDeystviya; }
    public void setVremyaDeystviya(String vremyaDeystviya) { this.vremyaDeystviya = vremyaDeystviya; }

    public String getSeriyaPartiya() { return seriyaPartiya; }
    public void setSeriyaPartiya(String seriyaPartiya) { this.seriyaPartiya = seriyaPartiya; }

    public String getTipVakciny() { return tipVakciny; }
    public void setTipVakciny(String tipVakciny) { this.tipVakciny = tipVakciny; }

    public String getReakciya() { return reakciya; }
    public void setReakciya(String reakciya) { this.reakciya = reakciya; }

    public String getVeterinarniyVrach() { return veterinarniyVrach; }
    public void setVeterinarniyVrach(String veterinarniyVrach) { this.veterinarniyVrach = veterinarniyVrach; }
}