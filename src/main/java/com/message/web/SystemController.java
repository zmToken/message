package com.message.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author Alcott Hawk
 * @Date 2/24/2017
 */
@Controller
public class SystemController {

    @RequestMapping(value = "/index")
    public String index(){
        return "index";
    }

}
