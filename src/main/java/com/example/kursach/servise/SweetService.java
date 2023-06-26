package com.example.kursach.servise;


import com.example.kursach.model.Factory;
import com.example.kursach.model.Sweet;
import com.example.kursach.repository.SweetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SweetService {
    private SweetRepository sweetRepository;
    public SweetService(SweetRepository sweetRepository){
        this.sweetRepository=sweetRepository;
    }
    public Sweet findById(Long id){
        return sweetRepository.findById(id).orElse(null);
    }// поиск конфет по id в бд
    public List<Sweet> findAll(){
        return sweetRepository.findAll();
    }//поиск всех конфет в бд
    public Sweet saveSweet(Sweet sweet, Factory factory){//добавлние конфет в бд
        sweet.setFactory(factory);
        return sweetRepository.save(sweet);
    }
    public void deleteById(Long id){
        sweetRepository.deleteById(id);
    }//удаление конфет с заданным id из бд
    public List<Sweet> listSweet(String name){//поиск конфет с заданным названием в бд
        List<Sweet> sweets=sweetRepository.findByName(name);
        return sweets;
    }

}
