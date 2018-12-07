package com.amos.minimalism.log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * 切点类 
 * @author tiangai 
 * @since 2014-08-05 Pm 20:35 
 * @version 1.0 
 */  
@Aspect
@Component
public  class SystemLogAspect {  
    //注入Service用于把日志保存数据库  
//    @Resource
//     private LogService logService;
    //本地异常日志记录对象
     private  static  final Logger logger = LoggerFactory.getLogger(SystemLogAspect. class);
  
    //Service层切点  
    @Pointcut ("@annotation(com.amos.minimalism.log.SystemServiceLog)")
     public  void serviceAspect() {  
    }  
  
    //Controller层切点  
    @Pointcut("@annotation(com.amos.minimalism.log.SystemControllerLog)")
     public  void controllerAspect() {  
    }  
  
    /** 
     * 前置通知 用于拦截Controller层记录用户的操作 
     * 
     * @param joinPoint 切点 
     */  
    @Before ("controllerAspect()")
    public void doBefore(JoinPoint joinPoint) {

        try {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

            System.out.println("=====前置通知开始=====");
            String className = joinPoint.getTarget().getClass().getName();
            System.out.println("请求方法:" + (className.substring(0, className.indexOf("$")) + "." + joinPoint.getSignature().getName() + "()"));
            System.out.println("方法描述:" + getControllerMethodDescription(joinPoint));

            LocalVariableTableParameterNameDiscoverer u =
                    new LocalVariableTableParameterNameDiscoverer();

            Method[] methods = joinPoint.getTarget().getClass().getMethods();

            String[] parameterNames= new String[1];
            String methodName = joinPoint.getSignature().getName();
            for (Method method : methods) {
                if (method.getName().equals(methodName)) {
                    parameterNames = u.getParameterNames(method);

                }
            }
            Object[] args = joinPoint.getArgs();
            if (args !=  null && args.length > 0) {
                for ( int i = 0; i < args.length; i++) {
                    System.out.println("请求参数：" + parameterNames[i] + "-" + args[i]);
                }
            }

            System.out.println("这是spring aop 打印出来的日志");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }  
  
    /** 
     * 异常通知 用于拦截service层记录异常日志 
     * 
     * @param joinPoint 
     * @param e 
     */  
    @AfterThrowing (pointcut = "serviceAspect()", throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint, Throwable e) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();  

    }  
  
  
    /** 
     * 获取注解中对方法的描述信息 用于service层注解 
     * 
     * @param joinPoint 切点 
     * @return 方法描述 
     * @throws Exception 
     */  
     public  static String getServiceMthodDescription(JoinPoint joinPoint)  
             throws Exception {  
        String targetName = joinPoint.getTarget().getClass().getName();  
        String methodName = joinPoint.getSignature().getName();  
        Object[] arguments = joinPoint.getArgs();  
        Class targetClass = Class.forName(targetName);  
        Method[] methods = targetClass.getMethods();
        String description = "";  
         for (Method method : methods) {  
             if (method.getName().equals(methodName)) {  
                Class[] clazzs = method.getParameterTypes();  
                 if (clazzs.length == arguments.length) {  
                    description = method.getAnnotation(SystemServiceLog.class).description();
                     break;  
                }  
            }  
        }  
         return description;  
    }  
  
    /** 
     * 获取注解中对方法的描述信息 用于Controller层注解 
     * 
     * @param joinPoint 切点 
     * @return 方法描述 
     * @throws Exception 
     */  
     public String getControllerMethodDescription(JoinPoint joinPoint)  throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();  
        String methodName = joinPoint.getSignature().getName();  
        Object[] arguments = joinPoint.getArgs();  
        Class targetClass = Class.forName(targetName);  
        Method[] methods = targetClass.getMethods();  
        String description = "";  
         for (Method method : methods) {  
             if (method.getName().equals(methodName)) {  
                Class[] clazzs = method.getParameterTypes();  
                 if (clazzs.length == arguments.length) {  
                    description = method.getAnnotation(SystemControllerLog. class).description();  
                     break;  
                }  
            }  
        }  
         return description;  
    }  
} 