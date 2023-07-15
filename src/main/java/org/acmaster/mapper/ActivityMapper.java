package org.acmaster.mapper;

import org.acmaster.entity.*;
import org.acmaster.entity.Activity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ActivityMapper {
    Activity queryActivityByID(int activityId);

    void updateById(int activityId,int isChecked);

    List<Activity> queryActivitys();

    List<Activity> queryActivityByActivityAuthorId(String activityAuthorId);


    boolean updateActivity(Activity activity);

    void addActivity(Activity activity);

    boolean deleteActivity(int activityId);

    long queryCount();

    long queryCountBySearch(String value);

    List<Activity> queryListByPage(Page page);

    List<Activity> queryListByPage1(Page page);

    List<Activity> queryListByPageAndSearch(@Param("page") Page page, @Param("value") String value);
}

