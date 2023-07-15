package org.acmaster.service;

import org.acmaster.entity.*;
import org.acmaster.entity.Result;
import org.acmaster.mapper.ActivityMapper;
import org.acmaster.utils.ValidateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class ActivityService {
    @Autowired
    private ActivityMapper activityMapper;


    /**
     * 展示所有审核通过的的活动
     * @return
     */
    public  Result displayActivity() {
        Result result=new Result();
        try {
            List<Activity> activitys = activityMapper.queryActivitys();
            result.setData(activitys);
        }catch (Exception e){
            result.setCode(0);
            result.setData(e);
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 获取关于指定用户的活动
     * @param activityAuthorId
     * @return
     */
    public Result allUserActivity(String activityAuthorId){
        Result result=new Result();
        result.setData(0);
        try{
            if(ValidateUtil.isEmpty(activityAuthorId)){
                result.setMessage("尚未登录，请先登录！");
            }else{
                List<Activity> activitys=activityMapper.queryActivityByActivityAuthorId(activityAuthorId);
                result.setData(activitys);
            }
        }catch(Exception e){
            result.setMessage("网络连接异常");
            e.printStackTrace();
        }
        return result;
    }


    /**
     * 更新一个活动内容
     * @param activity
     * @return
     */
    public Result updateActivity(Activity activity) {
        Result result=new Result();
        try {
            if(ValidateUtil.isEmpty(activity.getActivityAuthorId())){
                result.setMessage("尚未登录，请先登录");
            }else if(ValidateUtil.isEmpty(activity.getActivityTitle())||
                    ValidateUtil.isEmpty(activity.getActivityContent())||
                    ValidateUtil.isEmpty(activity.getActivityStart())||
                    ValidateUtil.isEmpty(activity.getActivityEnd())||
                    ValidateUtil.isEmpty(activity.getActivityCharge())){
                result.setMessage("活动标题、正文、开始时间、结束时间和负责人均不能为空！");
            }else if(activity.getActivityEnd().before(activity.getActivityStart())){
                result.setMessage("活动结束日期不能早于活动开始日期！");
            }else{
                boolean b = activityMapper.updateActivity(activity);
                if (b) {
                    result.setCode(200);
                    result.setMessage("保存数据成功");
                }else
                {
                    result.setCode(0);
                    result.setMessage("保存数据失败,请检查提交内容");
                }
            }
        }catch (Exception e){
            result.setMessage("网络连接异常，请重试！");
            e.printStackTrace();
        }
        return result;
    }


    /**
     * 删除一个活动
     * @param activityId
     * @return
     */
    public Result deleteActivity(int activityId) {
        Result result=new Result();
        try{
            if(ValidateUtil.isEmpty(activityId)){
                result.setMessage("博客Id不能为空！");
            }else{
                boolean b=activityMapper.deleteActivity(activityId);
                if (b) {
                    result.setCode(200);
                    result.setMessage("删除数据成功");
                } else {
                    result.setCode(0);
                    result.setMessage("删除数据失败,请检查提交内容");
                }
            }
        }catch (Exception e){
            result.setMessage("error");
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 通过活动id查询活动信息
     * @param activityId
     * @return
     */
    public Result queryactivityById(int activityId) {
        Result result=new Result();
        try {
            Activity activity=activityMapper.queryActivityByID(activityId);
            result.setCode(200);
            if (activity != null) {
                result.setData(activity);
            } else {
                result.setMessage("不存在该博客");
            }
        }catch (Exception e){
            result.setCode(0);
            result.setData(e);
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 添加一个活动
     * @return
     */
    public Result addActivity(Activity activity) {
        Result result=new Result();
        try {
            if(ValidateUtil.isEmpty(activity.getActivityAuthorId())){
                result.setMessage("尚未登录，请先登录");
            }else if(ValidateUtil.isEmpty(activity.getActivityTitle())||
                    ValidateUtil.isEmpty(activity.getActivityContent())||
                    ValidateUtil.isEmpty(activity.getActivityStart())||
                    ValidateUtil.isEmpty(activity.getActivityEnd())||
                    ValidateUtil.isEmpty(activity.getActivityCharge())){
                result.setMessage("活动标题、正文、开始时间、结束时间和负责人均不能为空！");
            }else if(activity.getActivityEnd().before(activity.getActivityStart())){
                result.setMessage("活动结束日期不能早于活动开始日期！");
            }else{
                activityMapper.addActivity(activity);
                result.setCode(200);
                result.setMessage("提交成功！");
            }
        }catch (Exception e){
            result.setMessage("网络连接异常，请重试！");
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 审核活动
     * @param activityId
     * @param isChecked
     * @return
     */
    public Result checkActivity(int activityId,int isChecked){
        Result result = new Result();
        try{
            if(ValidateUtil.isEmpty(activityId)){
                result.setMessage("博客Id不能为空！");
            }else{
                if(ValidateUtil.isEmpty(activityMapper.queryActivityByID(activityId))){
                    result.setMessage("该Id对应博客不存在！");
                }else{
                    activityMapper.updateById(activityId,isChecked);
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
     * 获取活动列表
     * @param page
     * @param value
     * @return
     */
    public Result activityList(Page page, @RequestParam(value = "value", defaultValue = "") String value){
        Result result=new Result();
        List<Activity> activitys;
        if(ValidateUtil.isEmpty(value)){
            activitys=activityMapper.queryListByPage(page);
        }else{
            activitys=activityMapper.queryListByPageAndSearch(page,value);
        }
        result.setData(activitys);
        return result;
    }

    /**
     * 获取活动列表
     * @param page
     * @param value
     * @return
     */
    public Result activityList1(Page page, @RequestParam(value = "value", defaultValue = "") String value){
        Result result=new Result();
        List<Activity> activitys;
        if(ValidateUtil.isEmpty(value)){
            activitys=activityMapper.queryListByPage1(page);
        }else{
            activitys=activityMapper.queryListByPageAndSearch(page,value);
        }
        result.setData(activitys);
        return result;
    }

    /**
     * 获取页面属性
     * @param page
     * @param value
     * @return
     */
    public Result activityPage(Page page, String value){
        Result result=new Result();
        /*获取总条数*/
        long count;
        if (ValidateUtil.isEmpty(value)) {
            count = activityMapper.queryCount();
        } else {
            count = activityMapper.queryCountBySearch(value);
        }
        int totalPage = (int) Math.ceil((double) count / page.getSize());
        page.setTotalPage(totalPage);
        result.setData(page);
        return result;
    }
}

