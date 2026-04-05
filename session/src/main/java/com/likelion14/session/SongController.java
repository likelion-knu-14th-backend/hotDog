package com.likelion14.session;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/songs")
public class SongController {

    private final List<SongResponseDto> songStore = new ArrayList<>();

    // POST - 음악 정보 등록
    @PostMapping
    public SongResponseDto createSong(@RequestBody SongCreateRequestDto request) {
        SongResponseDto song = new SongResponseDto(
                request.getSongName(),
                request.getSinger(),
                request.getMelonRanking()
        );

        songStore.add(song);
        return song;
    }

    // GET - 전체 조회
    @GetMapping
    public List<SongResponseDto> getSongs() {
        return songStore;
    }

    // GET - 단건 조회 (songName 기준)
    @GetMapping("/{songName}")
    public SongResponseDto getSong(@PathVariable String songName) {
        for (SongResponseDto song : songStore) {
            if (song.getSongName().equals(songName)) {
                return song;
            }
        }
        return null;
    }

    // PUT - songName 기준 수정
    @PutMapping("/{songName}")
    public SongResponseDto updateSong(
            @PathVariable String songName,
            @RequestBody SongCreateRequestDto request
    ) {
        for (int i = 0; i < songStore.size(); i++) {
            SongResponseDto song = songStore.get(i);

            if (song.getSongName().equals(songName)) {
                // 단건 식별자는 path의 songName을 우선시
                SongResponseDto updatedSong = new SongResponseDto(
                        songName,
                        request.getSinger(),
                        request.getMelonRanking()
                );

                songStore.set(i, updatedSong);
                return updatedSong;
            }
        }
        return null;
    }

    // DELETE - songName 기준 삭제
    @DeleteMapping("/{songName}")
    public void deleteSong(@PathVariable String songName) {
        for (int i = 0; i < songStore.size(); i++) {
            SongResponseDto song = songStore.get(i);

            if (song.getSongName().equals(songName)) {
                songStore.remove(i);
                return;
            }
        }
    }
}