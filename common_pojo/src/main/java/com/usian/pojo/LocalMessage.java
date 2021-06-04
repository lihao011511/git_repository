package com.usian.pojo;

import javax.persistence.Column;
import javax.persistence.Table;

@Table( name ="local_message" )
public class LocalMessage {
    @Column(name = "tx_no")
    private String txNo;
    @Column(name = "order_no")
    private String orderNo;
    private Integer state;

    public String getTxNo() {
        return txNo;
    }

    public LocalMessage() {
    }

    public void setTxNo(String txNo) {
        this.txNo = txNo;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public LocalMessage(String txNo, String orderNo, Integer state) {
        this.txNo = txNo;
        this.orderNo = orderNo;
        this.state = state;
    }
}
