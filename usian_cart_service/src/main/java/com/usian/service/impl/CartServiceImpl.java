package com.usian.service.impl;

import com.usian.feign.ItemServiceFeign;
import com.usian.mapper.TbItemMapper;
import com.usian.pojo.TbItem;
import com.usian.redis.RedisClient;
import com.usian.service.CartService;
import com.usian.vo.CartTermVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.rowset.CachedRowSet;
import java.util.List;
import java.util.Map;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private RedisClient redisClient;
    @Autowired
    private TbItemMapper tbItemMapper;
    @Override
    public void addItem(Long userId, Long itemId) {
        Boolean exists = redisClient.exists("CART" + userId);
        if (exists){
            CartTermVO hget = (CartTermVO) redisClient.hget("CART" + userId, itemId + "");
            if (hget==null){
                redisClient.hset("CART"+userId,itemId+"",addCartTerm(itemId));
            }else{
                hget.setNum(hget.getNum()+1);
                redisClient.hset("CART"+userId,itemId+"",hget);
            }
        }else{

            redisClient.hset("CART"+userId,itemId+"",addCartTerm(itemId));
        }

    }

    @Override
    public List<CartTermVO> getCart(Long userId) {
        List list = redisClient.hgetAll("CART"+userId);
        return list;
    }


    public CartTermVO addCartTerm(Long itemId){
        TbItem tbItem = tbItemMapper.selectByPrimaryKey(itemId);
        CartTermVO cartTermVO = new CartTermVO();
        cartTermVO.setId(itemId);
        cartTermVO.setImage(tbItem.getImage());
        cartTermVO.setPrice(tbItem.getPrice());
        cartTermVO.setSellPoint(tbItem.getSellPoint());
        return  cartTermVO;

    }

}
