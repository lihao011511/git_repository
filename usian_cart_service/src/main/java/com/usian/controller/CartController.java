package com.usian.controller;

import com.usian.redis.RedisClient;
import com.usian.service.CartService;
import com.usian.service.impl.CartServiceImpl;
import com.usian.vo.CartTermVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/cart")
@RestController
public class CartController {

    @Autowired
    private CartService cartService;

    @RequestMapping("/addItem")
    public void addItem(@RequestParam("userId")Long userId, @RequestParam("itemId")Long itemId){
            cartService.addItem(userId,itemId);
    }

    @RequestMapping("showCart")
    public List<CartTermVO> getCart(@RequestParam("userId") Long userId){
        return cartService.getCart(userId);
    }
}
