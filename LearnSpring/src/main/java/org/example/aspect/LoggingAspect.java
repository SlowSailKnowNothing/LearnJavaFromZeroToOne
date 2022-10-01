package org.example.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.example.annotation.TestAnno;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
//    @Before("execution(public * org.example.service.UserService.*(..))")
//    public void checkAccess(){
//        System.out.println(
//                "do check!"
//        );
//    }

//    @Around("execution(public * org.example.service.MailService.*(..))")
//    public Object LogMail(ProceedingJoinPoint pjp) throws Throwable {
//        System.out.println("around start"+pjp.getSignature());
//        Object ret=pjp.proceed();//这个异常可以关注一下
//        System.out.println("Around done"+pjp.getSignature());
//        return ret;
//    }

    @Around("@annotation(testAnno)")
    public void logTimeMessage(ProceedingJoinPoint pjp,TestAnno testAnno) throws Throwable {
            //统计程序开始和结束的时间
        long start = System.currentTimeMillis();
        pjp.proceed();
        long end = System.currentTimeMillis();
        System.out.println(testAnno.value()+"has done!Spent"+(end-start)+"!");
    }
}
