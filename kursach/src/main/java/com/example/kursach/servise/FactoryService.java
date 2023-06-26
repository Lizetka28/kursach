package com.example.kursach.servise;

import com.example.kursach.model.Factory;
import com.example.kursach.repository.FactoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FactoryService {
    private FactoryRepository factoryRepository;
    public FactoryService(FactoryRepository factoryRepository){
        this.factoryRepository=factoryRepository;
    }
    public Factory findById(Long id){
        return factoryRepository.findById(id).orElse(null);
    }
    public List<Factory> findAll(){
       return factoryRepository.findAll();
    }
    public Factory saveFactory(Factory factory){
        return factoryRepository.save(factory);
    }
    public void deleteById(Long id){
        factoryRepository.deleteById(id);
    }
    public List<Factory> listFactory(String name){
        List<Factory> factories=factoryRepository.findByName(name);
        return factories;
    }

}
