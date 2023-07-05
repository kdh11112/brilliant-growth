package kr.co.jhta.app;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.util.StopWatch;

@Aspect
public class CheckReloadTime3 {
	
	@Pointcut("execution (public * tire(..))")
	public void publicTarget() {
		
	}
	
	@Around("publicTarget()")
	public Object logAround(ProceedingJoinPoint pjp) throws Throwable {
		
		String methodname = pjp.getSignature().getName();
		System.out.println("실행중인 메서드: "+methodname);
		
		StopWatch sw = new StopWatch();
		
		sw.start();
		
		Object obj = pjp.proceed();
		sw.stop();
		
		System.out.println("처리 시간 : "+sw.getTotalTimeSeconds()+"초");
		
		return obj;
	}



}
