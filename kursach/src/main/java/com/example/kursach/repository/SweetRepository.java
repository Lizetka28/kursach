package com.example.kursach.repository;

import com.example.kursach.model.Sweet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SweetRepository extends JpaRepository<Sweet,Long> {
    List<Sweet> findByType(String type);
}
