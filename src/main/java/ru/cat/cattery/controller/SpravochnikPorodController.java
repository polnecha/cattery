package ru.cat.cattery.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.cat.cattery.entity.SpravochnikPorod;
import ru.cat.cattery.service.SpravochnikPorodService;

@Controller
@RequestMapping("/porody") // URL будет /porody
public class SpravochnikPorodController {

    private final SpravochnikPorodService service;

    public SpravochnikPorodController(SpravochnikPorodService service) {
        this.service = service;
    }

    // Список всех пород
    @GetMapping
    public String list(Model model) {
        model.addAttribute("porody", service.findAll()); // имя атрибута для Thymeleaf
        return "porody/list"; // шаблон: src/main/resources/porody/list.html
    }

    // Форма для создания новой породы
    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("poroda", new SpravochnikPorod());
        return "porody/form"; // шаблон: src/main/resources/porody/form.html
    }

    // Сохранение новой породы
    @PostMapping
    public String save(@Valid SpravochnikPorod poroda, BindingResult result) {
        if (result.hasErrors()) {
            return "porody/form";
        }
        service.save(poroda);
        return "redirect:/porody"; // после сохранения редирект на список
    }

    // Форма редактирования существующей породы
    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("poroda", service.findById(id));
        return "porody/form";
    }

    // Обновление существующей породы
    @PostMapping("/{id}")
    public String update(@PathVariable Long id, @Valid SpravochnikPorod poroda, BindingResult result) {
        if (result.hasErrors()) {
            return "porody/form";
        }
        poroda.setIdPorodi(id);
        service.save(poroda);
        return "redirect:/porody";
    }

    // Удаление породы
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteById(id);
        return "redirect:/porody";
    }
}
