package com.whereismyhome.house.house.VO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DetailResultVO {
    private Long no;
    private String dealAmount;
    private int dealYear;
    private int dealMonth;
    private String area;
    private String floor;


    private Long aptCode;
    private int buildYear;
    private String roadName;
    private String apartmentName;
    private String jibun;
    private String lng;
    private String lat;

    private String sidoName;
    private String gugunName;
    private String dongName;
}
