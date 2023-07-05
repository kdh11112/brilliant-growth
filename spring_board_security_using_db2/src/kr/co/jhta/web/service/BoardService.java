package kr.co.jhta.web.service;

import java.util.List;

import kr.co.jhta.web.dto.BoardDTO;

public interface BoardService {
	
	public List<BoardDTO> readAll(int startNo, int endNo);
	
	public void write(BoardDTO dto);
	
	public BoardDTO readOne(int bno);
	
	public void modify(BoardDTO dto);
	
	public void remove(int bno);
	
	public int getTotal();

}
