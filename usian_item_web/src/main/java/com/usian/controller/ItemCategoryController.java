package com.usian.controller;

import com.usian.feign.ItemServiceFeign;
import com.usian.pojo.TbItemCat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/backend/itemCategory")
public class ItemCategoryController {
    @Autowired
    private ItemServiceFeign itemServiceFeign;

    @RequestMapping("/selectItemCategoryByParentId")//请求的路径
    public Result selectItemCategoryByParentId(@RequestParam(name = "id",defaultValue = "0") Long id){//传入参数返回值，默认id = 0；
        try {
            List<TbItemCat> list = itemServiceFeign.selectItemCategoryByParentId(id);//调用feign接口传入id；
            return Result.ok(list);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(e.getMessage());
        }

    }
}
