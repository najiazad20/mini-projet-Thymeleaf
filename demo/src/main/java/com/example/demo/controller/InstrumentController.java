package com.example.demo.controller;
import com.example.demo.entities.Instrument;
import com.example.demo.repositories.InstrumentRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@Controller
@RequestMapping("/instruments")
public class InstrumentController {
    private final InstrumentRepository repo;
    public InstrumentController(InstrumentRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("instruments", repo.findAll());
        return "index-instrument";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("instrument", new Instrument());
        return "add-instrument";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Instrument i) {
        repo.save(i);
        return "redirect:/instruments";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        repo.deleteById(id);
        return "redirect:/instruments";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("instrument", repo.findById(id).orElseThrow());
        return "add-instrument";
    }
    @GetMapping("/filter")
    public String filter(@RequestParam String famille,
                         @RequestParam boolean disponibilite,
                         Model model) {
        model.addAttribute("instruments", repo.findByFamilleAndDisponibilite(famille, disponibilite));
        return "index-instrument";
    }
}