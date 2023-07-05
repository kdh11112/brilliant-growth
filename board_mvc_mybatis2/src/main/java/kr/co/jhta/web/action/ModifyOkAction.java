package kr.co.jhta.web.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jhta.web.dao.BoardDAO;
import kr.co.jhta.web.vo.BoardVO;

public class ModifyOkAction implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		try {
			req.setCharacterEncoding("UTF-8");
			resp.setContentType("text/html; charset=UTF-8");
			
			String b = req.getParameter("bno");
			String contents = req.getParameter("contents");
			String title = req.getParameter("title");
			if(b != null) {
				int bno = Integer.parseInt(b);
				
				BoardDAO dao = new BoardDAO();
				BoardVO vo = new BoardVO();
				vo.setBno(bno);
				vo.setTitle(title);
				vo.setContents(contents);
				
				dao.updateOne(vo);
				
				dao.close();
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return "board.do?cmd=list";
	}
}
