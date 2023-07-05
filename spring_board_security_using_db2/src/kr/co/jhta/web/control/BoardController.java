package kr.co.jhta.web.control;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.jhta.web.dao.Dao;
import kr.co.jhta.web.dto.BoardDTO;
import kr.co.jhta.web.service.BoardService;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
public class BoardController {

	@Autowired
	@Qualifier("BoardServiceBean")
	BoardService service;
	
	@GetMapping("/board/list")
	public String list(Model model ,@RequestParam(name="currentPage",defaultValue="1")int currentPage) {
		
		//현재 페이지번호
//		int currentPage = 1;
		
		//총 게시물수
		int totalNumber = service.getTotal();
		//한페이지의 게시물수는 : 10
		int countPerPage = 10;
		//총페이지수
		int totalPage = (totalNumber%countPerPage == 0) ? totalNumber/countPerPage : totalNumber/countPerPage+1;
  		
		//현재 페이지의 게시물 시작번호
		int startNo = (currentPage -1) * countPerPage + 1; // (3 -1) *10+1 ==>21
		//현재 페이지의 게시물 끝번호
		int endNo = currentPage * countPerPage; // 3 * 10
		
		//시작 페이지번호
		int startPageNo = currentPage -5 <= 0 ? 1 : currentPage -5;
		//끝페이지 번호
		int endPageNo = startPageNo+10 >= totalPage ? totalPage : startPageNo+10;
		//이전
		boolean prev = currentPage > 5 ? true : false;
		boolean next = currentPage+5 >= totalPage ? false : true; 
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalNumber", totalNumber);
		model.addAttribute("countPerPage", countPerPage);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("startNo", startNo);
		model.addAttribute("endNo", endNo);
		model.addAttribute("startPageNo", startPageNo);
		model.addAttribute("endPageNo", endPageNo);
		model.addAttribute("prev", prev);
		model.addAttribute("next", next);
		
		model.addAttribute("list", service.readAll(startNo, endNo));
		return "list";
	}
	
	@GetMapping("/board/detail")
	public String detail(@RequestParam("bno")int bno,Model model) {
		model.addAttribute("detail", service.readOne(bno));

		return "detail";
	}
	
	@GetMapping("/board/writer")
	public String writerForm() {
		return "writerForm";
	}
	
	@PostMapping("/board/writer")
	public String writerOk(@ModelAttribute BoardDTO dto, HttpServletRequest req) {
		dto.setIp(req.getRemoteAddr());
		
		service.write(dto);;
		return "redirect:list";
	}
	
	@GetMapping("/board/modify")
	public String modifyForm(@RequestParam("bno")int bno,Model model) {
		model.addAttribute("modify", service.readOne(bno));
		
		return "modify";
	}
	
	@PostMapping("/board/modify")
	public String modifyOk(@ModelAttribute BoardDTO dto) {
		service.modify(dto);
		return "redirect:list";
	}
	
	@GetMapping("/board/delete")
	public String deleteOk(@RequestParam("bno")int bno) {
		service.remove(bno);
		
		return "redirect:list";
	}
	
}
