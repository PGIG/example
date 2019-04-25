package xyz.itbest.demo.springbootaop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @author pgig
 * @date 2019/4/25
 *
 * @Before
 * @After - 在两种情况下执行 - 方法成功执行或抛出异常时。
 * @AfterReturning - 仅在方法成功执行时执行。
 * @AfterThrowing - 仅在方法抛出异常时执行。
 * @Aroud
 *
 * 在切入点前的操作，按order的值由小到大执行
 * 在切入点后的操作，按order的值由大到小执行
 *
 */
@Aspect
@Slf4j
@Component
public class HttpAspect {

    @Pointcut("execution(public * xyz.itbest.demo.springbootaop.controller.UserController.*(..))")
    public void log(){}

    @Before("log()")
    public void beforeLog(JoinPoint joinPoint){

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        log.info("url={}",request.getRequestURI());
        log.info("method={}",request.getMethod());
        log.info("ip={}",request.getRemoteAddr());
        log.info(new StringBuilder("class_method={}")
                        .append(joinPoint.getSignature().getDeclaringTypeName())
                        .append(".")
                        .append(joinPoint.getSignature().getName())
                .toString());
        log.info("args={}", Arrays.toString(joinPoint.getArgs()));
    }

    @After("log()")
    public void afterLog(){
        System.out.println("afterlog");
    }

    @AfterReturning(returning = "object",pointcut = "log()")
    public void doAfterReturning(Object object){
        log.info("object={}", object);
    }

}
