package kr.co.jhta.web.control;

import java.util.List;

import kr.co.jhta.web.dao.BoardDAO;
import kr.co.jhta.web.vo.BoardVO;

public class testMain {

	public static void main(String[] args) {
		
		BoardDAO dao = new BoardDAO();
		
		int result = dao.getTotalCount();
		System.out.println(result);
		
		List<BoardVO> list = dao.selectAll(1, 10);
		
		System.out.println("list : "+ list);
		for(BoardVO vo : list) {
			System.out.println(vo.getWriter()+" : "+vo.getTitle());
		}
		
	}
}
