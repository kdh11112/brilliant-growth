package kr.co.jhta.secondservice.control;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/second-service")// zuul는 없어도 됬는데 cloud일때는 잇어야함
public class SecondServiceController {

	@GetMapping("welcome")
	public String welcom() {
		return "welcom !!! second Service";
	}
	
	@GetMapping("message")
	public String msg(@RequestHeader(name = "second-service",defaultValue = "NONE")String header) {
		
		log.info("second"+header);
		return header;
	}
}
