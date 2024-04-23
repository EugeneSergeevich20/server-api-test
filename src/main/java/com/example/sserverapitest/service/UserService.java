package com.example.sserverapitest.service;

import com.example.sserverapitest.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private static int INIT_ID = 3;

    private List<User> userList = null;

    public UserService() {

        userList = new ArrayList<>();

        userList.add(new User(1, "Черницын Женя", 22));
        userList.add(new User(2, "Алешкова Ирина", 19));

    }

    public List<User> getUserList(){
        return userList;
    }

    public User getUserByID(int id){
        return userList.stream().filter(userID -> userID.getId() == id).findAny().get();
    }

    public void createUser(User user){
        User userNew = new User(INIT_ID++, user.getName(), user.getAge());
        userList.add(userNew);
    }
}
