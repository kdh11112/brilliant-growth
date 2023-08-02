package kr.co.jhta.firstservice.control;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/first-service")// zuul는 없어도 됬는데 cloud일때는 잇어야함
public class FirstServiceController {

	@GetMapping("/welcome")
	public String welcome() {
		return "welcom !!! first Service";
	}
	
	@GetMapping("message")
	public String msg(@RequestHeader(value = "first-service",defaultValue = "NONE") String header) {
		
		log.info("apigateway에서 추가한 헤더 정보"+header);
		
		return header;
	}
	
	@GetMapping("/check")
	public String check(HttpServletRequest request) {
		log.info("check 호출됨");
		log.info("요청 포트 : {}",request.getServerPort());
		return "/check : "+request.getServerPort();
	}
}
