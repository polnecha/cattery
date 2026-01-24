// src/main/java/ru/cat/cattery/repository/SpravochnikPorodRepository.java
package ru.cat.cattery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.cat.cattery.entity.SpravochnikPorod;

public interface SpravochnikPorodRepository extends JpaRepository<SpravochnikPorod, Long> {
}