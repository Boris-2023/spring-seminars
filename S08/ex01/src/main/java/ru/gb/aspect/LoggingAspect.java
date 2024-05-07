package ru.gb.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;

@Aspect
public class LoggingAspect {
    @Around("execution(* ru.gb.service.*.*(..))")
    @Order(1)
    public Object log(ProceedingJoinPoint pjp) throws Throwable {

        System.out.println("Aspect before the method ...");
        Object returnedByMethod = pjp.proceed(); // call method from service
        System.out.println("Aspect after the method ...");

        return returnedByMethod;
    }

    // this aspect will be called where there will be an anno @ToLog
    @AfterReturning(value = "@annotation(ToLog)", returning = "returnedValue")
    @Order(2)
    public void log(Object returnedValue){
        System.out.println("Method executed and returned: " + returnedValue);
    }
}
