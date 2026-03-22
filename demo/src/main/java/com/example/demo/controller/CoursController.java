package com.example.demo.controller;
import com.example.demo.entities.Cours;
import com.example.demo.repositories.CoursRepository;
import com.example.demo.repositories.ProfRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
@RequestMapping("/cours")
public class CoursController {
    private final CoursRepository coursRepo;
    private final ProfRepository profRepo;
    public CoursController(CoursRepository c, ProfRepository p) {
        this.coursRepo = c;
        this.profRepo = p;
    }
    @GetMapping
    public String list(Model model) {
        model.addAttribute("cours", coursRepo.findAll());
        return "index-cours";
    }
    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("cours", new Cours());
        model.addAttribute("profs", profRepo.findAll());
        return "add-cours";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute Cours c) {
        coursRepo.save(c);
        return "redirect:/cours";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        coursRepo.deleteById(id);
        return "redirect:/cours";
    }
    @GetMapping("/filter")
    public String filter(@RequestParam String niveau, Model model) {
        model.addAttribute("cours", coursRepo.findByNiveau(niveau));
        return "index-cours";
    }

    @GetMapping("/stats")
    public String stats(Model model) {
        model.addAttribute("totalCours", coursRepo.count());
        return "stats";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("cours", coursRepo.findById(id).orElseThrow());
        model.addAttribute("profs", profRepo.findAll());
        return "add-cours";
    }
}
