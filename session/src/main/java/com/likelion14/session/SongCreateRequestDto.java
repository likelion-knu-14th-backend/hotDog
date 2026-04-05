package com.likelion14.session;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SongCreateRequestDto {

    private String songName;
    private String singer;
    private String melonRanking;
}