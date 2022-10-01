package org.example;

import com.alibaba.fastjson.JSONObject;
import jdk.nashorn.internal.parser.JSONParser;
import org.example.pojo.User;
import org.example.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan
@EnableAspectJAutoProxy
public class AppConfig {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService=annotationConfigApplicationContext.getBean(UserService.class);
        User user1= userService.login("libin","nihao123");

        System.out.println("user1 is"+user1.getName());

        User user2 = userService.register("ergou", "hahahaha");
        System.out.println("user2 is"+ JSONObject.toJSONString(user2));

    }
}
