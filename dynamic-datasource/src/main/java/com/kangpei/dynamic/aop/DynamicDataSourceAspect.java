package com.kangpei.dynamic.aop;

import com.kangpei.dynamic.annotation.DS;
import com.kangpei.dynamic.context.DataSourceContextHolder;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;


/**
 * description: DynamicDataSourceAspect <br>
 * date: 2020/8/18 11:19 下午 <br>
 * author: kangpei <br>
 * version: 1.0 <br>
 */
@Aspect
@Component
public class DynamicDataSourceAspect {

    @Pointcut("@annotation(com.kangpei.dynamic.annotation.DS)")
    public void dataSourcePointcut() {

    }

    @Around("dataSourcePointcut()")
    public Object around(ProceedingJoinPoint joinPoint) {

        String key = getAnnotationType(joinPoint).value();
        Object o = null;
        DataSourceContextHolder.setKey(key);
        try {
            o = joinPoint.proceed();
        } catch (Throwable e) {

        } finally {
            DataSourceContextHolder.remove();
            return o;
        }
    }


    private DS getAnnotationType(ProceedingJoinPoint joinPoint) {

        Class<?> aClass = joinPoint.getTarget().getClass();
        DS ds = aClass.getAnnotation(DS.class);

        if (ds != null) {
            return ds;
        } else {
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            return signature.getMethod().getAnnotation(DS.class);
        }
    }


}
