package com.likelion14.session.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class SongCreateRequestDto {

    private String title;
    private String artist;
    private LocalDate releaseDate;
}

