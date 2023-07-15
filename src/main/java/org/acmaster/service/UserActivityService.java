package org.acmaster.service;

import org.acmaster.entity.Result;
import org.acmaster.entity.UserActivity;
import org.acmaster.entity.UserTeam;
import org.acmaster.mapper.ActivityMapper;
import org.acmaster.mapper.UserActivityMapper;
import org.acmaster.mapper.UserMapper;
import org.acmaster.utils.ValidateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserActivityService {

    @Autowired
    private UserActivityMapper userActivityMapper;

    @Autowired
    private ActivityMapper activityMapper;

    @Autowired
    private UserMapper userMapper;

    /**
     * 通过用户ID来查询个人申请的活动信息
     * @param activityauthorId
     * @return
     */
    public Result queryUserActivity(String activityauthorId){
        Result result=new Result();
        UserActivity userActivity = userActivityMapper.queryUserActivityByID(activityauthorId);
        if (userActivity == null) {
            result.setMessage("找不到对应的活动信息，请检查参数");
        } else {
            result.setMessage("查询成功");
            result.setData(userActivity);
        }
        return result;
    }

    public Result allUserActivity(String userId){
        Result result=new Result();
        result.setData(0);
        try{
            if(ValidateUtil.isEmpty(userId)){
                result.setMessage("尚未登录，请先登录！");
            }else{
                List<UserActivity> userActivitys=userActivityMapper.queryUserActivityByUserId(userId);
                result.setData(userActivitys);
            }
        }catch(Exception e){
            result.setMessage("网络连接异常");
            e.printStackTrace();
        }
        return result;
    }

    public Result addUserApply(UserActivity userActivity){
        Result result=new Result();
        result.setData(0);
        try{
            if(ValidateUtil.isEmpty(activityMapper.queryActivityByID(userActivity.getActivityid()))){
                result.setMessage("该活动不存在");
            }else if(ValidateUtil.isEmpty(userMapper.queryUserByID(userActivity.getUserId()))){
                result.setMessage("该用户不存在");
            }else{
                userActivityMapper.addUserApply(userActivity);
                result.setCode(200);
                result.setMessage("申请成功！");
            }
        } catch(Exception e){
            result.setMessage("网络连接异常");
            e.printStackTrace();
        }
        return result;
    }
}
