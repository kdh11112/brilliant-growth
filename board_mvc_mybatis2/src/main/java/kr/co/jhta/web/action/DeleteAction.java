package kr.co.jhta.web.action;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jhta.web.dao.BoardDAO;
import kr.co.jhta.web.vo.BoardVO;

public class DeleteAction implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		try {
			req.setCharacterEncoding("UTF-8");
			resp.setContentType("text/html; charset=UTF-8");
			
			String b = req.getParameter("bno");
			
			if(b != null) {
				int bno = Integer.parseInt(b);
			
				BoardDAO dao = new BoardDAO();
				dao.deleteOne(bno);
				
				dao.close();
			}
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return "board.do?cmd=list";
	}

}
