package com.usian.controller;

import com.usian.feign.ItemServiceFeign;
import com.usian.pojo.TbItemParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/backend/itemParam")
public class ItemParamController {
    @Autowired
    private ItemServiceFeign itemServiceFeign;

    @RequestMapping("/selectItemParamByItemCatId/{itemCatId}")
    public Result selectItemParamByItemCatId(@PathVariable("itemCatId") Long itemCatId){
        try {
            TbItemParam tbItemParam = itemServiceFeign.selectItemParamByItemCatId(itemCatId);
            return Result.ok(tbItemParam);
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }


    @RequestMapping("/selectItemParamAll")
    public Result selectItemParamAll(@RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "3")Integer rows){
        try {
            PageResult pageResult = itemServiceFeign.selectItemParamAll(page,rows);
            return Result.ok(pageResult);
        } catch (Exception e) {
            return Result.error (e.getMessage());
        }
    }

    @RequestMapping("/insertItemParam")
    public Result insertItemParam(Long itemCatId,String paramData){
        Integer num = itemServiceFeign.insertItemParam(itemCatId,paramData);
        if(num==1){
            return Result.ok();
        }
        return Result.error("添加失败：该类目已有规格模板");
    }


    @RequestMapping("/deleteItemParamById")
    public Result deleteItemParamById(Long id){
        try {
            itemServiceFeign.deleteItemParamById(id);
            return Result.ok("删除成功");
        } catch (Exception e) {
            return Result.error("添加失败："+e.getMessage());
        }

    }
}
