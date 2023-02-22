package com.github.curriculeon.config;

import com.github.curriculeon.utils.Loggable;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class LoggingConfig implements Loggable {

    //AOP expression for which methods shall be intercepted
    @Around("execution(* com.github.curriculeon..*(..)))")
    public Object profileAllMethods(ProceedingJoinPoint proceedingJoinPoint) {
        final MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        final String className = methodSignature.getDeclaringType().getSimpleName();
        final String methodName = methodSignature.getName();
        final StopWatch stopWatch = new StopWatch();
        Object result;

        //Measure method execution time
        getLogger().info(String.format("Attempting to invoke `%s.%s`...", className, methodName));
        stopWatch.start();
        try {
            result = proceedingJoinPoint.proceed();
        } catch (Throwable t) {
            result = t;
        } finally {
            stopWatch.stop();
        }
        final long elapsedTime = stopWatch.getTotalTimeMillis();
        getLogger().info(String.format("`%s.%s` resulted in `%s` :: executed in %s ms", className, methodName, result, elapsedTime));
        return result;
    }
}