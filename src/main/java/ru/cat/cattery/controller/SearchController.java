package ru.cat.cattery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.cat.cattery.service.PetService;
import ru.cat.cattery.service.OsmotrService;
import ru.cat.cattery.service.VakcinaService;

@Controller
public class SearchController {

    private final PetService petService;
    private final OsmotrService osmotrService;
    private final VakcinaService vakcinaService;

    public SearchController(PetService petService, OsmotrService osmotrService, VakcinaService vakcinaService) {
        this.petService = petService;
        this.osmotrService = osmotrService;
        this.vakcinaService = vakcinaService;
    }

    @GetMapping("/search")
    public String search(@RequestParam String q, Model model) {
        model.addAttribute("query", q);
        model.addAttribute("pets", petService.search(q));
        model.addAttribute("osmotry", osmotrService.search(q));
        model.addAttribute("vakciny", vakcinaService.search(q));
        return "search";
    }
}