package kr.co.jhta.web.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jhta.web.dao.BoardDAO;
import kr.co.jhta.web.vo.BoardVO;

public class ListAction implements Action{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		
		//전체 게시물 건수를 출력?
		BoardDAO dao = new BoardDAO();
		int totalCount = dao.getTotalCount();		
		
		//한 페이지당 게시물건수 : 20
		int recordPerPage = 20;
		int totalPage = (totalCount%recordPerPage==0) ? totalCount/recordPerPage : totalCount/recordPerPage+1;
		
		
		String cp = req.getParameter("cp");
		int currentPage = 0;
		if(cp != null){			
		currentPage = Integer.parseInt(cp);
		}else{
			currentPage = 1;
		}
		
		int startNo = (currentPage - 1)*recordPerPage + 1;
		int endNO = currentPage*recordPerPage;
		
		//시작페이지번호
		int startPage = 1;
		
		//끝페이지번호
		int endPage = totalPage;
		
		//시작페이지 미세조정
		if(currentPage <= 5){
			startPage = 1;
		}else if(currentPage >= 6){
			startPage = currentPage - 4;
		}
		
		//끝페이지 번호
		if(totalPage - currentPage <=5){
			endPage = totalPage;
		}else if(totalPage - currentPage > 5){
			if(currentPage<=5){
				if(totalPage >10){
					endPage = 10;
				}else{
					endPage = totalPage;
				}
			}else{
				endPage = currentPage+4;
			}
		}
		
		
		List<BoardVO> list = dao.selectAll(startNo,endNO);
		req.setAttribute("list", list);
		req.setAttribute("startPage", startPage);
		req.setAttribute("endPage", endPage);
		dao.close();
		
		return "views/list.jsp";
	}
	
}
