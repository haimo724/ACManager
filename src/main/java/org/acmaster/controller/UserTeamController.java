package org.acmaster.controller;

import org.acmaster.entity.Page;
import org.acmaster.entity.Result;
import org.acmaster.entity.UserTeam;
import org.acmaster.service.UserTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userTeam")
public class UserTeamController {

    @Autowired
    private UserTeamService userTeamService;

    /**
     * 申请入队（新增一条入队申请）
     * @param userTeam
     * @return
     */
    @PostMapping("/add")
    public Result addUserApply(UserTeam userTeam){
        return userTeamService.addUserApply(userTeam);
    }

    /**
     * 审核入队信息
     * @param userTeam
     * @return
     */
    @RequestMapping("/check")
    public Result checkUserApply(UserTeam userTeam){
        return userTeamService.checkUserApply(userTeam);
    }

    /**
     * 删除特定的入队申请信息
     * @param userTeam
     * @return
     */
    @RequestMapping("/delete")
    public Result deleteUserApply(UserTeam userTeam){
        return userTeamService.deleteUserApply(userTeam);
    }

    /**
     * 获取关于指定用户的入队申请
     * @param userId
     * @return
     */
    @RequestMapping("/allUserTeam")
    public Result allUserTeam(String userId){
        return userTeamService.allUserTeam(userId);
    }

    /**
     * 分页展示所有用户入队列表
     * @param page
     * @param value
     * @return
     */
    @GetMapping("/all")
    public Result list(Page page, @RequestParam(value = "value", defaultValue = "") String value){
        return userTeamService.userTeamList(page,value);
    }
    @GetMapping("/page")
    public Result userTeamPage(Page page, @RequestParam(value="value",defaultValue = "") String value){
        return userTeamService.userTeamPage(page,value);
    }

    /**
     * 分页展示指定用户入队申请列表
     * @param page
     * @param value
     * @return
     */
    @GetMapping("/allTeamOfTheUser")
    public Result theTeamlist(Page page, @RequestParam(value = "value", defaultValue = "") String value){
        return userTeamService.theTeamList(page,value);
    }
}
