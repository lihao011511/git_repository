package com.usian.feign;

import com.usian.pojo.TbItem;
import com.usian.pojo.TbItemCat;
import com.usian.pojo.TbItemParam;
import com.usian.utils.PageResult;
import com.usian.vo.TbItemVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@FeignClient(value = "usian-item-service")
public interface ItemServiceFeign {

    @RequestMapping("/service/item/selectItemInfo")
    TbItem selectItemInfo(@RequestParam("itemId") Long itemId);

    @RequestMapping("/service/item/selectTbItemAllByPage")
    PageResult selectTbItemAllByPage(@RequestParam(name = "page") Integer page, @RequestParam(name = "rows") Integer rows);

    @GetMapping("/service/itemCat/selectItemCategoryByParentId")
    List<TbItemCat> selectItemCategoryByParentId(@RequestParam(name = "id") Long id);

    @GetMapping("/service/itemParam/selectItemParamByItemCatId")
    TbItemParam selectItemParamByItemCatId(@RequestParam("itemCatId") Long itemCatId);

    @RequestMapping("/service/item/insertTbItem")
    void insertTbItem(@RequestBody TbItemVo tbItemVo);

    @RequestMapping("/service/item/preUpdateItem")
    Map<String,Object> preUpdateItem(@RequestParam("itemId") Long itemId);

    @RequestMapping("/service/item/deleteItemById")
    void deleteItemById(@RequestParam("itemId") Long itemId);

    @RequestMapping("/service/item/updateTbItem")
    void updateTbItem(@RequestBody TbItemVo tbItemVo);

    @RequestMapping("/service/itemParam/selectItemParamAll")
    PageResult selectItemParamAll(@RequestParam("page") Integer page,@RequestParam("rows") Integer rows);

    @RequestMapping("/service/itemParam/insertItemParam")
    Integer insertItemParam(@RequestParam("itemCatId") Long itemCatId,@RequestParam("paramData") String paramData);
    @RequestMapping("/service/itemParam/deleteItemParamById")
    void deleteItemParamById(@RequestParam("id") Long id);
}