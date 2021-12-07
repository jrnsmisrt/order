package com.switchfully.order.repository;

import com.switchfully.order.domain.user.User;
import com.switchfully.order.domain.user.UserLevel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserRepository {
    private List<User> listOfUsers;

    public UserRepository(){
        this.listOfUsers=new ArrayList<>();
    }


    public User getUserById(String id) {
        for(User user : listOfUsers){
            if(user.getUserId().toString().equals(id)){
                return user;
            }

        }
        return null;
    }

    public List<User> showAllUsers(){
        return listOfUsers;
    }

    public List<User> showAllCustomers(){
        return listOfUsers.stream()
                .filter(user->user.showUserLevel().equals(UserLevel.CUSTOMER))
                .collect(Collectors.toList());
    }
}
