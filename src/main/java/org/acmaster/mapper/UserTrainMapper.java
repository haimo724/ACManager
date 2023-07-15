package org.acmaster.mapper;

import org.acmaster.entity.Page;
import org.acmaster.entity.UserTrain;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserTrainMapper {

    void save(UserTrain userTrain);

    String queryUserNameById(String userId);

    double queryUserTrainTime(String userTrainTime);

    boolean deleteByUserTrainId(int userTrainId);

    void updateUserTrainStatus(String userId);

    UserTrain queryUserTrainByID(int userTrainId);

    void updateById(int userTrainId,int userTrainStatus);

    long queryCount();

    long queryCountBySearch(String value);

    List<UserTrain> queryListByPage(Page page);

    List<UserTrain> queryListByPageAndSearch(@Param("page") Page page, @Param("value") String value);

}
