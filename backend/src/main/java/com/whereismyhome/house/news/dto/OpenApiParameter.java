package com.whereismyhome.house.news.dto;

import lombok.*;

@Getter
@Setter
@ToString
public class OpenApiParameter {

    @Builder.Default
    String realEstate = ""; //검색어: 부동산

    @Builder.Default
    String housing= ""; //검색어: 주택

    @Builder.Default
    String office= ""; //검색어: 사무실

    @Builder.Default
    String economicTrend= ""; //검색어: 경제동향

    public String getRealEstate() {
        return realEstate;
    }
    public void setRealEstate(String realEstate) {
        this.realEstate = realEstate;
    }
    public String getHousing() {
        return housing;
    }
    public void setHousing(String housing) {
        this.housing = housing;
    }
    public String getOffice() {
        return office;
    }
    public void setOffice(String office) {
        this.office = office;
    }
    public String getEconomicTrend() {
        return economicTrend;
    }
    public void setEconomicTrend(String economicTrend) {
        this.economicTrend = economicTrend;
    }

}