package ru.cat.cattery.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import ru.cat.cattery.entity.Pet;
import ru.cat.cattery.service.PetService;
import ru.cat.cattery.service.SpravochnikPorodService; // ← ДОБАВЛЕН ИМПОРТ

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("/pets")
public class PetController {

    private final PetService service;
    private final SpravochnikPorodService porodaService; // ← поле объявлено здесь

    // Один конструктор — с двумя зависимостями
    public PetController(PetService service, SpravochnikPorodService porodaService) {
        this.service = service;
        this.porodaService = porodaService;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(LocalDate.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                if (text != null && !text.trim().isEmpty()) {
                    setValue(LocalDate.parse(text, DateTimeFormatter.ISO_LOCAL_DATE));
                }
            }
        });
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("pets", service.findAll());
        return "pets/list";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("pet", new Pet());
        model.addAttribute("vsePorody", porodaService.findAll()); // ← используем сервис
        return "pets/form";
    }

    @PostMapping
    public String save(@Valid Pet pet, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("vsePorody", porodaService.findAll());
            return "pets/form";
        }
        service.save(pet);
        return "redirect:/pets";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("pet", service.findById(id));
        model.addAttribute("vsePorody", porodaService.findAll());
        return "pets/form";
    }

    @PostMapping("/{id}")
    public String update(@PathVariable Long id, @Valid Pet pet, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("vsePorody", porodaService.findAll());
            return "pets/form";
        }
        pet.setId(id);
        service.save(pet);
        return "redirect:/pets";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteById(id);
        return "redirect:/pets";
    }
}