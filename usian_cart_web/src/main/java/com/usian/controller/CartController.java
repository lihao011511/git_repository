package com.usian.controller;

import com.usian.feign.CartFeign;
import com.usian.feign.ItemServiceFeign;
import com.usian.pojo.TbItem;
import com.usian.utils.CookieUtils;
import com.usian.utils.JsonUtils;
import com.usian.utils.Result;
import com.usian.vo.CartTermVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.RecursiveTask;

@RestController
@RequestMapping("/frontend/cart")
public class CartController {
    @Autowired
    private ItemServiceFeign itemServiceFeign;

    @Autowired
    private CartFeign cartFeign;

    @RequestMapping("/addItem")
    public Result addItem(@RequestParam("userId")Long userId, @RequestParam("itemId")Long itemId, HttpServletRequest request, HttpServletResponse response){
        String cartJson = CookieUtils.getCookieValue(request, "CART", true);
        if (userId==null){
            if (cartJson==null || cartJson.equals("")){
                HashMap<Long, CartTermVO> cartmap = new HashMap<>();
                addCartTerm(itemId,cartmap);
                CookieUtils.setCookie(request,response,"CART", JsonUtils.objectToJson(cartmap),true);
            }else{
                Map<Long,CartTermVO> map = JsonUtils.jsonToMap(cartJson, CartTermVO.class);
                CartTermVO termVO = map.get(itemId);
                if (termVO==null){
                    addCartTerm(itemId,map);
                }else{
                    termVO.setNum(termVO.getNum()+1);
                }
                CookieUtils.setCookie(request,response,"CART",JsonUtils.objectToJson(map),true);
            }
        }else{
            cartFeign.addItem(userId,itemId);
        }
         return null;
    }
@RequestMapping("/showCart")
    public Result showCart (@RequestParam("userId")Long userId,HttpServletRequest request){
        if (userId==null){
            String carJson=CookieUtils.getCookieValue(request,"CART",true);
            Map<Long,CartTermVO> map = JsonUtils.jsonToMap(carJson, CartTermVO.class);
            Collection<CartTermVO> values = map.values();
            return Result.ok(values);
        }else{
            List<CartTermVO> cartTerm =cartFeign.getCart(userId);
            return Result.ok(cartTerm);
        }
    }

    //新增购物车

    public void addCartTerm(Long itemId,Map cartmap){
        TbItem tbItem = itemServiceFeign.selectItemInfo(itemId);
        CartTermVO cartTermVO = new CartTermVO();
        cartTermVO.setId(itemId);
        cartTermVO.setImage(tbItem.getImage());
        cartTermVO.setPrice(tbItem.getPrice());
        cartTermVO.setSellPoint(tbItem.getSellPoint());
        cartmap.put(itemId,cartTermVO);
    }
}
