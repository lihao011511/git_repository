package com.usian.service;

import com.usian.pojo.TbContentCategory;

import java.util.List;

public interface ContentCategoryService {
    List<TbContentCategory> selectContentCategoryByParentId(Long parentId);

    void insertContentCategory(Long parentId, String name);

    Integer deleteContentCategoryById(Long categoryId);
}
