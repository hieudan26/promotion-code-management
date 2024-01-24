package com.promotion.code.managment.security.mapper;

import com.promotion.code.managment.model.User;
import com.promotion.code.managment.security.dto.AuthenticatedUserDto;
import com.promotion.code.managment.security.dto.RegistrationRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * Created on Ağustos, 2020
 *
 * @author Faruk
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

	@Mapping(target = "emailActived", constant = "true")
	@Mapping(target = "accountNonExpired", constant = "true")
	@Mapping(target = "accountNonLocked", constant = "true")
	@Mapping(target = "credentialsNonExpired", constant = "true")
	@Mapping(target = "enabled", constant = "true")
	User convertToUser(RegistrationRequest registrationRequest);

	AuthenticatedUserDto convertToAuthenticatedUserDto(User user);

	User convertToUser(AuthenticatedUserDto authenticatedUserDto);

}
