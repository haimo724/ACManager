package org.acmaster.service;

import org.acmaster.entity.Page;
import org.acmaster.entity.Result;
import org.acmaster.entity.Team;
import org.acmaster.mapper.TeamMapper;
import org.acmaster.mapper.UserMapper;
import org.acmaster.utils.ValidateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author 王海涵
 */
@Service
public class TeamService {

    @Autowired
    private TeamMapper teamMapper;
    @Autowired
    private UserMapper userMapper;

    /**
     * 创建队伍
     * @param team
     * @return
     */
    public Result buildTeam(Team team){
        Result result=new Result();
        result.setCode(0);
        try{
            if(ValidateUtil.isEmpty(team.getTeamName())){
                result.setMessage("队名不能为空");
            }else if(ValidateUtil.isEmpty(team.getTeamTime())){
                result.setMessage("时间不能为空");
            }else if(ValidateUtil.isEmpty(team.getTeamIntro())){
                result.setMessage("队伍介绍不能为空");
            }else if(ValidateUtil.isEmpty(team.getTeamCaptain())){
                result.setMessage("队长不能为空");
            }else if(ValidateUtil.isEmpty(userMapper.queryUserByID(team.getTeamCaptain()))){
                result.setMessage("该队长不存在！");
            }else if(!ValidateUtil.isEmpty(teamMapper.queryTeamByName(team.getTeamName()))){
                result.setMessage("该队名已存在！");
            }
            else {
                teamMapper.saveTeam(team);
                result.setCode(200);
                result.setMessage("队伍创建成功");
            }
        }catch (Exception e) {
            result.setMessage(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public Result myteam(String teamCaptain){
        Result result=new Result();
        try{
            if(ValidateUtil.isEmpty(userMapper.queryUserByID(teamCaptain))){
                result.setMessage("请先登录！");
            }else if(userMapper.queryUserByID(teamCaptain).getUserStatus()!=6){
                result.setMessage("身份不符！");
            }else{
                result.setData(teamMapper.queryTeamByTeamCaptain(teamCaptain));
            }
        }catch (Exception e) {
            result.setMessage(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 修改队伍信息
     * @param team
     * @return
     */
    public Result updateTeam(Team team){
        Result result=new Result();
        try{
            if(ValidateUtil.isEmpty(team.getTeamName())){
                result.setMessage("队名不能为空");
            }else if(ValidateUtil.isEmpty(team.getTeamTime())){
                result.setMessage("时间不能为空");
            }else if(ValidateUtil.isEmpty(team.getTeamIntro())){
                result.setMessage("队伍介绍不能为空");
            }else if(ValidateUtil.isEmpty(team.getTeamCaptain())){
                result.setMessage("队长不能为空");
            }else if(ValidateUtil.isEmpty(userMapper.queryUserByID(team.getTeamCaptain()))){
                result.setMessage("该队长不存在！");
            }else if(!ValidateUtil.isEmpty(teamMapper.queryTeamByName(team.getTeamName()))&&
            team.getTeamId()!=(teamMapper.queryTeamByName(team.getTeamName())).getTeamId()){
                result.setMessage("该队名已存在！");
            }else{
                boolean b = teamMapper.updateTeam(team);
                if(b){
                    result.setCode(200);
                    result.setMessage("修改成功");
                }else{
                    result.setCode(0);
                    result.setMessage("保存数据失败,请检查提交内容");
                }
            }
        }catch (Exception e) {
            result.setMessage("网络连接异常，请重试！");
            e.printStackTrace();
        }
        return result;
    }
    /**
     * 删除指定的队伍
     * @param teamId
     * @return
     */
    public Result delete(int teamId) {
        boolean b = teamMapper.deleteByTeamId(teamId);
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
     * 获取队伍总数
     * @return
     */
    public Result getNumOfTeams(){
        Result result=new Result();
        result.setData(teamMapper.queryCount());
        return result;
    }

    /**
     * 通过队伍id查找队伍
     * @param teamId
     * @return
     */
    public Result queryTeam(int teamId){
        Result result=new Result();
        Team team= teamMapper.queryTeamByID(teamId);
        if (team == null) {
            result.setCode(0);
            result.setMessage("找不到对应的队伍数据，请检查参数");
        } else {
            result.setCode(200);
            result.setMessage("查询成功");
            result.setData(team);
        }

        return result;
    }

    /**
     * 获取所有队伍
     * @return
     */
    public Result allTeams(){
        Result result=new Result();
        List<Team> teams;
        teams=teamMapper.queryAll();
        result.setData(teams);
        return result;
    }

    /**
     * 获取列表
     * @param page
     * @param value
     * @return
     */
    public Result teamList(Page page, @RequestParam(value = "value", defaultValue = "") String value){
        Result result=new Result();
        List<Team> teams;
        if(ValidateUtil.isEmpty(value)){
            teams=teamMapper.queryListByPage(page);
        }else{
            teams=teamMapper.queryListByPageAndSearch(page,value);
        }
        result.setData(teams);
        return result;
    }

    /**
     * 获取页面属性
     * @param page
     * @param value
     * @return
     */
    public Result teamPage(Page page, String value){
        Result result=new Result();
        /*获取总条数*/
        long count;
        if (ValidateUtil.isEmpty(value)) {
            count = teamMapper.queryCount();
        } else {
            count = teamMapper.queryCountBySearch(value);
        }
        int totalPage = (int) Math.ceil((double) count / page.getSize());
        page.setTotalPage(totalPage);
        result.setData(page);
        return result;
    }

}
