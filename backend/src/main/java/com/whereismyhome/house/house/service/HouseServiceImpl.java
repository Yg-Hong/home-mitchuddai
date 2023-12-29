package com.whereismyhome.house.house.service;

import java.util.HashMap;
import java.util.List;

import com.whereismyhome.house.house.VO.DetailResultVO;
import com.whereismyhome.house.house.VO.SearchResultVO;
import com.whereismyhome.house.house.dao.HouseMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class HouseServiceImpl implements HouseService {

	private final HouseMapper houseMapper;

	public HouseServiceImpl(HouseMapper houseMapper) {
		this.houseMapper = houseMapper;
	}

	public List<SearchResultVO> getHouseListByDongCode(Long dongCode) {
		return houseMapper.selectHousesByDongCode(dongCode);
	}

	public DetailResultVO getDealListByDongCode(Long dongCode, Long aptCode) {
		HashMap<String, Long> params = new HashMap<>();
		params.put("dongCode", dongCode);
		params.put("aptCode", aptCode);

		return houseMapper.selectDealsByAptCode(params);
	}

	public List<SearchResultVO> getHouseListByLatLng(String ha, String oa, String pa, String qa){
		HashMap<String, String> params = new HashMap<>();
		params.put("ha", ha);
		params.put("oa", oa);
		params.put("pa", pa);
		params.put("qa", qa);

		log.info(params.toString());

		return houseMapper.selectHousesByLatLng(params);
	}

	public List<SearchResultVO> getHouseListByLatLng2(String lng, String lat, int level){
		HashMap<String, Object> params = new HashMap<>();
		params.put("lng", lng);
		params.put("lat", lat);
		params.put("dist", getDist(level));

		log.info(params.toString());

		return houseMapper.selectHousesByLatLng2(params);
	}

	//지도 zoomLevel
	public double getDist(int zoomLevel) {

		return switch (zoomLevel) {
			case 1 -> 0.003;
			case 2 -> 0.0075;
			case 3 -> 0.0125;
			case 4 -> 0.018;
			default -> 0.02;
		};
	}
}
