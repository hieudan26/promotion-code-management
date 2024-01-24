package com.promotion.code.managment.model;

import com.promotion.code.managment.security.auditing.BaseAudit;
import lombok.*;

import jakarta.persistence.*;
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
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "USERS")
public class User extends BaseAudit {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;

	private String name;

	@Column(unique = true)
	private String username;

	private String password;

	@Column(unique = true)
	private String email;

	private boolean emailActived = true;

	private boolean accountNonExpired = true;

	private boolean accountNonLocked = true;

	private boolean credentialsNonExpired = true;

	private boolean enabled = true;

	private UserRole userRole;
}
