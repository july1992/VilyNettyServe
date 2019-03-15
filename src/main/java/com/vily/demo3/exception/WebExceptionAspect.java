package com.vily.demo3.exception;

import com.alibaba.fastjson.JSON;
import com.vily.demo3.util.StringUtils;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *  * description :  异常处理
 *  * Author : Vily
 *  * Date : 2019-03-15
 *  
 **/
@Aspect
@Component
public class WebExceptionAspect implements ThrowsAdvice {

    private static final Logger logger = LoggerFactory.getLogger(WebExceptionAspect.class);

    //凡是注解了RequestMapping的方法都被拦截   @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")

    private void webPointcut() {
    }
    /**
     * 拦截web层异常，记录异常日志，并返回友好信息到前端 目前只拦截Exception，是否要拦截Error需再做考虑
     *
     * @param e
     *            异常对象
     */
//    @AfterThrowing(pointcut = "webPointcut()", throwing = "e")
//    public void handleThrowing(Exception e) {
//        logger.debug("exception 来了！");
//        if(!StringUtils.isEmpty(e.getMessage())){
//            writeContent(e.getMessage());
//        }else{
//            writeContent("参数错误！");
//        }
//
//    }



    /**
     * 将内容输出到浏览器
     *
     * @param content
     *            输出内容
     */
    private void writeContent(String content) {
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getResponse();
        response.reset();
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-Type", "text/plain;charset=UTF-8");
        response.setHeader("icop-content-type", "exception");
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        writer.print(content);
        writer.flush();
        writer.close();
    }

}
