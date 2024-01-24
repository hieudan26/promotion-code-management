package com.promotion.code.managment.exceptions;

import com.promotion.code.managment.controller.RegistrationController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.security.auth.login.CredentialExpiredException;
import java.time.LocalDateTime;

/**
 * Created on Ağustos, 2020
 *
 * @author Faruk
 */
@RestControllerAdvice(basePackageClasses = RegistrationController.class)
public class RegistrationControllerAdvice {

	@ExceptionHandler(RegistrationException.class)
	ResponseEntity<ApiExceptionResponse> handleRegistrationException(RegistrationException exception) {
		final ApiExceptionResponse response = new ApiExceptionResponse(exception.getErrorMessage(), HttpStatus.BAD_REQUEST, LocalDateTime.now());
		return ResponseEntity.status(response.getStatus()).body(response);
	}

	@ExceptionHandler(AccountExpiredException.class)
	public ResponseEntity<ApiExceptionResponse> handleAccountExpiredException(AccountExpiredException exception) {
		final ApiExceptionResponse response = new ApiExceptionResponse(exception.getMessage(), HttpStatus.BAD_REQUEST, LocalDateTime.now());
		return ResponseEntity.status(response.getStatus()).body(response);
	}

	@ExceptionHandler(DisabledException.class)
	public ResponseEntity<ApiExceptionResponse> handleDisabledException(DisabledException exception) {
		final ApiExceptionResponse response = new ApiExceptionResponse(exception.getMessage(), HttpStatus.BAD_REQUEST, LocalDateTime.now());
		return ResponseEntity.status(response.getStatus()).body(response);
	}

	@ExceptionHandler(LockedException.class)
	public ResponseEntity<ApiExceptionResponse> handleLockedException(LockedException exception) {
		final ApiExceptionResponse response = new ApiExceptionResponse(exception.getMessage(), HttpStatus.BAD_REQUEST, LocalDateTime.now());
		return ResponseEntity.status(response.getStatus()).body(response);
	}

	@ExceptionHandler(CredentialExpiredException.class)
	public ResponseEntity<ApiExceptionResponse> handleCredentialExpiredException(CredentialExpiredException exception) {
		final ApiExceptionResponse response = new ApiExceptionResponse(exception.getMessage(), HttpStatus.BAD_REQUEST, LocalDateTime.now());
		return ResponseEntity.status(response.getStatus()).body(response);	}
}
