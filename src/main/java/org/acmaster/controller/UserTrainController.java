package org.acmaster.controller;

import org.acmaster.entity.Page;
import org.acmaster.entity.Result;
import org.acmaster.entity.UserTrain;
import org.acmaster.service.UserTrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userTrain")
public class UserTrainController {

    @Autowired
    private UserTrainService userTrainService;

    /**
     * 提交训练时长
     * @param userTrain
     * @return
     */
    @PostMapping("/add")
    public Result sendUserTrain(UserTrain userTrain){
        return userTrainService.sendUserTrain(userTrain);
    }

    /**
     * 审核训练时长
     * @param userTrainId
     * @param userTrainStatus
     * @return
     */
    @RequestMapping("/check")
    public Result checkUserTrain(int userTrainId,int userTrainStatus){
        return userTrainService.checkUserTrain(userTrainId,userTrainStatus);
    }

    /**
     * 删除指定的用户训练信息
     * @param userTrainId
     * @return
     */
    @RequestMapping("/delete")
    public Result delete(int userTrainId){
        return userTrainService.delete(userTrainId);
    }
    /**
     * 分页展示所有用户训练列表
     * @param page
     * @param value
     * @return
     */
    @GetMapping("/all")
    public Result list(Page page, @RequestParam(value = "value", defaultValue = "") String value){
        return userTrainService.userTrainList(page,value);
    }
    @GetMapping("/page")
    public Result userTrainPage(Page page, @RequestParam(value="value",defaultValue = "") String value){
        return userTrainService.userTrainPage(page,value);
    }
}
