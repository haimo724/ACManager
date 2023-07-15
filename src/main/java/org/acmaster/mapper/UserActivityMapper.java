package org.acmaster.mapper;


import org.acmaster.entity.UserActivity;
import org.acmaster.entity.UserTeam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserActivityMapper {

    UserActivity queryUserActivityByID(String userId);

    List<UserActivity> queryUserActivityByUserId(String userId);

    void addUserApply(UserActivity userActivity);
}
