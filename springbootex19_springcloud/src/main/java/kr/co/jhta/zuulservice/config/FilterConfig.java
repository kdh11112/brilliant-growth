package kr.co.jhta.zuulservice.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
// 빈 정의할때 스는 어노테이션
//@Configuration
public class FilterConfig {

//	@Bean
//	public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
		
		//여기다가 설정을 하게되면 야뮬 파일에서 설정을 한거랑 같은거임
//		return builder	.routes()
//						.route(r -> r.path("/first-service/**")
//						.filters(f -> f.addRequestHeader("first-service", "first-request-header")
//										.addResponseHeader("first-service", "first-response-header")
//								)
//						.uri("http://localhost:8081")
//						)
//						.route(r -> r.path("/second-service/**")
//								.filters(f -> f.addRequestHeader("second-service", "second-request-header")
//												.addResponseHeader("second-service", "second-response-header")
//										)
//								.uri("http://localhost:8082")
//						)
//						
//						.build();
//	}
	
}
