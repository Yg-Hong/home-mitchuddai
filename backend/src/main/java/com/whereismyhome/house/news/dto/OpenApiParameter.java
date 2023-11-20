package com.whereismyhome.house.news.dto;

import lombok.*;

@Getter
@Setter
@ToString
public class OpenApiParameter {

    @Builder.Default
    String keyword = ""; // 검색어

}