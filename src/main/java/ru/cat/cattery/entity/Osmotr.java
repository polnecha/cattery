package ru.cat.cattery.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "osmotr")
public class Osmotr {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOsmotr;

    @ManyToOne
    @JoinColumn(name = "id_kot", nullable = false)
    private Pet pet;

    @NotNull
    private LocalDate dataOsmotra;

    @NotBlank
    private String veterinarniyVrach;

    @NotBlank
    @Column(name = "prichina_vizita") // ← имя в БД
    private String prichinaVizita;

    @NotNull
    private Double ves;

    private Double temperatura;

    @NotBlank
    @Column(name = "opisanie") // ← имя в БД
    private String obsheeSostoyanie;

    private String glaza;
    private String ushi;
    private String zubyDesny;
    private String kozhaSherst;
    private String limfouzly;
    private String zhivot;

    @NotBlank
    @Column(name = "predvaritelny_diagnoz") // ← имя в БД
    private String predvaritelnyDiagnoz;

    private String naznacheniya;

    private LocalDate dataSleduyuschegoVizita;

    private String kommentarii;

    // --- getters & setters ---

    public Long getIdOsmotr() { return idOsmotr; }
    public void setIdOsmotr(Long idOsmotr) { this.idOsmotr = idOsmotr; }

    public Pet getPet() { return pet; }
    public void setPet(Pet pet) { this.pet = pet; }

    public LocalDate getDataOsmotra() { return dataOsmotra; }
    public void setDataOsmotra(LocalDate dataOsmotra) { this.dataOsmotra = dataOsmotra; }

    public String getVeterinarniyVrach() { return veterinarniyVrach; }
    public void setVeterinarniyVrach(String veterinarniyVrach) { this.veterinarniyVrach = veterinarniyVrach; }

    public String getPrichinaVizita() { return prichinaVizita; }
    public void setPrichinaVizita(String prichinaVizita) { this.prichinaVizita = prichinaVizita; }

    public Double getVes() { return ves; }
    public void setVes(Double ves) { this.ves = ves; }

    public Double getTemperatura() { return temperatura; }
    public void setTemperatura(Double temperatura) { this.temperatura = temperatura; }

    public String getObsheeSostoyanie() { return obsheeSostoyanie; }
    public void setObsheeSostoyanie(String obsheeSostoyanie) { this.obsheeSostoyanie = obsheeSostoyanie; }

    public String getGlaza() { return glaza; }
    public void setGlaza(String glaza) { this.glaza = glaza; }

    public String getUshi() { return ushi; }
    public void setUshi(String ushi) { this.ushi = ushi; }

    public String getZubyDesny() { return zubyDesny; }
    public void setZubyDesny(String zubyDesny) { this.zubyDesny = zubyDesny; }

    public String getKozhaSherst() { return kozhaSherst; }
    public void setKozhaSherst(String kozhaSherst) { this.kozhaSherst = kozhaSherst; }

    public String getLimfouzly() { return limfouzly; }
    public void setLimfouzly(String limfouzly) { this.limfouzly = limfouzly; }

    public String getZhivot() { return zhivot; }
    public void setZhivot(String zhivot) { this.zhivot = zhivot; }

    public String getPredvaritelnyDiagnoz() { return predvaritelnyDiagnoz; }
    public void setPredvaritelnyDiagnoz(String predvaritelnyDiagnoz) { this.predvaritelnyDiagnoz = predvaritelnyDiagnoz; }

    public String getNaznacheniya() { return naznacheniya; }
    public void setNaznacheniya(String naznacheniya) { this.naznacheniya = naznacheniya; }

    public LocalDate getDataSleduyuschegoVizita() { return dataSleduyuschegoVizita; }
    public void setDataSleduyuschegoVizita(LocalDate dataSleduyuschegoVizita) { this.dataSleduyuschegoVizita = dataSleduyuschegoVizita; }

    public String getKommentarii() { return kommentarii; }
    public void setKommentarii(String kommentarii) { this.kommentarii = kommentarii; }
}