package com.usian.controller;

import com.usian.pojo.TbContentCategory;
import com.usian.service.ContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/service/contentCategory")
public class ContentCategoryController {
    @Autowired
    private ContentCategoryService contentCategoryService;

    @RequestMapping("/selectContentCategoryByParentId")//请求的路径
    public List<TbContentCategory> selectContentCategoryByParentId(@RequestParam("id") Long id){
        return this.contentCategoryService.selectContentCategoryByParentId(id);
    }
    @RequestMapping("/insertContentCategory")//请求的路径
   public void insertContentCategory(Long parentId, String name){
        contentCategoryService.insertContentCategory(parentId,name);
    }
    @RequestMapping("/deleteContentCategoryById")
    public Integer deleteContentCategoryById(Long categoryId){
        return this.contentCategoryService.deleteContentCategoryById(categoryId);
    }
}