package spring4.testproject.Interceptor;

import org.springframework.http.HttpMethod;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class MemberInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        final String method = request.getMethod();
        if (method.equals(HttpMethod.PUT) || method.equals(HttpMethod.DELETE)) {
            HttpSession session = request.getSession(false); // getSession(false) 의미 알아볼 것
            if (session != null) { // session 이 존재할 경우
                Object obj = session.getAttribute("member");
                if (obj != null) // member 라는 이름을 가진 session 이 존재하는 경우
                    return true; // 특정 세션이 존재한다는 의미의 true
            }
            // session 이 존재하지 않을 경우 수행
            response.sendRedirect(request.getContextPath() + "/"); // redirect 를 통해 URI 다시 전달
            return false; // session 이 존재하지 않는다는 의미의 false
        }
        return true; // put, delete method 가 아닌 경우 true 반환
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            @Nullable ModelAndView modelAndView) throws Exception {
        // TODO Auto-generated method stub
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
            @Nullable Exception ex) throws Exception {
        // TODO Auto-generated method stub
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}