package com.usian.controller;

import com.usian.SSOServiceFeign;
import com.usian.pojo.TbUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/frontend/sso")
public class SSOController {
    @Autowired
    private SSOServiceFeign ssoServiceFeign;
    @RequestMapping("checkUserInfo/{checkValue}/{checkFlag}")
    public Result checkUserInfo(@PathVariable String checkValue,@PathVariable Integer checkFlag){
        Boolean checkUserInfo=ssoServiceFeign.checkUserInfo(checkValue,checkFlag);
        if (checkUserInfo){
            return Result.ok();
        }
        return Result.ok("校验失败");
    }
    @RequestMapping("/userRegister")
    public Result userRegister(TbUser user){
         ssoServiceFeign.userRegister(user);
        return Result.ok();
    }
    public Result userLogin(@RequestParam("username") String username,@RequestParam("password") String password){
         Map userInfo= ssoServiceFeign.userLogin(username,password);
        return Result.ok(userInfo);
    }
}
