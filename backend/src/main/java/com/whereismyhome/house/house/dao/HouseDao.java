package com.whereismyhome.house.house.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.whereismyhome.house.house.dto.DongCodeDto;
import com.whereismyhome.house.house.dto.HouseDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseDao {

	List<DongCodeDto> dongCodeList(String dongName);

	List<HouseDto> searchByDongCode(String dongCode, int year, int month) throws SQLException;

	List<HouseDto> searchByAptNo(long aptNo, int year, int month) throws SQLException;
	
	Map<String, String> searchLocationByDongCode(String dongCode) throws SQLException;
}
