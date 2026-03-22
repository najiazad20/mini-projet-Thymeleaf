package com.example.demo.repositories;
import com.example.demo.entities.Prof;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ProfRepository extends JpaRepository<Prof, Long> {
}
