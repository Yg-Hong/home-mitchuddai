<<<<<<< HEAD
package com.whereismyhome.house.house.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.whereismyhome.house.house.dto.DongCodeDto;
import com.whereismyhome.house.house.dto.HouseDto;
import com.whereismyhome.house.util.DBUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HouseDaoImpl implements HouseDao {

	@Override
	public List<DongCodeDto> dongCodeList(String dongName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HouseDto> searchByDongCode(String dongCode, int year, int month) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select info.aptCode, info.apartmentName, info.lng, info.lat, deal.dealAmount, deal.dealYear, deal.dealMonth, deal.dealDay, deal.area"
				+ " FROM houseinfo as info, housedeal as deal"
				+ " WHERE info.aptCode = deal.aptCode AND"
				+ " info.dongCode = ? AND deal.dealYear = ? AND deal.dealMonth = ?";

		List<HouseDto> houseList = new ArrayList<>();
		try {
			conn = DBUtil.getInstance().getConnection();
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, dongCode);
			stmt.setInt(2, year);
			stmt.setInt(3, month);

			System.out.println(stmt);

			rs = stmt.executeQuery();

			while(rs.next()) {
				houseList.add(new HouseDto(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6),
				rs.getInt(7), rs.getInt(8), rs.getString(9)));
			}

		} finally {
			DBUtil.getInstance().close(stmt, conn, rs);
		}

		log.info(houseList.toString());
		return houseList;
	}

	@Override
	public List<HouseDto> searchByAptNo(long aptNo, int year, int month) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> searchLocationByDongCode(String dongCode) throws SQLException {
		Map<String, String> location = new HashMap<>();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String sql = "select sidoName, gugunName, dongName from dongcode where dongCode = ?";
		try {
			conn = DBUtil.getInstance().getConnection();
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, dongCode);

			System.out.println(stmt);

			rs = stmt.executeQuery();

			if(rs.next()) {
				location.put("sidoName" ,rs.getString(1));
				location.put("gugunName" ,rs.getString(2));
				location.put("dongName" ,rs.getString(3));
			}
		} finally {
			DBUtil.getInstance().close(stmt, conn, rs);
		}

		return location;
	}

=======
//package com.whereismyhome.house.house.dao;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import com.whereismyhome.house.house.dto.DongCodeDto;
//import com.whereismyhome.house.house.dto.HouseDto;
//import com.whereismyhome.house.util.DBUtil;
//import lombok.extern.slf4j.Slf4j;
//
//@Slf4j
//public class HouseDaoImpl implements HouseDao {
//
>>>>>>> 49e9d86 ([add] jpa entity mapping)
//	@Override
//	public List<DongCodeDto> dongCodeList(String dongName) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<HouseDto> searchByDongCode(String dongCode, int year, int month) throws SQLException {
//		Connection conn = null;
//		PreparedStatement stmt = null;
<<<<<<< HEAD
//
//		ResultSet rs = null;
//		String sql = "SELECT * FROM HOUSEDEAL WHERE aptCode = ? AND dealYear = ? AND dealMonth = ?";
//
//		List<HouseDealDto> dealList = new ArrayList<>();
=======
//		ResultSet rs = null;
//		String sql = "select info.aptCode, info.apartmentName, info.lng, info.lat, deal.dealAmount, deal.dealYear, deal.dealMonth, deal.dealDay, deal.area"
//				+ " FROM houseinfo as info, housedeal as deal"
//				+ " WHERE info.aptCode = deal.aptCode AND"
//				+ " info.dongCode = ? AND deal.dealYear = ? AND deal.dealMonth = ?";
//
//		List<HouseDto> houseList = new ArrayList<>();
>>>>>>> 49e9d86 ([add] jpa entity mapping)
//		try {
//			conn = DBUtil.getInstance().getConnection();
//			stmt = conn.prepareStatement(sql);
//
//			stmt.setString(1, dongCode);
//			stmt.setInt(2, year);
//			stmt.setInt(3, month);
//
<<<<<<< HEAD
//			rs = stmt.executeQuery();
//
//			while(rs.next()) {
//				HouseDealDto deal = new HouseDealDto();
//
//				deal.setNo(rs.getLong(1));
//				deal.setDealAmount(rs.getString(2));
//				deal.setDealYear(rs.getInt(3));
//				deal.setDealMonth(rs.getInt(4));
//				deal.setDealDay(rs.getInt(5));
//				deal.setArea(rs.getString(6));
//				deal.setFloor(rs.getString(7));
//				deal.setCancelDealType(rs.getString(8));
//				deal.setAptCode(rs.getLong(9));
//
//				dealList.add(deal);
=======
//			System.out.println(stmt);
//
//			rs = stmt.executeQuery();
//
//			while(rs.next()) {
//				houseList.add(new HouseDto(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6),
//				rs.getInt(7), rs.getInt(8), rs.getString(9)));
>>>>>>> 49e9d86 ([add] jpa entity mapping)
//			}
//
//		} finally {
//			DBUtil.getInstance().close(stmt, conn, rs);
//		}
//
<<<<<<< HEAD
//		return dealList;
=======
//		log.info(houseList.toString());
//		return houseList;
>>>>>>> 49e9d86 ([add] jpa entity mapping)
//	}
//
//	@Override
//	public List<HouseDto> searchByAptNo(long aptNo, int year, int month) throws SQLException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Map<String, String> searchLocationByDongCode(String dongCode) throws SQLException {
//		Map<String, String> location = new HashMap<>();
//
//		Connection conn = null;
//		PreparedStatement stmt = null;
//		ResultSet rs = null;
//
//		String sql = "select sidoName, gugunName, dongName from dongcode where dongCode = ?";
//		try {
//			conn = DBUtil.getInstance().getConnection();
//			stmt = conn.prepareStatement(sql);
//
//			stmt.setString(1, dongCode);
//
//			System.out.println(stmt);
//
//			rs = stmt.executeQuery();
//
//			if(rs.next()) {
//				location.put("sidoName" ,rs.getString(1));
//				location.put("gugunName" ,rs.getString(2));
//				location.put("dongName" ,rs.getString(3));
//			}
//		} finally {
//			DBUtil.getInstance().close(stmt, conn, rs);
//		}
//
//		return location;
//	}
//
////	@Override
////	public List<HouseDealDto> searchByAptNo(long aptNo, int year, int month) throws SQLException {
////		Connection conn = null;
////		PreparedStatement stmt = null;
////
////		ResultSet rs = null;
////		String sql = "SELECT * FROM HOUSEDEAL WHERE aptCode = ? AND dealYear = ? AND dealMonth = ?";
////
////		List<HouseDealDto> dealList = new ArrayList<>();
////		try {
////			conn = DBUtil.getInstance().getConnection();
////			stmt = conn.prepareStatement(sql);
////
////			stmt.setLong(1, aptNo);
////			stmt.setInt(2, year);
////			stmt.setInt(3, month);
////
////			rs = stmt.executeQuery();
////
////			while(rs.next()) {
////				HouseDealDto deal = new HouseDealDto();
////
////				deal.setNo(rs.getLong(1));
////				deal.setDealAmount(rs.getString(2));
////				deal.setDealYear(rs.getInt(3));
////				deal.setDealMonth(rs.getInt(4));
////				deal.setDealDay(rs.getInt(5));
////				deal.setArea(rs.getString(6));
////				deal.setFloor(rs.getString(7));
////				deal.setCancelDealType(rs.getString(8));
////				deal.setAptCode(rs.getLong(9));
////
////				dealList.add(deal);
////			}
////
////		} finally {
////			DBUtil.getInstance().close(stmt, conn, rs);
////		}
////
////		return dealList;
////	}
//
//}
