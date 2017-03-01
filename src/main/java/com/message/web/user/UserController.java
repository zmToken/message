package com.message.web.user;

import com.message.entity.user.User;
import com.message.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author Alcott Hawk
 * @Date 2/24/2017
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String register(){
        return "user/create";
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String register(User user){
        userService.create(user);
        return "user/index";
    }

}
