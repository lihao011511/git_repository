package com.usian.controller;

import com.usian.pojo.TbItemCat;
import com.usian.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.List;
@RestController
@RequestMapping("/service/itemCat")
public class ItemCatController  {

    @Autowired
    private ItemCatService itemCatService;

    @GetMapping("/selectItemCategoryByParentId")
    public List<TbItemCat> selectItemCategoryByParentId(@RequestParam(name = "id") Long id){

        return itemCatService.selectItemCategoryByParentId(id);
    }

}
