package com.Narainox.demo;

import org.springframework.stereotype.Service;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

@Service
public class DbUser {
    private List<User> userList=new ArrayList<>();
    public DbUser()
    {
        userList.add(new User(1,"Ayush",30));
        userList.add(new User(2,"Abhay",40));
        userList.add(new User(3,"Aditi",20));
    }
    public List<User> getAllUser()
    {
        return userList;
    }

    public User getUser(int id)
    {
        for (User u:userList) {
            if (u.getId()==id)
            {
                return u;
            }
        }
        return null;
    }
    public String createUser(User user)
    {
        User user1=new User(user.getId(),user.getName(),user.getAge());
        userList.add(user1);
        return "User created Successfully!";
    }
    public String deleteUser(int id)
    {
        for (User u:userList) {
            if (u.getId()==id)
            {
                userList.remove(id);
            }
        }
        return "User deleted Successfully!";
    }

    public String getUserByName(int age) {
        for(User user:userList)
        {
            if (user.getAge()==age)
            {
                return "Found";
            }
        }
        return "Not Found";
    }

    public User updateUserById(User user,int id) {
        for (User u :userList) {
            if (u.getId()==id)
            {
                u=new User(user.getName(), user.getAge());
                userList.add(id,u);
                return u;
            }
        }
        return null;
    }
}
