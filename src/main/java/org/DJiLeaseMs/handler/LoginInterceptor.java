package org.DJiLeaseMs.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.DJiLeaseMs.common.constant.MessageConstant;
import org.DJiLeaseMs.common.result.Result;
import org.DJiLeaseMs.util.JwtUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(LoginInterceptor.class);

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.debug("处理请求拦截，验证Token");

        // 获取请求头中的 Token
        String token = request.getHeader("Authorization");
        
        // 检查 Token 是否存在
        if (token == null || token.isEmpty()) {
            log.warn("Token不存在");
            writeErrorResponse(response, Result.error(MessageConstant.TOKEN_NOT_EXIST));
            return false;
        }

        // 验证 Token 是否有效
        if (!JwtUtil.validateToken(token)) {
            log.warn("Token无效");
            writeErrorResponse(response, Result.error(MessageConstant.TOKEN_INVALID));
            return false;
        }

        // 获取用户信息并存储到请求属性中
        String username = JwtUtil.getUsernameFromToken(token);
        request.setAttribute("currentUser", username);
        log.debug("Token验证通过，用户：{}", username);

        return true;
    }

    private void writeErrorResponse(HttpServletResponse response, Result<?> result) throws Exception {
        response.setContentType("application/json;charset=UTF-8");
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResult = objectMapper.writeValueAsString(result);
        response.getWriter().write(jsonResult);
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    }
}
