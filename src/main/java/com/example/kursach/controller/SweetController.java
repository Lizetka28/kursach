package com.example.kursach.controller;


import com.example.kursach.model.Factory;
import com.example.kursach.model.Sweet;
import com.example.kursach.servise.FactoryService;
import com.example.kursach.servise.SweetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SweetController {
    private SweetService sweetService;
    private FactoryService factoryService;
    public SweetController(FactoryService factoryService,SweetService sweetService){
        this.sweetService=sweetService;
        this.factoryService=factoryService;
    }

    @GetMapping("/sweet-create")//возвращает страницу создания конфет
    public String createSweetForm(Sweet sweet){
        return "sweet-create";
    }
    @PostMapping("/sweet-create")//принимает из формы данные о конфете и создает ее в бд, возвращает на главную страницу
    public String createSweet(@RequestParam( name="factory", required =true) Long id,Sweet sweet){
        Factory factory=factoryService.findById(id);
        sweetService.saveSweet(sweet, factory);
        return "redirect:/factories";
    }
    @GetMapping("sweet-delete/{id}")//принимает id конфеты, удаляет её из бд и возвращает главную страницу
    public String deleteSweet(@PathVariable("id") Long id){
        sweetService.deleteById(id);
        return "redirect:/factories";
    }
    @GetMapping("sweet-update/{id}")//принимает id конфеты, возвращает страницу изменения конфеты, где выведены ее характеристики
    public String updateSweetForm(@PathVariable("id") Long id,Model model){
        Sweet sweet=sweetService.findById(id);
        model.addAttribute("sweet",sweet);
        return "/sweet-update";
    }
    @PostMapping("/sweet-update")//принимает из формы данные о конфете, изменяет ее в бд и возвращает главную страницу
    public String updateSweet(@RequestParam( name="factory", required =false) Long id, Sweet sweet){
        Factory factory=factoryService.findById(id);
        sweetService.saveSweet(sweet, factory);
        return "redirect:/factories";
    }
}
