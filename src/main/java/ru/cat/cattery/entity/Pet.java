package ru.cat.cattery.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "pet")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name; // Кличка

    @NotBlank
    private String gender; // кот / кошка

    private LocalDate birthDate; // Дата рождения

    @ManyToOne
    @JoinColumn(name = "poroda") // имя колонки в БД (оставь как есть, если не меняла)
    private SpravochnikPorod breed;

    @NotBlank
    private String color; // Окрас

    @NotNull
    private Double weight; // Вес (в кг)

    @NotBlank
    private String sterilized; // да / нет

    private String chipNumber; // Чип (опционально)

    private String notes; // Особые отметки: аллергии, болезни и т.д.

    @NotBlank
    private String ownerName; // ФИО владельца

    @NotBlank
    private String ownerPhone; // Телефон владельца

    private LocalDate registrationDate;
    @Column(name = "tip_zhivotnogo")
    private String tipZhivotnogo;// Дата регистрации в клинике

    // --- getters & setters ---

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public LocalDate getBirthDate() { return birthDate; }
    public void setBirthDate(LocalDate birthDate) { this.birthDate = birthDate; }

    public SpravochnikPorod getBreed() { return breed; }
    public void setBreed(SpravochnikPorod breed) { this.breed = breed; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public Double getWeight() { return weight; }
    public void setWeight(Double weight) { this.weight = weight; }

    public String getSterilized() { return sterilized; }
    public void setSterilized(String sterilized) { this.sterilized = sterilized; }

    public String getChipNumber() { return chipNumber; }
    public void setChipNumber(String chipNumber) { this.chipNumber = chipNumber; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }

    public String getOwnerName() { return ownerName; }
    public void setOwnerName(String ownerName) { this.ownerName = ownerName; }

    public String getOwnerPhone() { return ownerPhone; }
    public void setOwnerPhone(String ownerPhone) { this.ownerPhone = ownerPhone; }

    public LocalDate getRegistrationDate() { return registrationDate; }
    public void setRegistrationDate(LocalDate registrationDate) { this.registrationDate = registrationDate; }
    public String getTipZhivotnogo() {
        return tipZhivotnogo;
    }

    public void setTipZhivotnogo(String tipZhivotnogo) {
        this.tipZhivotnogo = tipZhivotnogo;
    }
}