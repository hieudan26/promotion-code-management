package com.promotion.code.managment.security.dto;

import com.promotion.code.managment.model.UserRole;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

/**
 * Created on Ağustos, 2020
 *
 * @author Faruk
 */
@Getter
@Setter
@NoArgsConstructor
public class AuthenticatedUserDto implements UserDetails {
	private String id;

	private String name;

	private String username;

	private String password;

	private String email;

	private boolean emailActived;
	private boolean accountNonExpired;
	private boolean accountNonLocked;
	private boolean credentialsNonExpired;
	private boolean enabled;
	private UserRole userRole;

	public Collection<? extends GrantedAuthority> getAuthorities()
	{
		return Collections.singletonList(new SimpleGrantedAuthority(userRole.name()));
	}

	@Override
	public boolean isAccountNonExpired()
	{
		return this.accountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked()
	{
		return this.accountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired()
	{
		return this.credentialsNonExpired;
	}

	@Override
	public boolean isEnabled()
	{
		return this.enabled;
	}
}
