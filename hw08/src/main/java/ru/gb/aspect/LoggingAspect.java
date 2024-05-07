package ru.gb.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

// класс аспектов
@Aspect
public class LoggingAspect {

    // перед методом с анно @TrackUserAction в консоль выводится его название
    @Before(value = "@annotation(TrackUserAction)")
    public void beforeAdvice(JoinPoint pp) {
        System.out.println("Method CALL detected: \n" +
                "Method name = " + pp.getSignature().getName() + "()");
    }

    // после того, как метод отработал, в консоль выводится результат его работы
    @AfterReturning(value = "@annotation(TrackUserAction)", returning = "returnedValue")
    public void log(Object returnedValue) {
        System.out.println("Return value = " + returnedValue);
    }
}
