/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.orz.pascal.example.aspectj;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * Slow Method Logger.
 *
 * @author koduki
 */
@Aspect
public class SlowMethodLogger {
    
    private static final long LIMIT_TIME;
    
    static {
        String limit = System.getenv("SLOW_METHOD_LIMIT");
        LIMIT_TIME = (limit == null) ? 0 : Long.parseLong(limit);
    }
    
    @Around("execution(* cn.orz.pascal.example.aspectj.*.*(..))")
    public Object logging(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        
        long start = System.nanoTime();
        try {
            return proceedingJoinPoint.proceed();
        } finally {
            long end = System.nanoTime();
            long time = end - start;
            
            if (time >= LIMIT_TIME) {
                int line = proceedingJoinPoint.getSourceLocation().getLine();
                String method = proceedingJoinPoint.getSignature().toString();
                System.out.println("SLOW_METHOD:" + method + "\tLINE:" + line + "\tTIME(ns):" + time);
            }
        }
    }
    
}
