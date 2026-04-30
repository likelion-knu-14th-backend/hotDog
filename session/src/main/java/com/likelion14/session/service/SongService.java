package com.likelion14.session.service;

import com.likelion14.session.dto.SongCreateRequestDto;
import com.likelion14.session.dto.SongResponseDto;
import com.likelion14.session.entity.Song;
import com.likelion14.session.repository.SongRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SongService {

    private final SongRepository songRepository;

    public SongResponseDto createSong(SongCreateRequestDto request) {
        Song song = new Song(
                request.getTitle(),
                request.getArtist(),
                request.getReleaseDate()
        );

        Song savedSong = songRepository.save(song);
        return new SongResponseDto(savedSong);
    }

    public List<SongResponseDto> getSongs() {
        return songRepository.findAll()
                .stream()
                .map(SongResponseDto::new)
                .toList();
    }

    public SongResponseDto getSong(Long id) {
        Song song = songRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 곡이 존재하지 않습니다."));

        return new SongResponseDto(song);
    }

    public SongResponseDto updateSong(Long id, SongCreateRequestDto request) {
        Song song = songRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 곡이 존재하지 않습니다."));

        song.update(
                request.getTitle(),
                request.getArtist(),
                request.getReleaseDate()
        );

        Song updatedSong = songRepository.save(song);
        return new SongResponseDto(updatedSong);
    }

    public void deleteSong(Long id) {
        Song song = songRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 곡이 존재하지 않습니다."));

        songRepository.delete(song);
    }
}

