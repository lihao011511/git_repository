package com.usian.service;

import com.usian.pojo.TbItem;
import com.usian.utils.PageResult;
import com.usian.vo.TbItemVo;

import java.util.Map;

public interface ItemService {
    public TbItem selectItemInfo(Long itemId);

    PageResult selectTbItemAllByPage(Integer page, Integer rows);


    void insertTbItem(TbItemVo tbItemVo);

    Map<String, Object> preUpdateItem(Long itemId);

    void deleteItemById(Long itemId);

    void updateTbItem(TbItemVo tbItemVo);
}
