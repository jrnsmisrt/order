package com.switchfully.order.domain.user;


import java.util.UUID;

public class User {

    private final String firstName;
    private final String lastName;
    private final UUID userId;
    private UserLevel userlevel;

    public User(String firstName, String lastName, UserLevel userlevel) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userlevel = userlevel;
        this.userId=UUID.randomUUID();
    }

    public UserLevel setUserLevel(UserLevel userLevel){
        this.userlevel= userLevel;
        return this.userlevel;
    }
    public UserLevel showUserLevel(){
        return this.userlevel;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public UUID getUserId(){
        return userId;
    }

}
