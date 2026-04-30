package com.likelion14.session.dto;

import com.likelion14.session.entity.Song;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class SongResponseDto {

    private Long id;
    private String title;
    private String artist;
    private LocalDate releaseDate;

    public SongResponseDto(Song song) {
        this.id = song.getId();
        this.title = song.getTitle();
        this.artist = song.getArtist();
        this.releaseDate = song.getReleaseDate();
    }
}
