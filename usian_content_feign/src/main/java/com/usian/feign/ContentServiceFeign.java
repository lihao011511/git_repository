package com.usian.feign;

import com.usian.pojo.TbItemCat;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@FeignClient(value = "usian-content-service")
public interface ContentServiceFeign {
    @RequestMapping("/service/contentCategory/selectContentCategoryByParentId")//请求的路径
    List<TbItemCat>  selectContentCategoryByParentId(@RequestParam("id") Long id);
    @PostMapping("/service/contentCategory/insertContentCategory")
    public Result insertContentCategory(@RequestParam("parentId")Long parentId,@RequestParam("name")String name);
    @PostMapping("/service/contentCategory/deleteContentCategoryById")
    public Integer deleteContentCategoryById(@RequestParam("categoryId") Long categoryId);
}
