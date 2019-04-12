package com.multipart.multipartdatasource.aspect;

import com.multipart.multipartdatasource.config.DBContextHolder;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DataSourceAop {

    @Pointcut("!@annotation(com.multipart.multipartdatasource.annotation.Master) " +
            "&& (execution(* com.multipart.multipartdatasource.service..*.select*(..)) " +
            "|| execution(* com.multipart.multipartdatasource.service..*.get*(..)))")
    public void readPointcut() {

    }

    @Pointcut("@annotation(com.multipart.multipartdatasource.annotation.Master) " +
            "|| execution(* com.multipart.multipartdatasource.service..*.insert*(..)) " +
            "|| execution(* com.multipart.multipartdatasource.service..*.add*(..)) " +
            "|| execution(* com.multipart.multipartdatasource.service..*.update*(..)) " +
            "|| execution(* com.multipart.multipartdatasource.service..*.edit*(..)) " +
            "|| execution(* com.multipart.multipartdatasource.service..*.delete*(..)) " +
            "|| execution(* com.multipart.multipartdatasource.service..*.remove*(..))")
    public void writePointcut() {

    }

    @Before("readPointcut()")
    public void read() {
        DBContextHolder.slave();
    }

    @Before("writePointcut()")
    public void write() {
        DBContextHolder.master();
    }


    /**
     * 另一种写法：if...else...  判断哪些需要读从数据库，其余的走主数据库
     */
//    @Before("execution(* com.cjs.example.service.impl.*.*(..))")
//    public void before(JoinPoint jp) {
//        String methodName = jp.getSignature().getName();
//
//        if (StringUtils.startsWithAny(methodName, "get", "select", "find")) {
//            DBContextHolder.slave();
//        }else {
//            DBContextHolder.master();
//        }
//    }
}
