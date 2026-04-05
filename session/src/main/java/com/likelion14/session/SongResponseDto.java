package com.likelion14.session;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SongResponseDto {

    private String songName;
    private String singer;
    private String melonRanking;
}