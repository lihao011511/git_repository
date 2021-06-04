package com.usian.controller;

import com.usian.feign.ItemServiceFeign;
import com.usian.pojo.TbItem;
import com.usian.utils.PageResult;
import com.usian.utils.Result;
import com.usian.vo.TbItemVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/backend/item")
public class ItemController {
    @Autowired
    private ItemServiceFeign itemServiceFeign;

    /**
     * 查询商品基本信息
     */
    @RequestMapping("/selectItemInfo")
    public Result selectItemInfo(@RequestParam("itemId") Long itemId) {
        TbItem tbItem = null;
        try {
            tbItem = itemServiceFeign.selectItemInfo(itemId);
            return Result.ok(tbItem);
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }
    @GetMapping("/selectTbItemAllByPage")
    public Result selectTbItemAllByPage(@RequestParam(name = "page",defaultValue = "1") Integer page,@RequestParam(name = "rows",defaultValue = "2") Integer rows){
        PageResult pageResult = itemServiceFeign.selectTbItemAllByPage(page,rows);
        return Result.ok(pageResult);
    }

    @RequestMapping("/insertTbItem")
    public Result insertTbItem(TbItemVo tbItemVo){
        try {
            itemServiceFeign.insertTbItem(tbItemVo);
            return Result.ok("添加成功");
        } catch (Exception e) {
            return Result.error("添加失败");
        }
    }
    @GetMapping("/updateTbItem")
    public Result updateTbItem(TbItemVo tbItemVo){
        try {
            System.out.println("111111111111111111111111111111111");
            itemServiceFeign.updateTbItem(tbItemVo);
            return Result.ok("修改成功");
        } catch (Exception e) {
            return Result.error("修改失败");
        }
    }

    @RequestMapping("/preUpdateItem")
    public Result preUpdateItem(@RequestParam("itemId") Long itemId){
        Map<String,Object> map = itemServiceFeign.preUpdateItem(itemId);
        if(map.size()>0){
            return Result.ok(map);
        }
        return Result.error("查无结果");
    }

    @RequestMapping("/deleteItemById")
    public Result deleteItemById(@RequestParam("itemId") Long itemId){
        try {
            itemServiceFeign.deleteItemById(itemId);
            return Result.ok("删除成功");
        } catch (Exception e) {
            return Result.error("删除失败");
        }
    }



}