package prevention.control.system.common.Interceptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by 董振 on 2018/1/12.
 */
public class BaseInterceptor extends HandlerInterceptorAdapter{

    //进入Handler方法之前执行
    //用于身份验证，身份授权
    //比如身份证验证，如果未成功，则不向下执行
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        return true;
    }

    //进入Handler方法之后，返回ModelAndView之前执行
    //应用场景从modelAndView出发；将公用的数据模型放到这里传到视图，也可以统一指定视图，比如菜单导航
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    }

    //执行Handler完成执行此方法
    //应用场景:统一异常处理，统一日志处理
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }
}
