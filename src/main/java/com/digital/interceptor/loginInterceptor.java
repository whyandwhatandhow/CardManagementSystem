package com.digital.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class loginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 获取Session
        HttpSession session = request.getSession();
        // 检查Session中是否存在user属性
        Object user = session.getAttribute("user");

        if (user == null) {
            // 用户未登录，重定向到登录页面
            response.sendRedirect("/user/login");
            return false; // 请求被拦截
        }
        // 用户已登录，允许请求继续执行
        return true;
    }

    // 可选：在处理器执行之后调用
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // 这里可以进行一些处理，例如日志记录等
    }

    // 可选：在整个请求完成之后调用
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // 这里可以进行一些清理工作
    }
}
