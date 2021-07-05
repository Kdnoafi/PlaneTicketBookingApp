package com.raf.user_service.mapper;

import com.raf.user_service.domain.User;
import com.raf.user_service.dto.UserCreateDto;
import com.raf.user_service.dto.UserDto;
import com.raf.user_service.repository.RoleRepository;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    private RoleRepository roleRepository;

    public UserMapper(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public UserDto userToUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setEmail(user.getEmail());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setUsername(user.getUsername());
        userDto.setPassportId(user.getPassportId());
        return userDto;
    }

    public User userCreateDtoToUser(UserCreateDto userCreateDto) {
        User user = new User();
        user.setEmail(userCreateDto.getEmail());
        user.setFirstName(userCreateDto.getFirstName());
        user.setLastName(userCreateDto.getLastName());
        user.setUsername(userCreateDto.getUsername());
        user.setPassword(userCreateDto.getPassword());
        user.setPassportId(userCreateDto.getPassportId());
        user.setRole(roleRepository.findRoleByName("ROLE_USER").get());
        user.setMilesTravelled(0);
       /* CreditCard creditCard = new CreditCard();
        creditCard.setFirstName(userCreateDto.getFirstName());
        creditCard.setLastName(userCreateDto.getLastName());
        creditCard.setCardNumber(userCreateDto.getCreditCard().getCardNumber());
        creditCard.setSecurityCode(userCreateDto.getCreditCard().getSecurityCode());
        user.setCreditCard(creditCard);*/
        return user;
    }

}
