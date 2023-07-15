package org.acmaster.controller;


import org.acmaster.entity.Result;
import org.acmaster.entity.UserActivity;
import org.acmaster.entity.UserTeam;
import org.acmaster.service.UserActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// 访问目录
@RequestMapping("/useractivity")
public class UserActivityController {

    @Autowired
    private UserActivityService userActivityService;

    @RequestMapping("/allUserActivity")
    public Result allUserActivity(String userId){
        return userActivityService.allUserActivity(userId);
    }

    @RequestMapping("/applyact")
    public Result addUserApply(UserActivity userActivity){
        return userActivityService.addUserApply(userActivity);
    }

}
