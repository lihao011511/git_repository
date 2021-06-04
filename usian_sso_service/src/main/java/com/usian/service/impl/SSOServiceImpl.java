package com.usian.service.impl;

import com.usian.mapper.TbUserMapper;
import com.usian.pojo.TbUser;
import com.usian.redis.RedisClient;
import com.usian.service.SSOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class SSOServiceImpl implements SSOService {
    @Autowired
    private TbUserMapper tbUserMapper;
    @Autowired
    private RedisClient redisClient;
    @Override
    public boolean checkUserInfo(String checkValue, Integer checkFlag) {
        TbUser tbUser = new TbUser();
        if (checkFlag==1){ //用户名   select * from tb_user where username=?
            tbUser.setUsername(checkValue);
        }else {
            tbUser.setPhone(checkValue);
        }
        List<TbUser> list = tbUserMapper.select(tbUser);
        if (list==null || list.size()==0){
            return true;
        }
        return false;
    }

    @Override
    public void userRegister(TbUser user) {
        user.setPassword(MD5Utils.digest(user.getPassword()));
        user.setCreated(new Date());
        tbUserMapper.insert(user);
    }

    @Override
    public Map userLogin(String username, String password) {
        HashMap map = new HashMap();
        TbUser tbUser = new TbUser();
        tbUser.setUsername(username);
        tbUser.setPassword(password);
        List<TbUser> select = tbUserMapper.select(tbUser);
        if (select!=null && select.size()>0){
            String s = UUID.randomUUID().toString();
            redisClient.set(s,select.get(0));
            map.put("s",s);
            map.put("userid",select.get(0).getId());
            map.put("username",select.get(0).getUsername());
        }
        return map;
    }
}
