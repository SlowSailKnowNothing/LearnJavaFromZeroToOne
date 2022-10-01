package org.example.service;


import org.example.annotation.TestAnno;
import org.example.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
public class UserService {

    @Autowired
    MailService mailService;

    List<User> users = new ArrayList<User>(){{
        add(new User(1,"libin","nihao123"));
    }};//匿名内部类的方式初始化

    Map<Integer,User> map=new HashMap<>();

    public User login(String username, String password){
        for(User user:users){
            if(user.getName().equals(username)&&user.getPassword().equals(password)){
                mailService.sendLoginEmail();
                return user;
            }
        }
        return null;//这种地方都应该怎么处理呢？
    }

    public User getUser(int id){
        return map.getOrDefault(id,null);//这种map为空的应该如何处理呢？
    }


    public UserService(){
        for(User user:users){
            map.put(user.getId(),user);
        }
    }
    
    @TestAnno("userservice#register")
    public User register(String name,String password){
        //这个可以后面再想，用户名重复，密码重复怎么解决
        int id=users.get(users.size()-1).getId()+1;
        User user=new User(id,name,password);
        users.add(new User(id,name,password));
        map.put(id,user);
        mailService.sendRegisterEmail();
        return user;
    }






}
