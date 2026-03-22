package com.example.demo.controller;
import com.example.demo.entities.Prof;
import com.example.demo.repositories.ProfRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
@RequestMapping("/profs")
public class ProfController {
    private final ProfRepository repo;
    public ProfController(ProfRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("profs", repo.findAll());
        return "index-prof";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("prof", new Prof());
        return "add-prof";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute Prof p) {
        repo.save(p);
        return "redirect:/profs";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        repo.deleteById(id);
        return "redirect:/profs";
    }
    @GetMapping("/profs/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("prof", repo.findById(id).orElseThrow());
        return "add-prof";
    }
}