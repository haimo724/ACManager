package org.acmaster.service;

import org.acmaster.entity.Page;
import org.acmaster.entity.Result;
import org.acmaster.entity.UserTeam;
import org.acmaster.mapper.TeamMapper;
import org.acmaster.mapper.UserMapper;
import org.acmaster.mapper.UserTeamMapper;
import org.acmaster.utils.ValidateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class UserTeamService {

    @Autowired
    public UserTeamMapper userTeamMapper;

    @Autowired
    public UserMapper userMapper;


    /**
     * 申请入队（新增一条入队申请）
     * @param userTeam
     * @return
     */
    public Result addUserApply(UserTeam userTeam){
        Result result=new Result();
        result.setData(0);
        try{
            if(ValidateUtil.isEmpty(userTeam.getTeamId())){
                result.setMessage("该队伍不存在");
            }else if(ValidateUtil.isEmpty(userTeam.getUserId())){
                result.setMessage("该用户不存在");
            }else if(userMapper.queryUserByID(userTeam.getUserId()).getUserStatus()!=7){
                result.setMessage("身份不符合！");
            }else{
                userTeamMapper.addUserApply(userTeam);
                result.setCode(200);
                result.setMessage("申请成功！");
            }
        } catch(Exception e){
            result.setMessage("网络连接异常");
            e.printStackTrace();
        }
        return result;
    }
    /**
     * 审核入队信息
     * @param userTeam
     * @return
     */
    public Result checkUserApply(UserTeam userTeam){
        Result result=new Result();
        result.setData(0);
        try{
            if(ValidateUtil.isEmpty(userTeam.getUserTeamId())||
                    ValidateUtil.isEmpty(userTeam.getUserId())){
                result.setMessage("序号和学生学号不能为空！");
            }else{
                if(ValidateUtil.isEmpty(userMapper.queryUserByID(userTeam.getUserId()))){
                    result.setMessage("该学生不存在！");
                }else if(ValidateUtil.isEmpty(userTeamMapper.queryUserTeamByUTId(userTeam.getUserTeamId()))){
                    result.setMessage("该申请不存在！");
                }else{
                    userTeamMapper.checkUserApply(userTeam);
                    userMapper.updateUserStatus1(userTeam.getUserId());
                    result.setMessage("审核通过");
                    result.setData(200);
                }
            }
        }catch(Exception e){
            result.setMessage("网络连接异常");
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 删除特定的入队申请信息
     * @param userTeam
     * @return
     */
    public Result deleteUserApply(UserTeam userTeam){
        Result result=new Result();
        result.setData(0);
        try{
            userTeamMapper.deleteUserApply(userTeam.getUserTeamId());
            result.setMessage("删除通过");
            result.setData(200);
        }catch(Exception e){
            result.setMessage("网络连接异常");
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 获取关于指定用户的入队申请
     * @param userId
     * @return
     */
    public Result allUserTeam(String userId){
        Result result=new Result();
        result.setData(0);
        try{
            if(ValidateUtil.isEmpty(userId)){
                result.setMessage("尚未登录，请先登录！");
            }else{
                List<UserTeam> userTeams=userTeamMapper.queryUserTeamByUserId(userId);
                result.setData(userTeams);
            }
        }catch(Exception e){
            result.setMessage("网络连接异常");
            e.printStackTrace();
        }
        return result;
    }


    /**
     * 获取所有用户申请列表
     * @param page
     * @param value
     * @return
     */
    public Result userTeamList(Page page, @RequestParam(value = "value", defaultValue = "") String value){
        Result result=new Result();
        List<UserTeam> userTeams;
        if(ValidateUtil.isEmpty(value)){
            userTeams=userTeamMapper.queryListByPage(page);
        }else{
            userTeams=userTeamMapper.queryListByPageAndSearch(page,value);
        }
        result.setData(userTeams);
        return result;
    }

    /**
     * 获取页面属性
     * @param page
     * @param value
     * @return
     */
    public Result userTeamPage(Page page, String value){
        Result result=new Result();
        /*获取总条数*/
        long count;
        if (ValidateUtil.isEmpty(value)) {
            count = userTeamMapper.queryCount();
        } else {
            count = userTeamMapper.queryCountBySearch(value);
        }
        int totalPage = (int) Math.ceil((double) count / page.getSize());
        page.setTotalPage(totalPage);
        result.setData(page);
        return result;
    }

    /**
     * 分页展示指定用户申请的队伍列表
     * @param page
     * @param value
     * @return
     */
    public Result theTeamList(Page page, @RequestParam(value = "value", defaultValue = "") String value){
        Result result=new Result();
        List<UserTeam> userTeams;
        if(ValidateUtil.isEmpty(value)){
            userTeams=userTeamMapper.queryTeamListByPage(page);
        }else{
            userTeams=userTeamMapper.queryListByPageAndSearch(page,value);
        }
        result.setData(userTeams);
        return result;
    }
}
