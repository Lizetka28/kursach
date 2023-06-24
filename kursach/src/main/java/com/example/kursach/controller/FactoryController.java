package com.example.kursach.controller;

import com.example.kursach.model.Factory;
import com.example.kursach.servise.FactoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class FactoryController {
    private FactoryService factoryService;
    public FactoryController(FactoryService factoryService){
        this.factoryService=factoryService;
    }
    @GetMapping("/factories")
    public String findAll(Model model){
        List<Factory> factories=factoryService.findAll();
        model.addAttribute("factories",factories);
        return "factory-list";
    }
    @GetMapping("/factory-create")
    public String createFactoryForm(Factory factory){
        return "factory-create";
    }
    @PostMapping("/factory-create")
    public String createFactory(Factory factory){
        factoryService.saveFactory(factory);
        return "redirect:/factories";
    }
    @GetMapping("factory-delete/{id}")
    public String deleteFactory(@PathVariable("id") Long id){
        factoryService.deleteById(id);
        return "redirect:/factories";
    }
    @GetMapping("factory-update/{id}")
    public String updateFactoryForm(@PathVariable("id") Long id,Model model){
        Factory factory=factoryService.findById(id);
        model.addAttribute("factory",factory);
        return "/factory-update";
    }
    @PostMapping("/factory-update")
    public String updateFactory(Factory factory){
        factoryService.saveFactory(factory);
        return "redirect:/factories";
    }
}
