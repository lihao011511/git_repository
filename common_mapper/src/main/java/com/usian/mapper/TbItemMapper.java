package com.usian.mapper;

import com.usian.pojo.TbItem;
import com.usian.vo.ItemEsVo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface TbItemMapper extends Mapper<TbItem> {
    public List<ItemEsVo> queryAll();

}