package com.eshore.wbtimer.common.aspect;

import com.eshore.wbtimer.core.biz.model.ReturnT;
import com.eshore.wbtimer.core.log.WbtimerJobLogger;
import com.eshore.wbtimer.common.exception.GlobalException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 描述:handler统一异常处理
 *
 * @author Yangjinming
 * @create 2018-01-22 11:42
 */
@Component
@Aspect
public class HandlerAspect {
    private static Logger logger = LoggerFactory.getLogger(HandlerAspect.class);
    private String className;

    @Pointcut(value = "@within(com.eshore.wbtimer.core.handler.annotation.JobHandler)")
    private void pointcut() {
    }

    @Before(value = "@within(com.eshore.wbtimer.core.handler.annotation.JobHandler)")
    public void before(JoinPoint joinPoint) {
        className = joinPoint.getTarget().getClass().getSimpleName();
        WbtimerJobLogger.log("-----------------------执行" + className + "任务开始-----------------------");
    }

    @AfterReturning(value = "pointcut()", returning = "returnObj")
    public void afterReturn(Object returnObj) {
        WbtimerJobLogger.log("-----------------------执行" + className + "任务结束-----------------------");
    }

    @AfterThrowing(value = "@within(com.eshore.wbtimer.core.handler.annotation.JobHandler)", throwing = "e")
    public void afterThrowing(Throwable e) {
        logger.error("HandlerException:", e);
    }

    @Around(value = "pointcut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object result = null;
        String msg = "";
        try {
            proceedingJoinPoint.proceed();
            result = ReturnT.SUCCESS;
            msg = "执行成功";
        } catch (GlobalException globalException) {
            msg = globalException.getMessage();
            result = ReturnT.SUCCESS;
        }catch (InterruptedException interruptedException){
            WbtimerJobLogger.log("任务被终止");
            //终止任务的异常不获取
            throw interruptedException;
        } catch (Exception e) {
            msg = e.getMessage();
            logger.error("------------------------------------------------------------------------------------------------------------");
            logger.error(className + "执行出错了，错误信息为：", e);
            logger.error("------------------------------------------------------------------------------------------------------------");
            result = ReturnT.FAIL;
        } finally {
            WbtimerJobLogger.log(msg);
        }
        return result;
    }
}
