package org.acmaster.controller;

import org.acmaster.entity.Page;
import org.acmaster.entity.Result;
import org.acmaster.entity.Team;
import org.acmaster.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
// 访问目录
@RequestMapping("/teams")
public class TeamController {

    @Autowired
    private TeamService teamService;

    /**
     * 创建队伍
     * @param team
     * @return
     */
    @PostMapping("/buildteam")
    public Result buildTeam(Team team){
        return teamService.buildTeam(team);
    }

    /**
     * 队长获取自己队伍信息
     * @param teamCaptain
     * @return
     */
    @RequestMapping("/myteam")
    public Result myteam(String teamCaptain){
        return teamService.myteam(teamCaptain);
    }

    /**
     * 修改队伍信息
     * @param team
     * @return
     */
    @RequestMapping("/update")
    public Result updateTeam(Team team){
        return teamService.updateTeam(team);
    }

    /**
     * 删除指定队伍
     * @param teamId
     * @return
     */
    @RequestMapping("/delete")
    public Result deleteTeam(int teamId){return teamService.delete(teamId);}

    /**
     * 获取队伍总数
     * @return
     */
    @GetMapping("/number")
    public Result getNumOfTeams(){
        return teamService.getNumOfTeams();
    }
    /**
     * 通过队伍id查找队伍
     * @param teamId
     * @return
     */
    @RequestMapping("/certain")
    public Result queryTeam(int teamId){
        return teamService.queryTeam(teamId);
    }

    /**
     * 获取所有队伍
     * @return
     */
    @PostMapping("/allTeams")
    public Result all(){
        return teamService.allTeams();
    }

    /**
     * 查找队伍列表
     * @param page
     * @param value
     * @return
     */
    @GetMapping("/all")
    public Result list(Page page,@RequestParam(value = "value", defaultValue = "") String value){
        return teamService.teamList(page,value);
    }

    @GetMapping("/page")
    public Result teamPage(Page page, @RequestParam(value="value",defaultValue = "") String value){
        return teamService.teamPage(page,value);
    }
}
