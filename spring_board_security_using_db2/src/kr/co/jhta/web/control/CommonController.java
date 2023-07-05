package kr.co.jhta.web.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommonController {

	
	@RequestMapping("/common/cLogin")
	public void login(String error,String logout, Model model) {
		
		if(error != null) {
			model.addAttribute("error", "로그인중 에러 발생");
		}else if(logout != null) {
			model.addAttribute("logout", "logout");
		}
		
		//return "common/cLogin";
		
	}
	
	@RequestMapping("/common/cLogout")
	public String logout() {
		return "common/logout";
	}
}
