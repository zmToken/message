package com.message.web.message;

import com.message.entity.message.Comment;
import com.message.service.message.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author Alcott Hawk
 * @Date 3/1/2017
 */
@Controller
@RequestMapping(value = "/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public List<Comment> list(String id){
        return commentService.list(id);
    }

    @RequestMapping(value = "/publish", method = RequestMethod.POST)
    public String publish(Comment comment){
        if (commentService.create(comment)){
            return "";
        }
        return  "";
    }

    @RequestMapping(value = "/agree", method = RequestMethod.GET)
    public boolean agree(String id){
        if (commentService.agree(id)){
            return true;
        }
        return false;
    }

    @RequestMapping(value = "/disagree", method = RequestMethod.GET)
    public boolean disagree(String id){
        if (commentService.disagree(id)){
            return true;
        }
        return false;
    }

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public boolean show(String id){
        if (commentService.show(id)){
            return true;
        }
        return false;
    }

    @RequestMapping(value = "/disableShow", method = RequestMethod.GET)
    public boolean disableShow(String id){
        if (commentService.disableShow(id)){
            return true;
        }
        return false;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public boolean delete(String id){
        if (commentService.delete(id)){
            return true;
        }
        return false;
    }

}
