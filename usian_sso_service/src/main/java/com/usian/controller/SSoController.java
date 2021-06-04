package com.usian.controller;

import com.usian.pojo.TbUser;
import com.usian.service.SSOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequestMapping("/service/sso")
@RestController
public class SSoController {
    @Autowired
    private SSOService ssoService;

    @RequestMapping("/checkUserInfo/{checkValue}/{checkFlag}")
    public boolean checkUserInfo(String checkValue, Integer checkFlag) {
        return ssoService.checkUserInfo(checkValue, checkFlag);
    }
    
    @RequestMapping("/userRegister")
    public void userRegister(@RequestBody TbUser user) {
          ssoService.userRegister(user);
    }
    @RequestMapping("/userRegister")
    Map userLogin(@RequestParam("username") String username,@RequestParam("password") String password){
        return ssoService.userLogin(username,password);
    }
}
