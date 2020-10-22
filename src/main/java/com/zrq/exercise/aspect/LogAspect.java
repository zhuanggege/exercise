package com.zrq.exercise.aspect;

import com.alibaba.fastjson.JSONObject;
import com.zrq.exercise.server.PersonServer;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @Author: zrq
 * @CreateDate: 2020/10/9
 * @Version: 类说明： 实现PersonController切面控制
 */
@Aspect
@Component
@Slf4j
public class LogAspect {
    @Resource
    private PersonServer personServerImpl;

    @Pointcut("execution(public * com.zrq.exercise.controller.PersonController.news*(..))")
    public void webLog(){}

    /**
     * 定义在切入点前使用这个方法
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Before("webLog()")
    public void deBefore(JoinPoint joinPoint) throws Throwable {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 记录下请求内容
        System.out.println("URL : " + request.getRequestURL().toString());
        System.out.println("HTTP_METHOD : " + request.getMethod());
        System.out.println("IP : " + request.getRemoteAddr());
        System.out.println("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        System.out.println("ARGS : " + Arrays.toString(joinPoint.getArgs()));

        String servletPath = request.getServletPath();
//        throw new RuntimeException("登录");
//        //获取RequestAttributes
//        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
//        //获取HttpServletResponse
//        HttpServletResponse response = ((ServletRequestAttributes) requestAttributes).getResponse();
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/");
//        response.setCharacterEncoding("UTF-8");
//        response.setContentType("application/json;charset=UTF-8");
//        ServletOutputStream output = response.getOutputStream();
//        JSONObject json = new JSONObject();
//        json.put("msg","请求次数超出限制");
//        output.write("{\"msg\":\"请求次数超出限制\"}".getBytes("UTF-8"));
//        output.flush();
//        output.close();


    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public JSONObject doAfterReturning(JSONObject ret) throws Throwable {
        // 处理完请求，返回内容
        System.out.println("方法的返回值 : " + ret);
        ret.put("adf","1324688");
        return ret;
    }

    //后置异常通知
    @AfterThrowing("webLog()")
    public void throwss(JoinPoint jp){
        System.out.println("方法异常时执行.....");
    }

    //后置最终通知,final增强，不管是抛出异常或者正常退出都会执行
    @After("webLog()")
    public void after(JoinPoint jp){
        System.out.println("方法最后执行.....");
    }

    //环绕通知,环绕增强，相当于MethodInterceptor
//    @Around("webLog()")
//    public Object arround(ProceedingJoinPoint pjp) {
//        System.out.println("方法环绕start.....");
//        try {
//            Object o =  pjp.proceed();
//            System.out.println("方法环绕proceed，结果是 :" + o);
//            return o;
//        } catch (Throwable e) {
//            e.printStackTrace();
//            return null;
//        }
//    }

}
