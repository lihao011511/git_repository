package com.usian.vo;

import com.usian.pojo.TbItem;

import java.util.Date;

public class TbItemVo extends TbItem {
    private String desc;
    private String itemParams;

    public TbItemVo(){

    }


    public TbItemVo(Long id, String title, String sellPoint, Integer price, String num, String barcode, String image, Integer cid, Integer status, Date created, Date updated, String desc) {
        super(id, title, sellPoint, price, num, barcode, image, cid, status, created, updated);
        this.desc = desc;
    }

    public TbItemVo(String desc, String itemParams) {
        this.desc = desc;
        this.itemParams = itemParams;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getItemParams() {
        return itemParams;
    }

    public void setItemParams(String itemParams) {
        this.itemParams = itemParams;
    }
}
