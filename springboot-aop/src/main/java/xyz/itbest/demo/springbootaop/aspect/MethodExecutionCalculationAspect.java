package xyz.itbest.demo.springbootaop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

/**
 * @author pgig
 * @date 2019/4/25
 */
@Aspect
@Slf4j
@Configuration
public class MethodExecutionCalculationAspect {

    @Around("@annotation(xyz.itbest.demo.springbootaop.aspect.TrackTime)")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        joinPoint.proceed();

        long timeTaken = System.currentTimeMillis() - startTime;
        log.info("Time Taken by {} is {}", joinPoint, timeTaken);
    }
}
