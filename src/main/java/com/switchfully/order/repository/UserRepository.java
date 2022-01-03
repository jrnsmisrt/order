package com.switchfully.order.repository;

import com.switchfully.order.domain.user.User;
import com.switchfully.order.domain.user.UserLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /*private List<User> listOfUsers;

    public UserRepository(){
        this.listOfUsers=new ArrayList<>();
        fillRepositoryWithDummyUsers();
    }


    public User getUserById(String id) {
        for(User user : listOfUsers){
            if(Long.toString(user.getUserId()).equals(id)){
                return user;
            }

        }
        return null;
    }

    public User getCustomerById(String id){
        for(User user : listOfUsers){
            if(Long.toString(user.getUserId()).equals(id)&&user.showUserLevel()==UserLevel.CUSTOMER){
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
    }*/

}
