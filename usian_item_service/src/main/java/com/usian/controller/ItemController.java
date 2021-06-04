package com.usian.controller;

import com.usian.pojo.TbItem;
import com.usian.service.ItemService;
import com.usian.utils.PageResult;
import com.usian.vo.TbItemVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/service/item")
public class ItemController {
    @Autowired
    private ItemService itemService;

    /**查询商品信息
     * 根据商品id
     * @param itemId
     * @return
     */
    @RequestMapping("/selectItemInfo")
    public TbItem selectItemInfo(Long itemId){
        return this.itemService.selectItemInfo(itemId);
    }


    @GetMapping("/selectTbItemAllByPage")
    public PageResult selectTbItemAllByPage(@RequestParam(name = "page") Integer page, @RequestParam(name = "rows") Integer rows){
        return itemService.selectTbItemAllByPage(page,rows);
    }

    @RequestMapping("/insertTbItem")
    public void insertTbItem(@RequestBody TbItemVo tbItemVo){
         itemService.insertTbItem(tbItemVo);
    }


    @RequestMapping("/updateTbItem")
    public void updateTbItem(@RequestBody TbItemVo tbItemVo){
         itemService.updateTbItem(tbItemVo);
    }


    @RequestMapping("/preUpdateItem")
    public Map<String,Object> preUpdateItem(Long itemId){
        return itemService.preUpdateItem(itemId);
    }

    @RequestMapping("deleteItemById")
    void deleteItemById(Long itemId){
        itemService.deleteItemById(itemId);
    }

}