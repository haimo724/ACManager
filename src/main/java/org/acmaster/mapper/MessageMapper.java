package org.acmaster.mapper;

import org.acmaster.entity.Blog;
import org.acmaster.entity.Message;
import org.acmaster.entity.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface MessageMapper {
    void save(Message message);

    Message queryMessageByMessageID(int messageID);

    void deleteMessageById(Integer messageId);

    void updateById(Integer messageId,int msgCheck);

    long queryCount();

    long queryCountBySearch(String value);

    List<Message> queryListByPage(Page page);

    List<Message> queryListByPageAndSearch(@Param("page") Page page, @Param("value") String value);
}
