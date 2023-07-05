package kr.co.jhta.app;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

public class CheckReloadTime implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {

		StopWatch sw = new StopWatch();
		
		sw.start();
		Object obj = invocation.proceed();
		sw.stop();
		
		System.out.println("걸린시간 : "+ sw.getTotalTimeSeconds()+"초");
		
		return obj;
	}

}
