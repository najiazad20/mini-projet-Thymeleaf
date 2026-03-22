package com.example.demo.repositories;
import com.example.demo.entities.Cours;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface CoursRepository extends JpaRepository<Cours, Long> {
    List<Cours> findByNiveau(String niveau);
    List<Cours> findByJour(String jour);
}