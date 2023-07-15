package org.acmaster.mapper;

import org.acmaster.entity.Message;
import org.acmaster.entity.Page;
import org.acmaster.entity.Solution;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 与Solution有关的Mapper。
 */
@Mapper
public interface SolutionMapper {

    List<Solution> querySolutionBySolutionAuthorId(String solutionAuthorId);



    /**
     * 根据题解Id查询指定题解
     * @param solutionId
     * @return
     */
    Solution querySolutionByID(int solutionId);
    /**
     * 获取所有的通过审核的且未删除的题解。
     *
     * @return 数据库查询后的数据并包装为List<Solution>。
     */
    List<Solution> getAllCheckedSolutions();

    /**
     * 更新特定题解的点赞数。
     *
     * @param goodCount 整数类型的点赞数。
     * @param solutionId 整数类型的题解ID。
     * @return 数据库是否成功操作。
     */
    void updateGoodCount(int goodCount, int solutionId);

    /**
     * 获取个人发布的所有的未删除题解。
     *
     * @param userId 用户的Id。
     * @return 数据库查询后的数据并包装为List<Solution>。
     */
    List<Solution> querySolutionByUserId(String userId);

    /**
     * 新增一条审核中的题解。
     *
     * @param solution 题解
     * @return 数据库是否成功操作。
     */
    void applySolution(Solution solution);

    /**
     * 根据分页查询所有未删除的题解。
     *
     * @param page。
     * @return 数据库查询后的数据并包装为List<Solution>。
     */
    List<Solution> queryAllSolutionsByPage(Page page);

    /**
     * 删除特定编号的题解。
     *
     * @param solutionId 题解编号。
     * @return 数据库是否成功操作。
     */
    boolean deleteSolution(Integer solutionId);

    /**
     * 更新特定编号的审核信息。
     *
     * @param isChecked 审核状态。
     * @param solutionId 题解ID。
     * @return 数据库是否成功操作。
     */
    boolean checkSolution( int solutionId,int isChecked);

    long queryCount();

    long queryCountBySearch(String value);

    List<Solution> queryListByPage(Page page);

    List<Solution> queryListByPageAndSearch(@Param("page") Page page, @Param("value") String value);

}
