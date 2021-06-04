package com.usian.feign;

import com.usian.vo.CartTermVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("sian-cart-service")
public interface CartFeign {

    @RequestMapping("/cart/addItem")
    public void addItem(@RequestParam("userId")Long userId, @RequestParam("itemId")Long itemId);

    @RequestMapping("cart/showCart")
    public List<CartTermVO> getCart(@RequestParam("userId") Long userId);

}
