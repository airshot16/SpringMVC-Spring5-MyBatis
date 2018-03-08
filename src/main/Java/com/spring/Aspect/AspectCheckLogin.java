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
//@Aspect
@Component
@Scope("prototype")
public class AspectCheckLogin {
    String apiName = "";

    // 配置切入点 是一个表达式 可以使用【within && || ！】组合 这里表示user所有下一级类中的所有方法
    // 切入点可能是一个普通的方法，也可能是一个构造方法，也可能是读写变量的行为，方法可分为方法的执行和调用。。。
    @Pointcut("execution(* com.spring.controller.*.*(..))") // 包含所有的控制器
    //@Pointcut("@within( com.spring.annotaion.LoginCheck)")    // 包含使用LoginCheck注解的方法
    public void controllerPointCut() {
    }

    // 本方法和下面的方法都使用Advice注解，指示代码在何时执行
    // JoinPoint 包含切入点信息 需要反射访问
    // Before 表示方法执行之前
    @Before("controllerPointCut()")
    public void doBefore(JoinPoint joinPoint) {
        System.out.println("AOP doBefore Advice...");
    }

    // After表示在方法执行之后执行
    @After("controllerPointCut()")
    public void doAfter(JoinPoint joinPoint) {
        System.out.println("AOP After Advice...");
    }

    //AfterReturning表示在方法返回结果之后返回，可以访问方法的返回值,但不能修改
    @AfterReturning(pointcut = "controllerPointCut()", returning = "returnVal")
    public void afterReturn(JoinPoint joinPoint, Object returnVal) {
        // 在在这里读取注解的内容并暂存
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        LoginCheck loginCheck = method.getAnnotation(LoginCheck.class);
        apiName = loginCheck.apiName();
        System.out.println("AOP AfterReturning Advice:" + returnVal);
    }

    //AfterThrowing表示关联的方法若抛出异常则执行，可以访问该异常，并进行操作
    @AfterThrowing(pointcut = "controllerPointCut()", throwing = "error")
    public void afterThrowing(JoinPoint joinPoint, Throwable error) {
        System.out.println("AOP AfterThrowing Advice..." + error);
        System.out.println("AfterThrowing...");
    }

    //around可以读取并修改返回值
    @Around("controllerPointCut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        // 在这里修改返回值
        pjp.proceed(); // 执行被拦截的方法
        return apiName;
    }
}
