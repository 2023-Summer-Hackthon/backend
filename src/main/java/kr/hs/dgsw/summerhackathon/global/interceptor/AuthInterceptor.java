package kr.hs.dgsw.summerhackathon.global.interceptor;

import kr.hs.dgsw.summerhackathon.domain.user.domain.User;
import kr.hs.dgsw.summerhackathon.global.annotation.AuthGuard;
import kr.hs.dgsw.summerhackathon.global.lib.JwtValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@RequiredArgsConstructor
public class AuthInterceptor implements HandlerInterceptor {

    private final JwtValidation jwtValidation;

    @Override
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler) throws Exception {

        if(!(handler instanceof HandlerMethod)) {
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        AuthGuard authGuard = handlerMethod.getMethodAnnotation(AuthGuard.class);

        if (authGuard == null) {
            return true;
        }

        String token = extract(request);

        if (token == null) {
            return true;
        }

        User user = jwtValidation.execute(token);

        request.setAttribute("user", user);

        return true;
    }

    private String extract(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if(bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.replace("Bearer ","");
        }
        return null;
    }
}
