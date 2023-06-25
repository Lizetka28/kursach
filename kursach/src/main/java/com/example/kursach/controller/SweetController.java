package com.example.kursach.controller;


import com.example.kursach.model.Sweet;
import com.example.kursach.servise.SweetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SweetController {
    private SweetService sweetService;
    public SweetController(SweetService sweetService){
        this.sweetService=sweetService;
    }

    @GetMapping("/sweet-create")
    public String createSweetForm(Sweet sweet){
        return "sweet-create";
    }
    @PostMapping("/sweet-create")
    public String createSweet(Sweet sweet){
        sweetService.saveSweet(sweet);
        return "redirect:/factories";
    }
    @GetMapping("sweet-delete/{id}")
    public String deleteSweet(@PathVariable("id") Long id){
        sweetService.deleteById(id);
        return "redirect:/factories";
    }
    @GetMapping("sweet-update/{id}")
    public String updateSweetForm(@PathVariable("id") Long id,Model model){
        Sweet sweet=sweetService.findById(id);
        model.addAttribute("sweet",sweet);
        return "/sweet-update";
    }
    @PostMapping("/sweet-update")
    public String updateSweet(Sweet sweet){
        sweetService.saveSweet(sweet);
        return "redirect:/factories";
    }
}
