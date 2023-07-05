package kr.co.jhta.web.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PublicController {
	
	@GetMapping("/public/public")
	public String show() {
		
		return "public";
		
	}

}
