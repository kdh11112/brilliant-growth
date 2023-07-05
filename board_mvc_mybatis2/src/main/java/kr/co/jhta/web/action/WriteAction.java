package kr.co.jhta.web.action;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jhta.web.dao.BoardDAO;
import kr.co.jhta.web.vo.BoardVO;

public class WriteAction implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		try {
			req.setCharacterEncoding("UTF-8");
			resp.setContentType("text/html; charset=UTF-8");
			
			String writer = req.getParameter("writer");
			String title = req.getParameter("title");
			String contents = req.getParameter("contents");

				BoardDAO dao = new BoardDAO();
				BoardVO vo = new BoardVO();
				
		
				vo.setWriter(writer);
				vo.setTitle(title);
				vo.setContents(contents);
				vo.setIp(req.getRemoteAddr());
				
				
				dao.addOne(vo);
			
				dao.close();
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return "board.do?cmd=list";
	}

}
