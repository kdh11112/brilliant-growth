package kr.co.jhta.web.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.jhta.web.dto.BoardDTO;
import kr.co.jhta.web.dto.StartEnd;

@Repository
public class BoardDAO implements Dao{

	@Autowired
	SqlSession ss;
	
	@Override
	public List<BoardDTO> selectAll(int startNo,int endNo) {
		StartEnd se = new StartEnd();
		se.setStartNo(startNo);
		se.setEndNo(endNo);
		
		return ss.selectList("kr.co.jhta.board.selectAll",se);
	}

	@Override
	public BoardDTO selectOne(int bno) {

		return ss.selectOne("kr.co.jhta.board.selectOne",bno);
	}

	@Override
	public void insertOne(BoardDTO dto) {
		ss.insert("kr.co.jhta.board.insertOne",dto);
		
	}

	@Override
	public void updateOne(BoardDTO dto) {
		ss.update("kr.co.jhta.board.updatetOne",dto);
		
	}

	@Override
	public void deleteOne(int bno) {
		ss.delete("kr.co.jhta.board.deleteOne",bno);
		
	}

	@Override
	public int getTotal() {
		return ss.selectOne("kr.co.jhta.board.totalCount");
	}

	@Override
	public void raiseHits(int bno) {
		ss.update("kr.co.jhta.board.raiseHit",bno);
		
	}

}
