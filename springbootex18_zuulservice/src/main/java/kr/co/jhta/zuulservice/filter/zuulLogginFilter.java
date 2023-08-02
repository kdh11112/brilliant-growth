package kr.co.jhta.zuulservice.filter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class zuulLogginFilter extends ZuulFilter{

	@Override
	public boolean shouldFilter() {
		return true; //필터 사용
	}

	@Override
	public Object run() throws ZuulException {
		//필터가 동작 된다면 이부분이 실행됨
		log.info("로그 시작 ===============>");
		//요청 URI 를 로그로 기록
		
		//1번방식
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		String uri = request.getRequestURI();
		log.info("요청 uri : {}",uri);
		
		//2번방식  ==> 1번과 똑같은 거임
		log.info("요청 uri : {}",RequestContext.getCurrentContext().getRequest().getRequestURI());
		log.info("로그 끝 ===============>");
		return null;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "pre"; //진입 쪽 필터
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

}
