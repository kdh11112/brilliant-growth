package kr.co.jhta.web.action;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jhta.web.dao.BoardDAO;
import kr.co.jhta.web.vo.BoardVO;

public class DetailAction implements Action {
	
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		try {
			req.setCharacterEncoding("UTF-8");
			resp.setContentType("text/html; charset=UTF-8");
		
			//파라미터 값을 가져와서
			String b = req.getParameter("bno");
			if(b != null) {
				int bno = Integer.parseInt(b);
				//dao
				BoardDAO dao = new BoardDAO();
				//데이터 한건 가져오기
				BoardVO vo = dao.selectOne(bno);
				//요청객체의 속성으로 담기
				req.setAttribute("vo", vo);
				
				dao.close();
			}
		
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		//뷰의 위치를 리턴
		return "views/detail.jsp";
	}

}
