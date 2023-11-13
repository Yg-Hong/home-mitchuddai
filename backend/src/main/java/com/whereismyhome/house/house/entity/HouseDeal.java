package com.whereismyhome.house.house.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name="housedeal")
@NoArgsConstructor
public class HouseDeal {
    @Id
    private Long no;
    private String dealAmount;
    private int dealYear;
    private int dealMonth;
    private int dealDay;
    private String area;
    private String floor;
    private String cancelDealType;

    @ManyToOne
    @JoinColumn
    private HouseInfo houseInfo;
}
