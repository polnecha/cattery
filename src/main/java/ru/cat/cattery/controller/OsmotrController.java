package ru.cat.cattery.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import ru.cat.cattery.entity.Osmotr;
import ru.cat.cattery.entity.Pet;
import ru.cat.cattery.service.OsmotrService;
import ru.cat.cattery.service.PetService;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping("/osmotry")
public class OsmotrController {

    private final OsmotrService service;
    private final PetService petService;

    public OsmotrController(OsmotrService service, PetService petService) {
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
        model.addAttribute("osmotry", service.findAll());
        return "osmotry/list";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("osmotr", new Osmotr());
        model.addAttribute("vsePets", petService.findAll());
        return "osmotry/form";
    }

    @PostMapping
    public String save(@Valid Osmotr osmotr, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("vsePets", petService.findAll());
            return "osmotry/form";
        }
        service.save(osmotr);
        return "redirect:/osmotry";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("osmotr", service.findById(id));
        model.addAttribute("vsePets", petService.findAll());
        return "osmotry/form";
    }

    @PostMapping("/{id}")
    public String update(@PathVariable Long id, @Valid Osmotr osmotr, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("vsePets", petService.findAll());
            return "osmotry/form";
        }
        osmotr.setIdOsmotr(id);
        service.save(osmotr);
        return "redirect:/osmotry";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteById(id);
        return "redirect:/osmotry";
    }
}