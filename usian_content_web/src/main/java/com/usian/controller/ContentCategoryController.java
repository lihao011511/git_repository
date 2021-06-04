package com.usian.controller;

import com.usian.feign.ContentServiceFeign;
import com.usian.pojo.TbItemCat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/backend/content")
public class ContentCategoryController {
    @Autowired
    private ContentServiceFeign contentServiceFeign;

    @RequestMapping("/selectContentCategoryByParentId")//请求的路径
    public Result selectContentCategoryByParentId(@RequestParam(name = "id",defaultValue = "0") Long id){//传入参数返回值，默认id = 0；
        try {
            List<TbItemCat> list = contentServiceFeign.selectContentCategoryByParentId(id);//调用feign接口传入id；
            return Result.ok(list);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(e.getMessage());
        }
    }
    @RequestMapping("/insertContentCategory")
    public Result insertContentCategory(@RequestParam("parentId")Long parentId,@RequestParam("name")String name){
        contentServiceFeign.insertContentCategory(parentId,name);
        return Result.ok();
    }
    @RequestMapping("/deleteContentCategoryById")
    public Result deleteContentCategoryById(Long categoryId){
        Integer status = contentServiceFeign.deleteContentCategoryById(categoryId);
        if(status == 200){
            return Result.ok();
        }
        return Result.error("删除失败");
    }
}
