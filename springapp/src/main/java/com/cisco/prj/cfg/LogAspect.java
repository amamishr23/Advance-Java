package com.cisco.prj.cfg;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LogAspect {
	@Before("execution(* com.cisco.prj.service.*.*(..))")
	public void logBeforeV1(JoinPoint joinPoint) {
		 Object[] args = joinPoint.getArgs();
		 for(Object name : args) {
			 System.out.println(name);
		 }
	}
}
