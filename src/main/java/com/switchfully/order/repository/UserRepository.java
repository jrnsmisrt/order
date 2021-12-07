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
        fillRepositoryWithDummyUsers();
    }


    public User getUserById(String id) {
        for(User user : listOfUsers){
            if(user.getUserId().toString().equals(id)){
                return user;
            }

        }
        return null;
    }

    public User getCustomerById(String id){
        for(User user : listOfUsers){
            if(user.getUserId().toString().equals(id)&&user.showUserLevel()==UserLevel.CUSTOMER){
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

    public void addUser(User user){
        listOfUsers.add(user);
    }

    private void fillRepositoryWithDummyUsers(){
        User admin = new User("The", "Administrator", "admin@order.com", "orderstreet 1, Brussels", "010");
        admin.changeUserLevel(UserLevel.ADMIN);
        User dummyCustomer1 = new User("Dummy", "Customer1", "customer1@order.com", "orderstreet 2, Brussels", "020");

    }
}
