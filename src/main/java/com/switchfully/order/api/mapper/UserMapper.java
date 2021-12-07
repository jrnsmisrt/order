package com.switchfully.order.api.mapper;

import com.switchfully.order.domain.user.User;
import com.switchfully.order.domain.user.UserDto;

public class UserMapper {

    public UserDto mapUsertoUserDto(User user) {
        return new UserDto()
                .setUserId(user.getUserId())
                .changeUserLevel(user.showUserLevel())
                .changeAddress(user.getAddress())
                .changePhoneNumber(user.getPhoneNumber())
                .changeFirstName(user.getFirstName())
                .changeLastName(user.getLastName());
    }

    public User mapUserDtoToUser(UserDto userDto) {
        return new User(userDto.getFirstName(),
                userDto.getLastName(),
                userDto.showUserLevel(), userDto.getEmailAddress(),
                userDto.getAddress(),
                userDto.getPhoneNumber());
    }

}
