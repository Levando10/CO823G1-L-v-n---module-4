package com.example.data.service;

import com.example.data.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ISongService {
    Page<Song> findAll(Pageable pageable);

    void save(Song song);

    Song findById(Integer id);
}
