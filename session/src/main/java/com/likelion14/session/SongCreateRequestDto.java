package com.likelion14.session;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SongCreateRequestDto {

    //박신형이 구상한 API
    private String songName;
    private String singer;
    private String melonRanking;
}