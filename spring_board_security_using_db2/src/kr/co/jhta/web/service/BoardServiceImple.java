package kr.co.jhta.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.jhta.web.dao.Dao;
import kr.co.jhta.web.dto.BoardDTO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("BoardServiceBean")
public class BoardServiceImple implements BoardService{

	@Autowired
	Dao dao;
	
	@Override
	public List<BoardDTO> readAll(int startNo, int endNo) {
		log.info("dao : {} ",dao);
		return dao.selectAll(startNo, endNo);
	}

	@Override
	public void write(BoardDTO dto) {
		dao.insertOne(dto);
		
	}

	@Override
	public BoardDTO readOne(int bno) {
		//트랜잭션 처리 시작
		dao.raiseHits(bno); //해당 게시물의 조회수를 1증가 시킴
		BoardDTO dto = dao.selectOne(bno);
		return dto;
	}

	@Override
	public void modify(BoardDTO dto) {
		dao.updateOne(dto);
		
	}

	@Override
	public void remove(int bno) {
		dao.deleteOne(bno);
		
	}

	@Override
	public int getTotal() {
		
		return dao.getTotal();
	}

}
