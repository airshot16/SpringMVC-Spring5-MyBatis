package com.spring.Aspect;

import com.spring.annotaion.LoginCheck;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 切面类
 * 各个方法(通知)执行顺序 Around中的的pjp.proceed()之前的代码块 -> doBefore -> Around中pjp.proceed()之后的代码块 -> doAfter -> afterReturn
 */
@Aspect
@Component
@Scope("prototype")
public class AspectCheckLogin2 {
    @Before("execution(* com.spring.controller.*.*(..))")
    public Object doBefore(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        try {
            if (args.length == 1) {
                throw new RuntimeException("访问参数异常");
            }
        } catch (Exception e) {
            //扑捉到异常后 pjp.proceed(args)将args 也就是修改后的参数传给目标函数 这里的目标函数是指被切入点的函数
            //需要注意的是,如果是使用了pjp.proceed(args) 目标函数会被执行两次 正是因为这点 所以接着写了另一个具有相同功能的拦截器
            ProceedingJoinPoint pjp = (ProceedingJoinPoint) joinPoint;
            Object retVal = null;
            try {
                args[0]="error";
                retVal = pjp.proceed(args);
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
            return retVal;
        }
        return null;
    }


}
