package org.acmaster.controller;

import org.acmaster.entity.Page;
import org.acmaster.entity.Result;
import org.acmaster.entity.Solution;
import org.acmaster.service.SolutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



/**
 * 与Solution有关的Controller。
 *
 */
@RestController
// 访问目录
@RequestMapping("/solution")
public class SolutionController {

    /**
     * 由SpringBoot自动封装的Service。
     */
    @Autowired
    private SolutionService solutionService;

    @RequestMapping("/allUserSolution")
    public Result allUserSolution(String solutionAuthorId){
        return solutionService.allUserSolution(solutionAuthorId);
    }

    /**
     * 获取所有的通过审核的且未删除的题解。
     *
     * @return 包含后端处理结果的Result类。
     */
    @GetMapping("/all")
    public Result getAllCheckedSolutions() {
        return solutionService.getAllCheckedSolutions();
    }

    /**
     * 更新特定题解的点赞数。
     *
     * 注意：无法保证用户传入的参数一定是整数类型，
     *      因此需要在此Controller方法中进行类型判断。
     *
     * @param goodCount 任意类型的点赞数
     * @param solutionId 任意类型的题解
     * @return 包含后端处理结果的Result类。
     */
    @PostMapping("/good")
    public Result updateGoodCount(int solutionId,int goodCount){
        return solutionService.updateGoodCount(solutionId,goodCount);
    }


    /**
     * 获取用户发布的所有题解。
     * 该题解列表包含未审核的题解。
     *
     * 注意：由于userId是String类型，
     *      因此不需要像Integer那样进行类型判断。
     *
     * @param userId 用户学工号
     * @return 包含后端处理结果的Result类。
     */
    @PostMapping("/certain")
    public Result querySolutionByUserId(@RequestParam("userId") String userId) {
        return solutionService.querySolutionByUserId(userId);
    }

    /**
     * 新增一条审核中的题解。
     *
     * @param solution 题解
     * @return 包含后端处理结果的Result类。
     */
    @PostMapping("/applysolution")
    public Result applySolution(Solution solution) {
        return solutionService.applySolution(solution);
    }

    @GetMapping("/all1")
    public Result list(Page page, @RequestParam(value = "value", defaultValue = "") String value){
        return solutionService.solutionList(page,value);
    }
    @GetMapping("/page")
    public Result messagePage(Page page, @RequestParam(value="value",defaultValue = "") String value){
        return solutionService.solutionPage(page,value);
    }

    /**
     * 删除特定编号的题解。
     *
     * @param solutionId 题解编号。
     * @return 包含后端处理结果的Result类。
     */
    @PostMapping ("/delete")
    public Result deleteSolution(int solutionId) {
        return solutionService.deleteSolution(solutionId);
    }

    /**
     * 更新特定编号的审核信息。
     *
     * @param isChecked 审核状态。
     * @param solutionId 题解ID。
     * @return 包含后端处理结果的Result类。
     */
    @RequestMapping("/check")
    public Result checkSolution(int solutionId,int isChecked) {
        return solutionService.checkSolution(solutionId,isChecked);
    }

}