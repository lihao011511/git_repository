package com.usian.vo;

public class ItemEsVo {
    private Long itemId;
    private String itemTitle;
    private String itemSellPoint;
    private String itemPrice;
    private String itemImage;
    private String itemCategoryName;
    private String itemDesc;

    @Override
    public String toString() {
        return "ItemEsVo{" +
                "itemId=" + itemId +
                ", itemTitle='" + itemTitle + '\'' +
                ", itemSellPoint='" + itemSellPoint + '\'' +
                ", itemPrice='" + itemPrice + '\'' +
                ", itemImage='" + itemImage + '\'' +
                ", itemCategoryName='" + itemCategoryName + '\'' +
                ", itemDesc='" + itemDesc + '\'' +
                '}';
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public String getItemSellPoint() {
        return itemSellPoint;
    }

    public void setItemSellPoint(String itemSellPoint) {
        this.itemSellPoint = itemSellPoint;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getItemImage() {
        return itemImage;
    }

    public void setItemImage(String itemImage) {
        this.itemImage = itemImage;
    }

    public String getItemCategoryName() {
        return itemCategoryName;
    }

    public void setItemCategoryName(String itemCategoryName) {
        this.itemCategoryName = itemCategoryName;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    public ItemEsVo() {
    }

    public ItemEsVo(Long itemId, String itemTitle, String itemSellPoint, String itemPrice, String itemImage, String itemCategoryName, String itemDesc) {
        this.itemId = itemId;
        this.itemTitle = itemTitle;
        this.itemSellPoint = itemSellPoint;
        this.itemPrice = itemPrice;
        this.itemImage = itemImage;
        this.itemCategoryName = itemCategoryName;
        this.itemDesc = itemDesc;
    }
}
