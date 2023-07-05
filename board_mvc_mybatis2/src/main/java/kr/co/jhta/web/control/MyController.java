package kr.co.jhta.web.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jhta.web.action.Action;
import kr.co.jhta.web.action.DeleteAction;
import kr.co.jhta.web.action.DetailAction;
import kr.co.jhta.web.action.ListAction;
import kr.co.jhta.web.action.ModifyFormAction;
import kr.co.jhta.web.action.ModifyOkAction;
import kr.co.jhta.web.action.WriteAction;
import kr.co.jhta.web.action.WriteFormAction;

@WebServlet("/board.do")
public class MyController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPro(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPro(req,resp);
	}
	
	private void doPro(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		//cmd 파라미터 값 가져오기
		String cmd = req.getParameter("cmd");
		String url = "";
		Action action = null;
		if(cmd == null || cmd.equals("list")) {
			//ListAction 객체를 생성
			action = new ListAction();
			//ListAction 객체의 execute()를 호출
			url = action.execute(req,resp);
		}else if(cmd.equals("detail")) {
			action = new DetailAction();
			url = action.execute(req,resp);
		}else if(cmd.equals("modify")) {
			action = new ModifyFormAction();
			url = action.execute(req, resp);
		}else if(cmd.equals("modifyOk")) {
			action = new ModifyOkAction();
			url = action.execute(req, resp);
		}else if(cmd.equals("write")) {
			action = new WriteFormAction();
			url = action.execute(req, resp);
		}else if(cmd.equals("writeOk")) {
			action = new WriteAction();
			url = action.execute(req, resp);
		}else if(cmd.equals("delete")) {
			action = new DeleteAction();
			url = action.execute(req, resp);
		}
		System.out.println(cmd);
		RequestDispatcher rd = req.getRequestDispatcher(url);
		rd.forward(req, resp);
		
	}
}
