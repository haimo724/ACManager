package org.acmaster.service;

import org.acmaster.entity.Page;
import org.acmaster.entity.Result;
import org.acmaster.entity.User;
import org.acmaster.entity.UserTrain;
import org.acmaster.mapper.UserTrainMapper;
import org.acmaster.utils.ValidateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class UserTrainService {

    @Autowired
    private UserTrainMapper userTrainMapper;

    /**
     * 提交训练时长
     * @param userTrain
     * @return
     */
    public Result sendUserTrain(UserTrain userTrain){
        Result result=new Result();
        result.setCode(0);
        try{
            if(ValidateUtil.isEmpty(userTrain.getUserId())){
                result.setMessage("尚未登陆，请先登录！");
            }else if(ValidateUtil.isEmpty(userTrain.getTrainTime())){
                result.setMessage("训练时长不能为空！");
            }else if(ValidateUtil.isEmpty(userTrain.getTrainDate())){
                result.setMessage("训练日期不能为空！");
            }else{
                userTrainMapper.save(userTrain);
                result.setCode(200);
                result.setMessage("上传成功！");
            }
        }catch(Exception e){
            result.setMessage("网络故障，请重试！");
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 审核训练时长
     * @param userTrainId
     * @param userTrainStatus
     * @return
     */
    public Result checkUserTrain(int userTrainId,int userTrainStatus){
        Result result=new Result();
        try{
            if(ValidateUtil.isEmpty(userTrainId)){
                result.setMessage("训练Id不能为空！");
            }else{
                if(ValidateUtil.isEmpty(userTrainMapper.queryUserTrainByID(userTrainId))){
                    result.setMessage("该Id对应训练不存在！");
                }else{
                    userTrainMapper.updateById(userTrainId,userTrainStatus);
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
     * 删除指定的用户训练信息
     * @param userTrainId
     * @return
     */
    public Result delete(int userTrainId) {
        boolean b = userTrainMapper.deleteByUserTrainId(userTrainId);
        Result result = new Result();
        if (b) {
            result.setCode(200);
            result.setMessage("删除成功");
        } else {
            result.setCode(0);
            result.setMessage("删除失败，请重试");
        }
        return result;
    }


    /**
     * 获取用户训练列表
     * @param page
     * @param value
     * @return
     */
    public Result userTrainList(Page page, @RequestParam(value = "value", defaultValue = "") String value){
        Result result=new Result();
        List<UserTrain> userTrains;
        if(ValidateUtil.isEmpty(value)){
            userTrains=userTrainMapper.queryListByPage(page);
        }else{
            userTrains=userTrainMapper.queryListByPageAndSearch(page,value);
        }
        result.setData(userTrains);
        return result;
    }

    /**
     * 获取页面属性
     * @param page
     * @param value
     * @return
     */
    public Result userTrainPage(Page page, String value){
        Result result=new Result();
        /*获取总条数*/
        long count;
        if (ValidateUtil.isEmpty(value)) {
            count = userTrainMapper.queryCount();
        } else {
            count = userTrainMapper.queryCountBySearch(value);
        }
        int totalPage = (int) Math.ceil((double) count / page.getSize());
        page.setTotalPage(totalPage);
        result.setData(page);
        return result;
    }
}
