package com.message.web.message;

import com.message.service.message.CommentService;
import com.message.service.message.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @Author Alcott Hawk
 * @Date 2/27/2017
 */
@Controller
public class MessageController {

    @Autowired
    private MessageService messageService;

    @Autowired
    private CommentService commentService;

}
