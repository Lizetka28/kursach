package com.example.kursach.servise;


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
    }
    public List<Sweet> findAll(){
        return sweetRepository.findAll();
    }
    public Sweet saveSweet(Sweet sweet){
        return sweetRepository.save(sweet);
    }
    public void deleteById(Long id){
        sweetRepository.deleteById(id);
    }
    public List<Sweet> listSweet(String name){
        List<Sweet> sweets=sweetRepository.findByName(name);
        return sweets;
    }

}
