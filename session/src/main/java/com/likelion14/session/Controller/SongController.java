package com.likelion14.session.Controller;

import com.likelion14.session.dto.SongCreateRequestDto;
import com.likelion14.session.dto.SongResponseDto;
import com.likelion14.session.service.SongService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/songs")
@RequiredArgsConstructor
public class SongController {

    private final SongService songService;

    @PostMapping
    public SongResponseDto createSong(@RequestBody SongCreateRequestDto request) {
        return songService.createSong(request);
    }

    @GetMapping
    public List<SongResponseDto> getSongs() {
        return songService.getSongs();
    }

    @GetMapping("/{id}")
    public SongResponseDto getSong(@PathVariable Long id) {
        return songService.getSong(id);
    }

    @PutMapping("/{id}")
    public SongResponseDto updateSong(@PathVariable Long id, @RequestBody SongCreateRequestDto request) {
        return songService.updateSong(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteSong(@PathVariable Long id) {
        songService.deleteSong(id);
    }
}

