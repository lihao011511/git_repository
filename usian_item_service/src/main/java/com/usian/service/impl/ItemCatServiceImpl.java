package com.usian.service.impl;

import com.usian.mapper.TbItemCatMapper;
import com.usian.pojo.TbItemCat;
import com.usian.redis.RedisClient;
import com.usian.service.ItemCatService;
import com.usian.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
@Service
public class ItemCatServiceImpl implements ItemCatService {


    @Autowired
    private TbItemCatMapper tbItemCatMapper;

    @Value("${portal_catresult_redis_key}")
    private String portal_catresult_redis_key;

    @Autowired
    private RedisClient redisClient;

    @Override
    public List<TbItemCat> selectItemCategoryByParentId(Long parentId) {
//        TbItemCat tbItemCat = new TbItemCat();
//        tbItemCat.setParentId(parentId);
//        List<TbItemCat> list = tbItemCatMapper.select(tbItemCat);
//        Example example  = Example.builder(TbItemCat.class)
//                .where(Sqls.custom().andEqualTo("parentId",parentId))
//                .build();
        Example example = new Example(TbItemCat.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("parentId",parentId);
        List<TbItemCat> list = tbItemCatMapper.selectByExample(example);
        return list;
    }

    @Override
    public Result selectItemCategoryAll() {
//        //查询缓存
//        CatResult catResultRedis =
//                (CatResult)redisClient.get(PROTAL_CATRESULT_KEY);
//        if(catResultRedis!=null){
//            return catResultRedis;
//        }
//        CatResult catResult = new CatResult();
//        //查询商品分类
//        catResult.setData(getCatList(0L));
//        //添加到缓存
//        redisClient.set(portal_catresult_redis_key,catResult);
//        return catResult;
//    }
        return null;
    }
}
