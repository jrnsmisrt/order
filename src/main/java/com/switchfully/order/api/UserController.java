package com.switchfully.order.api;

import com.switchfully.order.api.mapper.UserMapper;
import com.switchfully.order.domain.user.User;
import com.switchfully.order.domain.user.UserDto;
import com.switchfully.order.repository.UserRepository;
import com.switchfully.order.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/users")
public class UserController {
    private UserRepository userRepository;
    private UserService userService;
    private UserMapper userMapper;

    @Autowired
    public UserController(UserRepository userRepository, UserService userService, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping(produces = "application/json", path = "/{customerId}")
    @ResponseStatus(HttpStatus.OK)
    public UserDto viewOneCustomer(@PathVariable String customerId) {
        return userMapper.mapUsertoUserDto(userService.viewOneCustomer(customerId));
    }

    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<UserDto> viewAllCustomers() {

        return userService.viewAllCustomers().stream()
                .map(user -> userMapper.mapUsertoUserDto(user))
                .collect(Collectors.toList());
    }

    @GetMapping(produces="application/json", consumes="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void createCustomerAccount(@RequestBody UserDto userDto){
        User user = userMapper.mapUserDtoToUser(userDto);
        userService.createCustomerAccount(user);
    }

}
