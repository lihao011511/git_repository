package com.usian.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.usian.mapper.TbItemParamMapper;
import com.usian.pojo.TbItemParam;
import com.usian.service.ItemParamService;
import com.usian.utils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

@Service
public class ItemParamServiceImpl implements ItemParamService {
    @Autowired
    private TbItemParamMapper tbItemParamMapper;
    @Override
    public TbItemParam selectItemParamByItemCatId(Long itemCatId) {
        Example example = new Example(TbItemParam.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("itemCatId",itemCatId);
        List<TbItemParam> list = tbItemParamMapper.selectByExample(example);
        if (list != null && list.size() > 0){
            return list.get(0);
        }
        return null;
    }

    @Override
    public PageResult selectItemParamAll(Integer page, Integer rows) {
        PageHelper.startPage(page,rows);
        Example example = new Example(TbItemParam.class);
        example.setOrderByClause("updated DESC");
        List<TbItemParam> list = tbItemParamMapper.selectByExample(example);
        PageInfo<TbItemParam> pageInfo = new PageInfo<>(list);
        PageResult pageResult = new PageResult(page,pageInfo.getPages(),pageInfo.getList());
        return pageResult;
    }

    @Override
    public Integer insertItemParam(Long itemCatId, String paramData) {
        Example example = new Example(TbItemParam.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("itemCatId",itemCatId);
        System.out.println(itemCatId);
        List<TbItemParam> list = tbItemParamMapper.selectByExample(example);
        for (TbItemParam tbItemParam : list) {
            System.out.println(tbItemParam);
        }
        if(list != null && list.size()>0){
            return 0;
        }else {
            Date date = new Date();
            TbItemParam tbItemParam = new TbItemParam();
            tbItemParam.setItemCatId(itemCatId);
            tbItemParam.setParamData(paramData);
            tbItemParam.setCreated(date);
            tbItemParam.setUpdated(date);
            return tbItemParamMapper.insertSelective(tbItemParam);
        }
    }

    @Override
    public void deleteItemParamById(Long id) {
        tbItemParamMapper.deleteByPrimaryKey(id);
    }
}
