package com.usian.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.usian.mapper.TbItemCatMapper;
import com.usian.mapper.TbItemDescMapper;
import com.usian.mapper.TbItemMapper;
import com.usian.mapper.TbItemParamItemMapper;
import com.usian.pojo.*;
import com.usian.service.ItemService;
import com.usian.utils.IDUtils;
import com.usian.utils.PageResult;
import com.usian.vo.TbItemVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private TbItemMapper tbItemMapper;

    @Autowired
    private TbItemDescMapper tbItemDescMapper;

    @Autowired
    private TbItemParamItemMapper tbItemParamItemMapper;

    @Autowired
    private TbItemCatMapper tbItemCatMapper;

    @Override
    public TbItem selectItemInfo(Long itemId) {
        return tbItemMapper.selectByPrimaryKey(itemId);
    }

    @Override
    public PageResult selectTbItemAllByPage(Integer page, Integer rows) {
        PageHelper.startPage(page,rows);
        Example example = new Example(TbItem.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("status",1);
        List<TbItem> tbItems = tbItemMapper.selectByExample(example);
        PageInfo<TbItem> pageInfo = new PageInfo<>(tbItems);
        return new PageResult(page,pageInfo.getPages(),pageInfo.getList());
    }

    @Override
    @Transactional
    public void insertTbItem(TbItemVo tbItemVo) {
        long id = IDUtils.genItemId();
        //tb_item
        Date date = new Date();
        tbItemVo.setId(id);
        tbItemVo.setStatus(1);
        tbItemVo.setCreated(date);
        tbItemVo.setUpdated(date);
        tbItemMapper.insertSelective(tbItemVo);


        //2.tb_item_desc
        TbItemDesc tbItemDesc = new TbItemDesc();
        tbItemDesc.setItemId(id);
        tbItemDesc.setItemDesc(tbItemVo.getDesc());
        tbItemDesc.setCreated(date);
        tbItemDescMapper.insertSelective(tbItemDesc);

        //3 tb_item_param_item
        TbItemParamItem tbItemParamItem = new TbItemParamItem();
        tbItemParamItem.setId(id);
        tbItemParamItem.setParamData(tbItemVo.getItemParams());
        tbItemParamItem.setCreated(date);
        tbItemParamItemMapper.insertSelective(tbItemParamItem);
    }

    @Override
    public Map<String, Object> preUpdateItem(Long itemId) {
        Map<String, Object> map = new HashMap<>();
        //根据商品 ID 查询商品
        TbItem item = tbItemMapper.selectByPrimaryKey(itemId);
        map.put("item", item);
        //根据商品 ID 查询商品描述
        TbItemDesc tbItemDesc = tbItemDescMapper.selectByPrimaryKey(itemId);
        map.put("itemDesc", tbItemDesc.getItemDesc());
        //根据商品 ID 查询商品类目
        TbItemCat itemCat = tbItemCatMapper.selectByPrimaryKey(item.getCid());
        map.put("itemCat", itemCat.getName());
        //根据商品 ID 查询商品规格信息
        Example example = new Example(TbItemParamItem.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("itemId",itemId);
        List<TbItemParamItem> list = tbItemParamItemMapper.selectByExample(example);
        if (list != null && list.size() > 0) {
            map.put("itemParamItem", list.get(0).getParamData());
        }
        return map;
    }

    @Override
    public void deleteItemById(Long itemId) {
        Date date = new Date();
        TbItem tbItem = new TbItem();
        tbItem.setId(itemId);
        tbItem.setStatus(3);
        tbItem.setUpdated(date);
        tbItemMapper.updateByPrimaryKeySelective(tbItem);
    }

    @Override
    public void updateTbItem(TbItemVo tbItemVo) {
        //tb_item
        Date date = new Date();
        tbItemVo.setStatus(1);
        tbItemVo.setUpdated(date);
        tbItemMapper.updateByPrimaryKeySelective(tbItemVo);


        if (StringUtil.isNotEmpty(tbItemVo.getDesc())){
            //2.tb_item_desc
            TbItemDesc tbItemDesc = new TbItemDesc();
            tbItemDesc.setItemId(tbItemVo.getId());
            tbItemDesc.setItemDesc(tbItemVo.getDesc());
            tbItemDesc.setUpdated(date);
            tbItemDescMapper.updateByPrimaryKeySelective(tbItemDesc);
        }

        //3 tb_item_param_item

        if (StringUtil.isNotEmpty(tbItemVo.getItemParams())){
            TbItemParamItem tbItemParamItem = new TbItemParamItem();
            tbItemParamItem.setId(tbItemVo.getId());
            tbItemParamItem.setParamData(tbItemVo.getItemParams());
            tbItemParamItem.setUpdated(date);
            tbItemParamItemMapper.updateByPrimaryKeySelective(tbItemParamItem);
        }
    }
}
