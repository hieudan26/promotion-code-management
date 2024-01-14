package com.promotion.code.managment.security.service;

import com.promotion.code.managment.model.User;
import com.promotion.code.managment.security.dto.AuthenticatedUserDto;
import com.promotion.code.managment.security.dto.RegistrationRequest;
import com.promotion.code.managment.security.dto.RegistrationResponse;

/**
 * Created on Ağustos, 2020
 *
 * @author Faruk
 */
public interface UserService {

	User findByUsername(String username);

	RegistrationResponse registration(RegistrationRequest registrationRequest);

	AuthenticatedUserDto findAuthenticatedUserByUsername(String username);

}
