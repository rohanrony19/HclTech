package com.springboot.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

@Aspect
@Service
public class LoggingAspect {

	@Before("execution(* com.springboot.aop.*.*(..))")
	public void logBefore1() {
		System.out.println("logging before method");
	}
	
	@After("execution(* com.springboot.aop.*.*(..))")
	public void logBefore2() {
		System.out.println("logging after method");
	}
	
	@Around("execution(* com.springboot.aop.*.*(..))")
	public void logBefore3(ProceedingJoinPoint p) throws Throwable {
		System.out.println("nothing");
		p.proceed();
		System.out.println("asdfghjk");
	}
}
