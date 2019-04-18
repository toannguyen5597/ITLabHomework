package com.intergration.sum;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;

@Aspect
public class SumService {

    @Around("execution(* net.friend.repository.SumRepository.Input(..))")
    public String beforeReturn(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            Float.parseFloat((String)joinPoint.getArgs()[0]);
            Float.parseFloat((String)joinPoint.getArgs()[1]);
            Object obj = joinPoint.proceed();
            return obj.toString();
        } catch (Exception e){
            return "N/A";
        }
    }
}
