package com.usian.service.Impl;

import com.usian.mapper.TbContentCategoryMapper;
import com.usian.pojo.TbContentCategory;
import com.usian.service.ContentCategoryService;
import jdk.nashorn.internal.runtime.FindProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;
@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {
    @Autowired
    private TbContentCategoryMapper tbContentCategoryMapper;

    @Override
    public List<TbContentCategory> selectContentCategoryByParentId(Long parentId) {
        Example example = new Example(TbContentCategory.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("parentId",parentId);
        List<TbContentCategory> list = tbContentCategoryMapper.selectByExample(example);
        return list;
    }

    @Override
    public void insertContentCategory(Long parentId, String name) {
        TbContentCategory tbContentCategory = new TbContentCategory();
        tbContentCategory.setParentId(parentId);
        tbContentCategory.setName(name);

        tbContentCategory.setStatus(1);
        tbContentCategory.setIsParent(0);
        tbContentCategory.setCreated(new Date());
        tbContentCategory.setSortOrder(1);

        tbContentCategoryMapper.insertSelective(tbContentCategory);
        TbContentCategory tbContentCategory1 = tbContentCategoryMapper.selectByPrimaryKey(parentId);
        if (tbContentCategory1.getIsParent()!=1){
            tbContentCategory1.setIsParent(1);
            tbContentCategoryMapper.updateByPrimaryKey(tbContentCategory1);
        }
    }

    @Override
    public Integer deleteContentCategoryById(Long categoryId) {
        //查询当前节点
        TbContentCategory tbContentCategory = tbContentCategoryMapper.selectByPrimaryKey(categoryId);
        //父节点 不允许删除
        if(tbContentCategory.getIsParent()==1){
            return 0;
        }
        //不是父节点
        tbContentCategoryMapper.deleteByPrimaryKey(categoryId);
        Example example = new Example(TbContentCategory.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo(tbContentCategory.getParentId());
        List<TbContentCategory> list = tbContentCategoryMapper.selectByExample(example);
        if (list.size()==0){

        }


        return null;
    }


}
