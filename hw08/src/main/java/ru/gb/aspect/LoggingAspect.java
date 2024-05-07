package ru.gb.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {
    @Before(value = "@annotation(TrackUserAction)")
    public void beforeAdvice(JoinPoint pp) {
        System.out.println("Method CALL detected: \nMethod name = " + pp.getSignature().getName() + "()");
    }
    @AfterReturning(value = "@annotation(TrackUserAction)", returning = "returnedValue")
    public void log(Object returnedValue) {
        System.out.println("Return value = " + returnedValue);
    }
}
