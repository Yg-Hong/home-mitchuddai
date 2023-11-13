package com.whereismyhome.house.house.service;

import com.whereismyhome.house.house.dto.HouseDto;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface HouseService {

    public List<HouseDto> searchByDongCode(String dongCode, int year, int month) throws SQLException;
    public Map<String, String> searchLocationByDongCode(String dongCode) throws SQLException;
}
