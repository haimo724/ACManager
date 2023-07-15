package org.acmaster.service;


import org.acmaster.entity.Blog;
import org.acmaster.entity.Message;
import org.acmaster.entity.Page;
import org.acmaster.entity.Result;
import org.acmaster.mapper.MessageMapper;
import org.acmaster.utils.ValidateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {
    @Autowired
    private MessageMapper messageMapper;

    /**
     * 提交留言
     * @param message
     * @return
     */
    public Result sendMsg(Message message) {
        Result result = new Result();
        result.setCode(0);
        try {
            if(ValidateUtil.isEmpty(message.getMessageAuthorId())){
                result.setMessage("尚未登录，无法提交");
            }else if(ValidateUtil.isEmpty(message.getMessageTitle())||
                    ValidateUtil.isEmpty(message.getMessageContent())||
                    ValidateUtil.isEmpty(message.getMessageTime())){
                result.setMessage("留言标题、留言内容和留言时间不能为空");
            }else{
                messageMapper.save(message);
                result.setCode(200);
                result.setMessage("留言成功！");
            }
        } catch (Exception e) {
            result.setMessage(e.getMessage());
            result.setCode(0);
            e.printStackTrace();
        }
        return result;
    }


    public String showMsg() {
        Result result = new Result();
        List<Message> list = new ArrayList<>();
        try {
            for(int i = 1;i < Integer.MAX_VALUE ;i++) {
                if (messageMapper.queryMessageByMessageID(i) != null && messageMapper.queryMessageByMessageID(i).getIsDeleted()==0) {
                    list.add(messageMapper.queryMessageByMessageID(i));
                } else {
                    break;
                }
            }
        } catch (Exception e){
            result.setMessage(e.getMessage());
            e.printStackTrace();
        }
        return list.toString();
    }

    /**
     * 删除留言
     * @param messageId
     * @return
     */
    public Result deleteMsg(Integer messageId){
        Result result = new Result();
        try{
            if(ValidateUtil.isEmpty(messageId)){
                result.setMessage("messageId不能为空！");
            }else{
                if(ValidateUtil.isEmpty(messageMapper.queryMessageByMessageID(messageId))){
                    result.setMessage("该Id对应留言不存在！");
                }
                else{
                    messageMapper.deleteMessageById(messageId);
                    result.setMessage("删除成功");
                }
            }
        } catch (Exception e){
            result.setMessage(e.getMessage());
            result.setCode(0);
        }
        return result;
    }

    /**
     * 审核留言
     * @param messageId
     * @param msgCheck
     * @return
     */
    public Result updateCheck(Integer messageId, Integer msgCheck) {
        Result result = new Result();
        try{
            if(ValidateUtil.isEmpty(messageId)){
                result.setMessage("留言Id不能为空！");
            }else{
                if(ValidateUtil.isEmpty(messageMapper.queryMessageByMessageID(messageId))){
                    result.setMessage("该Id对应留言不存在！");
                }else{
                    messageMapper.updateById(messageId,msgCheck);
                    result.setMessage("更新成功");
                }
            }
        } catch (Exception e){
            result.setMessage(e.getMessage());
            result.setCode(0);
        }
        return result;
    }

    /**
     * 获取留言列表
     * @param page
     * @param value
     * @return
     */
    public Result messageList(Page page, @RequestParam(value = "value", defaultValue = "") String value){
        Result result=new Result();
        List<Message> messages;
        if(ValidateUtil.isEmpty(value)){
            messages=messageMapper.queryListByPage(page);
        }else{
            messages=messageMapper.queryListByPageAndSearch(page,value);
        }
        result.setData(messages);
        return result;
    }

    /**
     * 获取页面属性
     * @param page
     * @param value
     * @return
     */
    public Result messagePage(Page page, String value){
        Result result=new Result();
        /*获取总条数*/
        long count;
        if (ValidateUtil.isEmpty(value)) {
            count = messageMapper.queryCount();
        } else {
            count = messageMapper.queryCountBySearch(value);
        }
        int totalPage = (int) Math.ceil((double) count / page.getSize());
        page.setTotalPage(totalPage);
        result.setData(page);
        return result;
    }
}
