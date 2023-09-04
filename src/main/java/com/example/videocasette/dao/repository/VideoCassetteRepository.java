package com.example.videocasette.dao.repository;

import com.example.videocasette.dao.entity.VideoCassette;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoCassetteRepository extends CrudRepository<VideoCassette, Long> {
}
