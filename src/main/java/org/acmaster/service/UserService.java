package org.acmaster.service;

import org.acmaster.entity.Page;
import org.acmaster.entity.Result;
import org.acmaster.entity.User;
import org.acmaster.mapper.UserMapper;
import org.acmaster.utils.Md5Util;
import org.acmaster.utils.ValidateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 注册的逻辑实现
     * 注册时的信息包含：用户名、学号/工号、密码、性别、手机号和邮箱
     * @param user
     * @return
     */
    public Result register(User user){
        Result result = new Result();
        result.setCode(0);
        try {
            User userExist = userMapper.queryUserByID(user.getUserId());
            if(ValidateUtil.isEmpty(user.getUserName())){
                result.setMessage("用户名不能为空！");
            }else if(ValidateUtil.isEmpty(user.getUserId())){
                result.setMessage("学工号不能为空！");
            }else if(!ValidateUtil.isEmpty(userExist)){
                result.setMessage("账户已存在！");
            }else if(ValidateUtil.isEmpty(user.getUserPassword())){
                result.setMessage("密码不能为空！");
            }else{
                user.setUserPassword(Md5Util.code(user.getUserPassword()+"md5"));
                userMapper.save(user);
                result.setCode(200);
                result.setMessage("注册成功！");
            }
        } catch (Exception e) {
            result.setMessage("网络连接异常，请重试！");
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 登录的逻辑实现
     * 使用学号/工号和密码登录
     * @param user
     * @return
     */
    public Result login(User user) {
        Result result = new Result();
        result.setCode(0);
        try {
            if (ValidateUtil.isEmpty(user.getUserId()) ||
                    ValidateUtil.isEmpty(user.getUserPassword())) {
                result.setMessage("学工号和密码不能为空");
            } else {
                User user1 = userMapper.queryUserByID(user.getUserId());
                if (user1 == null) {
                    result.setMessage("该账号不存在，请重试！");
                } else {
                    user.setUserPassword(Md5Util.code(user.getUserPassword()+"md5"));
                    if(!user1.getUserPassword().equals(user.getUserPassword())){
                        result.setMessage("学工号或密码错误，请重试");
                    }else{
                        result.setCode(200);
                        result.setMessage("登陆成功");
                        result.setData(user1);
                    }
                }
            }
        } catch (Exception e) {
            result.setMessage("网络连接异常，请重试！");
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 管理员登录的逻辑实现
     * 使用学号/工号和密码登录
     * @param user
     * @return
     */
    public Result mlogin(User user) {
        Result result = new Result();
        result.setCode(0);
        try {
            if (ValidateUtil.isEmpty(user.getUserId()) ||
                    ValidateUtil.isEmpty(user.getUserPassword())) {
                result.setMessage("学工号和密码不能为空");
            } else {
                User user1 = userMapper.queryUserByID(user.getUserId());
                if (user1 == null) {
                    result.setMessage("该账号不存在，请重试！");
                } else {
                    user.setUserPassword(Md5Util.code(user.getUserPassword()+"md5"));
                    if(!user1.getUserPassword().equals(user.getUserPassword())){
                        result.setMessage("学工号或密码错误，请重试");
                    }else if(user1.getUserStatus()==0||user1.getUserStatus()==1){
                        result.setCode(200);
                        result.setMessage("登陆成功");
                        result.setData(user1);
                    }
                    else{
                        result.setMessage("您的身份无法登录");
                    }
                }
            }
        } catch (Exception e) {
            result.setMessage("网络连接异常，请重试！");
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 修改用户身份
     * @param user
     * @return
     */
    public Result updateUserStatus(User user){
        Result result=new Result();
        result.setCode(0);
        try{
            if(ValidateUtil.isEmpty(user.getUserId())||ValidateUtil.isEmpty(user.getUserName())){
                result.setMessage("用户姓名和学号不能为空！");
            }else if(ValidateUtil.isEmpty(userMapper.queryUserByID(user.getUserId()))){
                result.setMessage("该用户不存在！");
            }else if(!userMapper.queryUserByID(user.getUserId()).getUserName().equals(user.getUserName())){
                result.setMessage("用户学号或姓名错误！");
            }else{
                boolean b = userMapper.updateUserStatus(user);
                if (b) {
                    result.setCode(200);
                    result.setMessage("保存数据成功");
                } else {
                    result.setCode(0);
                    result.setMessage("保存数据失败,请检查提交内容");
                }
            }
        }catch (Exception e) {
            result.setMessage("网络连接异常，请重试！");
            e.printStackTrace();
        }

        return result;
    }

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    public Result updateUser(User user){
        Result result=new Result();
        try{
            if(ValidateUtil.isEmpty(user.getUserPassword())){
                result.setMessage("用户密码不能为空！");
            }else{
                if(!user.getUserPassword().equals(userMapper.queryUserByID(user.getUserId()).getUserPassword())){
                    user.setUserPassword(Md5Util.code(user.getUserPassword()+"md5"));
                }
                boolean b = userMapper.updateUser(user);
                if (b) {
                    result.setCode(200);
                    result.setMessage("保存数据成功,请重新登录！");
                } else {
                    result.setCode(0);
                    result.setMessage("保存数据失败,请检查提交内容");
                }
            }
        }catch (Exception e) {
            result.setMessage("网络连接异常，请重试！");
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 删除指定的用户
     * @param userId
     * @return
     */
    public Result delete(String userId) {
        boolean b = userMapper.deleteByUserId(userId);
        Result result = new Result();
        if (b) {
            result.setCode(200);
            result.setMessage("删除成功");
        } else {
            result.setCode(0);
            result.setMessage("删除失败，请重试");
        }

        return result;
    }

    /**
     * 通过系统分配给用户的ID来查询用户信息
     * @param userId
     * @return
     */
    public Result queryUser(String userId){
        Result result=new Result();
        User user= userMapper.queryUserByID(userId);
        if (user == null) {
            result.setCode(-1);
            result.setMessage("找不到对应的用户数据，请检查参数");
        } else {
            result.setCode(200);
            result.setMessage("查询成功");
            result.setData(user);
        }

        return result;
    }
    /**
     * 获取用户列表
     * @param page
     * @param value
     * @return
     */
    public Result userList(Page page, @RequestParam(value = "value", defaultValue = "") String value){
        Result result=new Result();
        List<User> users;
        if(ValidateUtil.isEmpty(value)){
            users=userMapper.queryListByPage(page);
        }else{
            users=userMapper.queryListByPageAndSearch(page,value);
        }
        result.setData(users);
        return result;
    }

    /**
     * 获取页面属性
     * @param page
     * @param value
     * @return
     */
    public Result userPage(Page page, String value){
        Result result=new Result();
        /*获取总条数*/
        long count;
        if (ValidateUtil.isEmpty(value)) {
            count = userMapper.queryCount();
        } else {
            count = userMapper.queryCountBySearch(value);
        }
        int totalPage = (int) Math.ceil((double) count / page.getSize());
        page.setTotalPage(totalPage);
        result.setData(page);
        return result;
    }

}
