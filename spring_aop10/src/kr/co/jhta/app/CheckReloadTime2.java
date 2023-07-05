package kr.co.jhta.app;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class CheckReloadTime2 {
	
	public Object logAround(ProceedingJoinPoint pjp) throws Throwable {
		
		String methodname = pjp.getSignature().getName();
		
		System.out.println("실행중인 메서드명: " +methodname);
		
		StopWatch sw = new StopWatch();
		
		sw.start();
		
		Object obj = pjp.proceed();
		sw.stop();
		
		System.out.println("실행 시간"+sw.getTotalTimeSeconds()+"초");
		
		return obj;
	}



}
