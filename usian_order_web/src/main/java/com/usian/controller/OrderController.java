package com.usian.controller;

import com.usian.fegin.OrderServiceFeign;
import com.usian.pojo.TbOrder;
import com.usian.pojo.TbOrderShipping;
import com.usian.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/frontend /order/")
public class OrderController {
    @Autowired
    private OrderServiceFeign orderServiceFeign;
    @RequestMapping("/insertOrder")
    public Result insertOrder(String orderItem, TbOrder tbOrder , TbOrderShipping
            tbOrderShipping) {
        //因为一个request中只包含一个request body. 所以feign不支持多个@RequestBody。

//        OrderInfo orderInfo = new OrderInfo();
//
//        orderInfo.setOrderItem(orderItem);
//        orderInfo.setTbOrder(tbOrder);
//        orderInfo.setTbOrderShipping(tbOrderShipping);
//        Long orderId = orderServiceFeign.insertOrder(orderInfo);
//        if (orderId != null) {
//            //删除购物车
//            return Result.ok(orderId);
//        }
        return Result.error("error");
    }
}
