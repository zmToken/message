package com.message.web.message;

import com.message.entity.message.Message;
import com.message.service.message.CommentService;
import com.message.service.message.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author Alcott Hawk
 * @Date 2/27/2017
 */
@Controller
@RequestMapping(value = "/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(String id,Model model){
        model.addAttribute("message",messageService.findOne(id));
        model.addAttribute("comtent",commentService.list(id));
        return "";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public List<Message> list(String id){
        return messageService.list();
    }

    @RequestMapping(value = "/publish", method = RequestMethod.POST)
    public String publish(Message message){
        if (messageService.create(message)){
            return "";
        }
        return  "";
    }

    @RequestMapping(value = "/agree", method = RequestMethod.GET)
    public boolean agree(String id){
        if (messageService.disagree(id)){
            return true;
        }
        return false;
    }

    @RequestMapping(value = "/disagree", method = RequestMethod.GET)
    public boolean disagree(String id){
        if (messageService.agree(id)){
            return true;
        }
        return false;
    }

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public boolean show(String id){
        if (messageService.show(id)){
            return true;
        }
        return false;
    }

    @RequestMapping(value = "/disableShow", method = RequestMethod.GET)
    public boolean disableShow(String id){
        if (messageService.disableShow(id)){
            return true;
        }
        return false;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public boolean delete(String id){
        if (messageService.delete(id)){
            return true;
        }
        return false;
    }

}
