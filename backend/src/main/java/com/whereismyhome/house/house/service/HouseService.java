package com.whereismyhome.house.house.service;

import com.whereismyhome.house.house.VO.DetailResultVO;
import com.whereismyhome.house.house.VO.SearchResultVO;

import java.util.List;

public interface HouseService {

    public List<SearchResultVO> getHouseListByDongCode(Long dongCode);
    public DetailResultVO getDealListByDongCode(Long dongCode, Long aptCode);
    public List<SearchResultVO> getHouseListByLatLng(String ha, String oa, String pa, String qa);
    public List<SearchResultVO> getHouseListByLatLng2(String lng, String lat, int level);
}
