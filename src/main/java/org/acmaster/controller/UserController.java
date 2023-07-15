package org.acmaster.controller;

import org.acmaster.entity.Page;
import org.acmaster.entity.Result;
import org.acmaster.entity.User;
import org.acmaster.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
// 访问目录
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 登录
     * @param user
     * @return
     */
    @RequestMapping("/login")
    public Result login(User user){
        return userService.login(user);

    }

    /**
     * 管理员登录
     * @param user
     * @return
     */
    @RequestMapping("/mlogin")
    public Result mlogin(User user){
        return userService.mlogin(user);
    }


    /**
     * 修改用户身份
     * @param user
     * @return
     */
    @RequestMapping("/updateUserStatus")
    public Result updateUserStatus(User user){
        return userService.updateUserStatus(user);
    }

    /**
     * 注册
     * @param user
     * @return
     */
    @PostMapping("/register")
    public Result register(User user) {
        System.out.println(user.toString());
        return userService.register(user);
    }

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    @RequestMapping("/update")
    public Result updateUser(User user){
        return userService.updateUser(user);
    }


    /**
     * 删除用户信息
     * @param userId
     * @return
     */
    @RequestMapping("/delete")
    public Result deleteUser(String userId){return userService.delete(userId);}

    /**
     * 通过用户学工号来查询用户信息
     * @param userId
     * @return
     */
    @GetMapping ("/certain")
    public Result queryUser(String userId){
        return userService.queryUser(userId);
    }

    /**
     * 分页展示所有用户列表
     * @param page
     * @param value
     * @return
     */
    @GetMapping("/all")
    public Result list(Page page, @RequestParam(value = "value", defaultValue = "") String value){
        return userService.userList(page,value);
    }
    @GetMapping("/page")
    public Result userPage(Page page, @RequestParam(value="value",defaultValue = "") String value){
        return userService.userPage(page,value);
    }

}
