package com.promotion.code.managment.security.service;

import com.promotion.code.managment.model.UserRole;
import com.promotion.code.managment.security.dto.AuthenticatedUserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Created on Ağustos, 2020
 *
 * @author Faruk
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

	private static final String USERNAME_OR_PASSWORD_INVALID = "Invalid username or password.";

	private final UserService userService;
	private final AccountStatusUserDetailsChecker detailsChecker = new AccountStatusUserDetailsChecker();

	@Override
	public UserDetails loadUserByUsername(String username)
	{

		final AuthenticatedUserDto authenticatedUser = userService.findAuthenticatedUserByUsername(username);

		if (Objects.isNull(authenticatedUser))
		{
			throw new UsernameNotFoundException(USERNAME_OR_PASSWORD_INVALID);
		}
		detailsChecker.check(authenticatedUser);
		return authenticatedUser;
	}
}
