package com.example.videocasette.api;

import com.example.videocasette.dao.entity.VideoCassette;
import com.example.videocasette.service.VideoCassetteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/cassettes")
public class VideoCassetteApi {
    static final Logger logger = Logger.getLogger("VideoCassetteAPI");
    private VideoCassetteService videoCassettes;

    @Autowired
    public VideoCassetteApi(VideoCassetteService videoCassettes) {
        this.videoCassettes = videoCassettes;
    }

    @GetMapping("/all")
    public Iterable<VideoCassette> getAll() {
        return videoCassettes.findAll();
    }

    @GetMapping
    public Optional<VideoCassette> getById(@RequestParam Long index) {
       return videoCassettes.findById(index);
    }

    @PostMapping
    public VideoCassette addVideoCassette(@RequestBody VideoCassette videoCassette) {
        return videoCassettes.save(videoCassette);
    }

    @PutMapping
    public VideoCassette updateVideoCassette(@RequestBody VideoCassette videoCassette) {
        return videoCassettes.save(videoCassette);
    }

    @DeleteMapping
    public void deleteVideoCassette(@RequestParam Long index) {
        videoCassettes.delete(index);
    }
}
