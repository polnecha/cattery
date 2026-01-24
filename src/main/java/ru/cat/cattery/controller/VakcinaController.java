package ru.cat.cattery.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import ru.cat.cattery.entity.Pet;
import ru.cat.cattery.entity.Vakcina;
import ru.cat.cattery.service.PetService;
import ru.cat.cattery.service.VakcinaService;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping("/vakciny")
public class VakcinaController {

    private final VakcinaService service;
    private final PetService petService;

    public VakcinaController(VakcinaService service, PetService petService) {
        this.service = service;
        this.petService = petService;
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
        model.addAttribute("vakciny", service.findAll());
        return "vakciny/list";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("vakcina", new Vakcina());
        model.addAttribute("vsePets", petService.findAll());
        return "vakciny/form";
    }

    @PostMapping
    public String save(@Valid Vakcina vakcina, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("vsePets", petService.findAll());
            return "vakciny/form";
        }
        service.save(vakcina);
        return "redirect:/vakciny";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("vakcina", service.findById(id));
        model.addAttribute("vsePets", petService.findAll());
        return "vakciny/form";
    }

    @PostMapping("/{id}")
    public String update(@PathVariable Long id, @Valid Vakcina vakcina, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("vsePets", petService.findAll());
            return "vakciny/form";
        }
        vakcina.setIdVakcina(id);
        service.save(vakcina);
        return "redirect:/vakciny";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteById(id);
        return "redirect:/vakciny";
    }
}