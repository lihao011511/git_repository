package com.usian.pojo;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

@Table( name ="de_duplication" )
public class DeDuplication {
    @Column(name = "tx_no")
    private String txNo;
    @Column(name = "create_time")
    private Date createTime;

    public DeDuplication() {
    }

    public DeDuplication(String txNo, Date createTime) {
        this.txNo = txNo;
        this.createTime = createTime;
    }

    public String getTxNo() {
        return txNo;
    }

    public void setTxNo(String txNo) {
        this.txNo = txNo;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
