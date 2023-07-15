package org.acmaster.mapper;

import org.acmaster.entity.Page;
import org.acmaster.entity.User;
import org.acmaster.entity.UserTeam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserTeamMapper {

    /**
     * 新增一条入队申请
     * @param userTeam
     */
    void addUserApply(UserTeam userTeam);

    UserTeam queryUserTeamByUTId(int userTeamId);

    UserTeam queryUserTeamByUTId1(int userTeamId);
    /**
     * 审核入队信息
     * @param userTeam
     */
    void checkUserApply(UserTeam userTeam);


    /**
     * 删除特定的入队申请
     * @param userTeamId
     */
    void deleteUserApply(int userTeamId);

    long queryCount();

    long queryCountBySearch(String value);

    List<UserTeam> queryUserTeamByTeamId(int teamId);

    List<UserTeam> queryUserTeamByUserId(String userId);

    List<UserTeam> queryListByPage(Page page);

    List<UserTeam> queryListByPageAndSearch(@Param("page") Page page, @Param("value") String value);

    List<UserTeam> queryTeamListByPage(Page page);
}
