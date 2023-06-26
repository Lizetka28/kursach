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
    }//поиск фабрики по id в бд
    public List<Factory> findAll(){
       return factoryRepository.findAll();
    }//поиск всех фабрик в бд
    public Factory saveFactory(Factory factory){
        return factoryRepository.save(factory);
    }//добавление фабрики в бд
    public void deleteById(Long id){
        factoryRepository.deleteById(id);
    }//удалении фабрики с заданным id из бд
    public List<Factory> listFactory(String name){//поиск фабрик с заданным именем в бд
        List<Factory> factories=factoryRepository.findByName(name);
        return factories;
    }

}
