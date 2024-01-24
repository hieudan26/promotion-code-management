package com.promotion.code.managment.security.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.promotion.code.managment.exceptions.ApiExceptionResponse;
import org.springframework.boot.json.JsonParser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 * Created on Ağustos, 2020
 *
 * @author Faruk
 */
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
		ApiExceptionResponse res = new ApiExceptionResponse(authException.getMessage(), HttpStatus.UNAUTHORIZED, LocalDateTime.now().toString());
		response.setStatus(HttpStatus.UNAUTHORIZED.value());
		response.setHeader("Content-Type", "application/json");
		Gson gson = new Gson();
		response.getWriter().write(gson.toJson(res));
	}

}
