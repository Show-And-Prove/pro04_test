package com.test.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.dto.BoardDTO;

@Repository
public class BoardDAOImpl implements BoardDAO{
	
	@Autowired
	SqlSession sqlsession;

	@Override	//게시글 리스트
	public List<BoardDTO> boardList() throws Exception {
		return sqlsession.selectList("board.boardList");
	}

	@Override	//글 상세
	public BoardDTO boardDetail(int seq) throws Exception {
		return sqlsession.selectOne("board.boardDetail", seq);
	}
	
	
	
	
}