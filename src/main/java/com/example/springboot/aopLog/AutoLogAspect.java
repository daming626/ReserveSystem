package com.example.springboot.aopLog;

import com.alibaba.fastjson.JSONObject;
import com.example.springboot.bean.SysLog;
import com.example.springboot.bean.User;
import com.example.springboot.service.IUserService;
import com.example.springboot.service.SysLogService;
import com.example.springboot.utils.IpUtils;
import com.example.springboot.utils.SpringContextUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

@Aspect
@Component
public class AutoLogAspect {

    @Autowired
    private SysLogService logService;

    @Autowired
    private IUserService userService;

    //切点
    @Pointcut("@annotation(com.example.springboot.aopLog.AutoLog)")
    public void logPointCut() {

    }

    /**
     * 环绕增强
     * @param point
     * @return
     * @throws Throwable
     */
    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        long beginTime = System.currentTimeMillis();
        //执行方法
        Object result = point.proceed();
        //执行时长(毫秒)
        long time = System.currentTimeMillis() - beginTime;
        //保存日志
        saveSmsLog(point, time);
        return result;
    }

    private void saveSmsLog(ProceedingJoinPoint joinPoint, long time) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        SysLog sysLog = new SysLog();
        AutoLog syslog = method.getAnnotation(AutoLog.class);
        if(syslog != null){
            //注解上的描述,操作日志内容
            sysLog.setLog_content(syslog.value());
            sysLog.setLog_type(syslog.logType());
        }

        //请求的方法名
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();
        sysLog.setMethod(className + "." + methodName + "()");


        //设置操作类型
        if (sysLog.getLog_type() == CrcConstants.LOG_TYPE_2) {
            sysLog.setOperate_type(getOperateType(methodName, syslog.operateType()));
        }

        //请求的参数
        Object[] args = joinPoint.getArgs();
        try{
            String params = JSONObject.toJSONString(args);
            sysLog.setRequest_param(params);
        }catch (Exception e){

        }

        //获取request
        HttpServletRequest request = SpringContextUtil.getHttpServletRequest();
        //设置IP地址
        sysLog.setIp(IpUtils.getIpAddr(request));

        //获取登录用户信息，看你用的什么安全框架了，可以从安全上下文获取
        String userId = "35";
        User user = userService.getUserById(userId);
        if(user != null){
            sysLog.setUsername(user.getUsername());
            sysLog.setUserid(userId);
        }

        //耗时
        sysLog.setCost_time(time);
        sysLog.setCreate_time(new Date());
        //保存系统日志
        logService.insert(sysLog);
    }
    /**
     * 获取操作类型
     */
    private int getOperateType(String methodName,int operateType) {
        if (operateType > 0) {
            return operateType;
        }
        if (methodName.startsWith("list")) {
            return CrcConstants.OPERATE_TYPE_1;
        }
        if (methodName.startsWith("add")) {
            return CrcConstants.OPERATE_TYPE_2;
        }
        if (methodName.startsWith("edit")) {
            return CrcConstants.OPERATE_TYPE_3;
        }
        if (methodName.startsWith("delete")) {
            return CrcConstants.OPERATE_TYPE_4;
        }
        if (methodName.startsWith("import")) {
            return CrcConstants.OPERATE_TYPE_5;
        }
        if (methodName.startsWith("export")) {
            return CrcConstants.OPERATE_TYPE_6;
        }
        return CrcConstants.OPERATE_TYPE_1;
    }
}
