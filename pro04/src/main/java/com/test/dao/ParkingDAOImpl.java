package com.test.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.dto.ParkingDTO;

@Repository
public class ParkingDAOImpl implements ParkingDAO{
	
	@Autowired
	SqlSession sqlSession;

	@Override	
	public List<ParkingDTO> parkingList() throws Exception {
		return sqlSession.selectList("parking.parkingList");
	}

	@Override	
	public ParkingDTO parkingDetail(int parkno) throws Exception {
		return sqlSession.selectOne("parking.parkingDetail", parkno);
	}

	@Override
	public void carIn(ParkingDTO dto) throws Exception {
		sqlSession.insert("parking.carIn", dto);
	}

	@Override
	public void carOut(int parkno) throws Exception {
		sqlSession.delete("parking.carOut", parkno);		
	}

	
	//기록남는 출차
	@Override
	public void carOut2(ParkingDTO dto) throws Exception {
		sqlSession.insert("parking.carOut2", dto);
	}
	
	
}
