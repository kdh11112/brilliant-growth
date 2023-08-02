package kr.co.jhta.zuulservice.config;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.server.ServerWebExchange;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
//커스텀 필터
@Component
public class CustomFilter extends AbstractGatewayFilterFactory<CustomFilter.Config>{

	//설정 정보를 제공하는 클래스
	public static class Config{
		
	}
	
	public CustomFilter() {
		super(Config.class);
	}

	//필터의 동작을 정의한 메소드
	@Override
	public GatewayFilter apply(Config config) {

//		GatewayFilter gf = new GatewayFilter() {//인터페이스 이기에 이너 클래스로 바로 만듬
//			
//			@Override
//			public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//				ServerHttpRequest request = exchange.getRequest();
//				ServerHttpResponse response = exchange.getResponse();
//				
//				log.info("Customer pre Filter : request id = {}",request.getId());
//				Mono<Void> m = chain.filter(exchange).then(Mono.fromRunnable(() ->{
//					log.info("Custom POST filter : response code = {}",response.getStatusCode());
//				}));
//				
//				return m;
//			}
//		};
//		
//		return gf;
		
		//위의 코드를 람다식으로 정의 하는방법
		return (exchange,chain) -> {
			ServerHttpRequest request = exchange.getRequest();
			ServerHttpResponse response = exchange.getResponse();
			log.info("Customer pre Filter : request id {}",request.getId());
			return chain.filter(exchange).then(Mono.fromRunnable(() ->{
				log.info("Customer POST filter : response code = {}",response.getStatusCode());
			}));
		};
		
	}

}
