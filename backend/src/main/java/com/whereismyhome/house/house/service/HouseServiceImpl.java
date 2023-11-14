package com.whereismyhome.house.house.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.whereismyhome.house.house.dto.HouseDto;
import com.whereismyhome.house.house.dao.HouseDao;
import org.springframework.stereotype.Service;

@Service
public class HouseServiceImpl implements HouseService {
	private HouseDao houseDao;
	
	public List<HouseDto> searchByDongCode(String dongCode, int year, int month) throws SQLException {
		return houseDao.searchByDongCode(dongCode, year, month);
	}
	
	public Map<String, String> searchLocationByDongCode(String dongCode) throws SQLException {
		return houseDao.searchLocationByDongCode(dongCode);
	}
}
