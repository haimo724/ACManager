package org.acmaster.controller;

import org.acmaster.entity.Activity;
import org.acmaster.entity.Page;
import org.acmaster.entity.Result;
import org.acmaster.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
// 访问目录
@RequestMapping("/activity")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    /**
     * 获取关于指定用户的博客
     * @param activityAuthorId
     * @return
     */
    @RequestMapping("/allUserActivity")
    public Result allUserActivity(String activityAuthorId){
        return activityService.allUserActivity(activityAuthorId);
    }


    @GetMapping ("/all")
    public Result displayActivity(){
        return activityService.displayActivity();
    }


    @RequestMapping("/update")
    public Result updateActivity(Activity activity){
        return activityService.updateActivity(activity);
    }

    @PostMapping("/add")
    public Result addActivity(Activity activity){
        return activityService.addActivity(activity);
    }

    @PostMapping ("/delete")
    public Result deleteactivity(int activityId){
        return  activityService.deleteActivity(activityId);
    }

    @RequestMapping("/check")
    public Result checkActivity(int activityId,int isChecked){
        return activityService.checkActivity(activityId,isChecked);
    }

    @GetMapping("/query")
    public Result queryActivityById(int activityId){
        return activityService.queryactivityById(activityId);
    }

    @GetMapping("/all1")
    public Result list(Page page, @RequestParam(value = "value", defaultValue = "") String value){
        return activityService.activityList(page,value);
    }
    @GetMapping("/all2")
    public Result list1(Page page, @RequestParam(value = "value", defaultValue = "") String value){
        return activityService.activityList1(page,value);
    }
    @GetMapping("/page")
    public Result activityPage(Page page, @RequestParam(value="value",defaultValue = "") String value){
        return activityService.activityPage(page,value);
    }
}

