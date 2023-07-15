package org.acmaster.controller;

import org.acmaster.entity.Message;
import org.acmaster.entity.Page;
import org.acmaster.entity.Result;
import org.acmaster.entity.User;
import org.acmaster.service.MessageService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
// 访问目录
@RequestMapping("/message")
public class MessageController {
    @Autowired
    private MessageService messageService;

    //加入requestbody注解确保取到json中的参数
    @PostMapping("/sendMsg")
    /**
     * 后台需要接收到json格式的表单
     */
    public Result sendMsg(Message message){
        return messageService.sendMsg(message);
    }

    /**
     * 展示留言
     * @return list的tostring
     * 后面可以改成json
     */
    @GetMapping("/showMsg")
    public String showMsg(){
        return  messageService.showMsg();
    }

    @RequestMapping ("/deleteMsg")
    /**
     * 示例
     * /deleteMsg?messageId=3 删除messageId为3的留言
     */
    public Result deleteMsg(@RequestParam("messageId") Integer messageId){
        return messageService.deleteMsg(messageId);
    }

    @RequestMapping("/updateCheck")
    public Result updateCheck(@RequestParam("messageId") Integer messageId , @RequestParam("msgCheck") Integer msgCheck){
        return messageService.updateCheck(messageId,msgCheck);
    }

    @GetMapping("/all")
    public Result list(Page page, @RequestParam(value = "value", defaultValue = "") String value){
        return messageService.messageList(page,value);
    }
    @GetMapping("/page")
    public Result messagePage(Page page, @RequestParam(value="value",defaultValue = "") String value){
        return messageService.messagePage(page,value);
    }
}
