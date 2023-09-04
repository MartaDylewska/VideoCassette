package com.example.videocasette.service;

//Logiki biznesowej nie powinno się nigdy wiązać z API - dlatego powstają klasy serwisowe

import com.example.videocasette.dao.entity.VideoCassette;
import com.example.videocasette.dao.repository.VideoCassetteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;

@Service
public class VideoCassetteService {

    private VideoCassetteRepository videoCassetteRepository;

    @Autowired
    public VideoCassetteService (VideoCassetteRepository videoCassetteRepository) {
        this.videoCassetteRepository = videoCassetteRepository;
    }

    public Optional<VideoCassette> findById(Long id) {
        return videoCassetteRepository.findById(id);
    }

    public Iterable<VideoCassette> findAll() {
        return videoCassetteRepository.findAll();
    }

    public VideoCassette save(VideoCassette videoCassette) {
        return videoCassetteRepository.save(videoCassette);
    }

    public void delete(Long id) {
        videoCassetteRepository.deleteById(id);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDB () {
        save(new VideoCassette(1L, "Masakra", LocalDate.of(1983, Month.APRIL, 1)));
        save(new VideoCassette(2L, "Kolizja", LocalDate.of(1999, Month.AUGUST, 31)));
    }
}
