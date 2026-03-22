package com.example.demo.repositories;
import com.example.demo.entities.Instrument;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface InstrumentRepository extends JpaRepository<Instrument, Long> {
        List<Instrument> findByFamilleAndDisponibilite(String famille, boolean disponibilite);
    }
