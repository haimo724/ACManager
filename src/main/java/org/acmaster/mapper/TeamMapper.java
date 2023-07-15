package org.acmaster.mapper;


import org.acmaster.entity.Page;
import org.acmaster.entity.Team;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TeamMapper {

    Team queryTeamByID(int teamId);

    boolean updateTeam(Team team);

    boolean deleteByTeamId(int teamId);

    Team queryTeamByName(String teamName);

    Team queryTeamByTeamCaptain(String teamCaptain);

    void saveTeam(Team team);

    List<Team> queryAll();

    long queryCount();

    long queryCountBySearch(String value);

    List<Team> queryListByPage(Page page);

    List<Team> queryListByPageAndSearch(@Param("page") Page page, @Param("value") String value);
}
