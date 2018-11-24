package com.ccicnavi.bims.sso.config;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.sso.api.SSOService;
import com.ccicnavi.bims.sso.common.pojo.SSOUser;
import com.ccicnavi.bims.sso.common.result.ReturnT;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@Component
public class SSOInterceptor implements HandlerInterceptor {

    @Reference(timeout = 5000,url = "dubbo://127.0.0.1:20896")
    SSOService ssoService;

    /**
     * 预处理回调方法，实现处理器的预处理（如检查登陆），第三个参数为响应的处理器，自定义Controller
     * 返回值：true表示继续流程（如调用下一个拦截器或处理器）；false表示流程中断（如登录检查失败），不会继续调用其他的拦截器或处理器，此时我们需要通过response来产生响应；
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        PrintWriter out = null ;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");

        try{
            String path = request.getRequestURI();
            String sessionid = request.getHeader("token");
            ReturnT<SSOUser> ssoUserReturnT = ssoService.checkAccess(sessionid,path);
            if(ssoUserReturnT.getCode() == 1){

                return true;
            } else {

                out = response.getWriter();
                out.append(JSONObject.toJSONString(ssoUserReturnT, SerializerFeature.WriteNullStringAsEmpty));
                return false;
            }
        }catch (Exception e){
            e.printStackTrace();

            out = response.getWriter();
            out.append(JSONObject.toJSONString(ResultT.failure(ResultCode.SYSTEM_INNER_ERROR), SerializerFeature.WriteNullStringAsEmpty));
            return false;
        } finally {
            try {
                if(out != null){
                    out.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        /*String path = request.getRequestURI();
       System.out.println("进来了~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
       return true;*/
    }

    /**
     * 后处理回调方法，实现处理器的后处理（但在渲染视图之前），此时我们可以通过modelAndView（模型和视图对象）对模型数据进行处理或对视图进行处理，modelAndView也可能为null。
     */
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }

    /**
     * 整个请求处理完毕回调方法，即在视图渲染完毕时回调，如性能监控中我们可以在此记录结束时间并输出消耗时间，还可以进行一些资源清理，类似于try-catch-finally中的finally，但仅调用处理器执行链中
     */
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
    }


}
