package com.likelion14.session.repository;

import com.likelion14.session.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Long> {
}

