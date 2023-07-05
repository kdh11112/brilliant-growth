package kr.co.jhta.web.dao;

import java.util.List;

import kr.co.jhta.web.dto.BoardDTO;

public interface Dao {
	
	public List<BoardDTO> selectAll(int startNo,int endNo);//전체조회
	public BoardDTO selectOne(int bno);//하나조회
	public void insertOne(BoardDTO dto);//추가
	public void updateOne(BoardDTO dto);//변경
	public void deleteOne(int bno);//삭제
	public int getTotal();
	public void raiseHits(int bno);

}
