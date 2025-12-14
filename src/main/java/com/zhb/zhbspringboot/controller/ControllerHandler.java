package com.zhb.zhbspringboot.controller;

import cn.hutool.json.JSONUtil;
import com.zhb.zhbspringboot.ecology.mapper.UserInfoMapper;
import com.zhb.zhbspringboot.ecology.model.UserInfo;
import com.zhb.zhbspringboot.em.mapper.EmUserMapper;
import com.zhb.zhbspringboot.em.model.EmUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;


/**
 * Handler
 *
 * @author zhb on 2022/3/23
 */
@Controller
@RequestMapping("/test")
public class ControllerHandler {

    @Resource
    private UserInfoMapper userInfoMapper;

    @Resource
    private EmUserMapper emUserMapper;

    @RequestMapping("/ecology")
    @ResponseBody
    public String ecology(){
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(1);
        System.out.println("用户信息ecology"+JSONUtil.toJsonStr(userInfo));
        return "ecology";
    }
    @RequestMapping("/em")
    @ResponseBody
    public String em(){
        EmUser emUser = emUserMapper.selectById(1L);
        System.out.println("用户信息em"+JSONUtil.toJsonStr(emUser));
        return "em";
    }
}
