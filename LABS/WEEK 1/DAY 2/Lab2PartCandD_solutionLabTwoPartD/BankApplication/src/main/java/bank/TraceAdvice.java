package bank;

import bank.integration.logging.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StopWatch;

@Aspect
@Configuration
public class TraceAdvice {

    @Autowired
    private Logger logger;

    @Before("execution(* bank.repository.*.*(..))")
    public void tracerepositorymethod(JoinPoint joinpoint) {
        logger.log("before execution of method "+joinpoint.getSignature().getName());
    }

    @Around("execution(* bank.service.*.*(..))")
    public Object profile (ProceedingJoinPoint call) throws Throwable{
        StopWatch clock = new StopWatch("");
        clock.start(call.toShortString());
        Object object= call.proceed();
        clock.stop();
        System.out.println(clock.prettyPrint());
        return object;
    }

    @Before("execution(* bank.integration.jms.JMSSender.sendJMSMessage(..))")
    public void traceJMSmethod(JoinPoint joinpoint) {
        String text = (String) joinpoint.getArgs()[0];
        logger.log("before execution of method "+joinpoint.getSignature().getName() + " text=" + text);

    }


}
