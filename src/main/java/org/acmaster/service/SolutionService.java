package org.acmaster.service;

import org.acmaster.entity.*;
import org.acmaster.mapper.SolutionMapper;
import org.acmaster.utils.ValidateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 有关Solution的Service。
 */
@Service
public class SolutionService {

    /**
     * 由SpringBoot自动封装的Mapper。
     */
    @Autowired
    private SolutionMapper solutionMapper;
    public Result allUserSolution(String solutionAuthorId){
        Result result=new Result();
        result.setData(0);
        try{
            if(ValidateUtil.isEmpty(solutionAuthorId)){
                result.setMessage("尚未登录，请先登录！");
            }else{
                List<Solution> solutions=solutionMapper.querySolutionBySolutionAuthorId(solutionAuthorId);
                result.setData(solutions);
            }
        }catch(Exception e){
            result.setMessage("网络连接异常");
            e.printStackTrace();
        }
        return result;
    }



    /**
     * 获取所有的通过审核的且未删除的题解。
     *
     * @return 包含后端处理结果的Result类。
     */
    public Result getAllCheckedSolutions() {
        Result result=new Result();
        try {
            List<Solution> solutions = solutionMapper.getAllCheckedSolutions();
            result.setData(solutions);
        }catch (Exception e){
            result.setCode(0);
            result.setData(e);
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 更新特定题解的点赞数。
     *
     * @param goodCount 整数类型的点赞数。
     * @param solutionId 整数类型的题解ID。
     * @return 包含后端处理结果的Result类。
     */
    public Result updateGoodCount(int solutionId,int goodCount) {
        Result result=new Result();
        try {
            Solution solutionExit=solutionMapper.querySolutionByID(solutionId);
            if(solutionExit!=null){
                solutionExit.setGoodCount(goodCount);
                solutionMapper.updateGoodCount(solutionId,goodCount);
            }
        }catch (Exception e){
            result.setMessage("error");
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 获取用户发布的所有题解。
     *
     * @param userId 用户学工号。
     * @return 包含后端处理结果的Result类。
     */
    public Result querySolutionByUserId(String userId) {
        return new Result(solutionMapper.querySolutionByUserId(userId));
    }

    /**
     * 新增一条审核中的题解。
     *
     * @param solution 题解
     * @return 包含后端处理结果的Result类。
     */
    public Result applySolution(Solution solution) {
        Result result=new Result();
        try {
            if(ValidateUtil.isEmpty(solution.getSolutionAuthorId())){
                result.setMessage("尚未登录，请先登录");
            }else if(ValidateUtil.isEmpty(solution.getSolutionTitle())||
                    ValidateUtil.isEmpty(solution.getSolutionContent())||
                    ValidateUtil.isEmpty(solution.getSolutionTime())||
                    ValidateUtil.isEmpty(solution.getSolutionFormat())){
                result.setMessage("题解标题、正文、格式、时间均不能为空！");
            }else{
                solutionMapper.applySolution(solution);
                result.setCode(200);
                result.setMessage("提交成功！");
            }
        }catch (Exception e){
            result.setMessage("网络连接异常，请重试！");
            e.printStackTrace();
        }
        return result;
    }


    /**
     * 删除题解
     * @param solutionId
     * @return
     */
    public Result deleteSolution(int solutionId){
        Result result = new Result();
        try{
            if(ValidateUtil.isEmpty(solutionId)){
                result.setMessage("solutionId不能为空！");
            }else{
                if(ValidateUtil.isEmpty(solutionMapper.querySolutionByID(solutionId))){
                    result.setMessage("该Id对应留言不存在！");
                }
                else{
                    solutionMapper.deleteSolution(solutionId);
                    result.setMessage("删除成功");
                }
            }
        } catch (Exception e){
            result.setMessage(e.getMessage());
            result.setCode(0);
        }
        return result;
    }

    /**
     * 审核留言
     * @param solutionId
     * @param isChecked
     * @return
     */
    public Result checkSolution(int solutionId, int isChecked) {
        Result result = new Result();
        try{
            if(ValidateUtil.isEmpty(solutionId)){
                result.setMessage("题解Id不能为空！");
            }else{
                if(ValidateUtil.isEmpty(solutionMapper.querySolutionByID(solutionId))){
                    result.setMessage("该Id对应题解不存在！");
                }else{
                    solutionMapper.checkSolution(solutionId,isChecked);
                    result.setMessage("更新成功");
                }
            }
        } catch (Exception e){
            result.setMessage(e.getMessage());
            result.setCode(0);
        }
        return result;
    }

    /**
     * 获取题解列表
     * @param page
     * @param value
     * @return
     */
    public Result solutionList(Page page, @RequestParam(value = "value", defaultValue = "") String value){
        Result result=new Result();
        List<Solution> solutions;
        if(ValidateUtil.isEmpty(value)){
            solutions=solutionMapper.queryListByPage(page);
        }else{
            solutions=solutionMapper.queryListByPageAndSearch(page,value);
        }
        result.setData(solutions);
        return result;
    }

    /**
     * 获取页面属性
     * @param page
     * @param value
     * @return
     */
    public Result solutionPage(Page page, String value){
        Result result=new Result();
        /*获取总条数*/
        long count;
        if (ValidateUtil.isEmpty(value)) {
            count = solutionMapper.queryCount();
        } else {
            count = solutionMapper.queryCountBySearch(value);
        }
        int totalPage = (int) Math.ceil((double) count / page.getSize());
        page.setTotalPage(totalPage);
        result.setData(page);
        return result;
    }


}
