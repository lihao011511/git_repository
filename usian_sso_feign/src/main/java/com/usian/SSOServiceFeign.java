package com.usian;

import com.usian.pojo.TbUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;


@FeignClient("usian-sso-service")
public interface SSOServiceFeign {
    @RequestMapping("/service/checkUserInfo/{checkValue}/{checkFlag}")
    public boolean checkUserInfo(@PathVariable String checkValue,@PathVariable Integer checkFlag);
    @RequestMapping("/service/sso/userRegister")
    public void userRegister(@RequestBody TbUser user);

    @RequestMapping("/service/sso/userRegister")
    Map userLogin(String username, String password);

}
