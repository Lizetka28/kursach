package com.example.kursach.repository;

import com.example.kursach.model.Factory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FactoryRepository extends JpaRepository<Factory,Long> {
    List<Factory> findByName(String name);
}
