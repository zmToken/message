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

    @RequestMapping(value = "/create",method = RequestMethod.GET)
    public String create(){
        return "user/create";
    }

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public String create(User user){
        userService.create(user);
        return "user/index";
    }

}
