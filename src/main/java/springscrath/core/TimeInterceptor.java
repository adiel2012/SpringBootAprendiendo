/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package springscrath.core;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author adiel
 */
public class TimeInterceptor implements HandlerInterceptor {

    public TimeInterceptor() {
    }

    long time = 0;

    @Override
    public boolean preHandle(HttpServletRequest hsr, HttpServletResponse hsr1, Object o) throws Exception {
        time = System.currentTimeMillis();
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest hsr, HttpServletResponse hsr1, Object o, ModelAndView mav) throws Exception {
        System.out.println("postHandle:--------------------->   " + String.valueOf(System.currentTimeMillis() - time));
    }

    @Override
    public void afterCompletion(HttpServletRequest hsr, HttpServletResponse hsr1, Object o, Exception excptn) throws Exception {
        System.out.println("afterCompletion:--------------------->   " + String.valueOf(time - System.currentTimeMillis() - time));
    }

}
