package org.acmaster.mapper;

import org.acmaster.entity.Page;
import org.acmaster.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface UserMapper {

    /**
     * 通过用户姓名和学工号查找用户
     * */
    User queryUserByNameAndId(@Param("userName")String userName, @Param("userId")String useId);

    /**
     * 通过用户学工号查询用户
     * @param userId
     * @return
     */
    User queryUserByID(String userId);

    /**
     * 添加新用户
     * @param user
     */
    void save(User user);

    boolean updateUser(User user);

    boolean updateUserStatus(User user);

    boolean updateUserStatus1(String userId);

    boolean deleteByUserId(String userId);

    long queryCount();

    long queryCountBySearch(String value);

    List<User> queryListByPage(Page page);

    List<User> queryListByPageAndSearch(@Param("page") Page page, @Param("value") String value);

}
