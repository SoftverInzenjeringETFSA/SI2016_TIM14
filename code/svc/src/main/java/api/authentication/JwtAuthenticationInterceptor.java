package api.authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import bll.auth.JwtService;

public class JwtAuthenticationInterceptor extends HandlerInterceptorAdapter {

	// for debug reasons, it's far easier to just not use authentication
	// after UI is built for handling expired tokens and unauthorized requests, we will use authentication all the time
	private final Boolean useAuthentication = false;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		if (!useAuthentication) {
			return true;
		}
		
		// skip authentication for login and register routes
		if (!request.getRequestURI().equals("/api/auth/login") &&
			!request.getRequestURI().equals("/api/auth/register")) {
			
			String jwt = request.getHeader("Authorization");
			
			if (request.getRequestURI().startsWith("/api/admin/")) {				
				return JwtService.verifyTokenForAdmin(jwt);
			}
			else {
				return JwtService.verifyToken(jwt);
			}
		}
		
		return true;
	}
}
