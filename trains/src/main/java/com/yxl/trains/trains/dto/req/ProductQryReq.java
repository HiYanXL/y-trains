package com.yxl.trains.trains.dto.req;

import com.yxl.trains.trains.annotions.FieldStyle;

public class ProductQryReq extends Req {

    public ProductQryReq() {
    }

    public ProductQryReq(String prdName, String prdNo) {
        this.prdName = prdName;
        this.prdNo = prdNo;
    }

    @FieldStyle(value = "PrdNameStyle")
    private String prdName;
    private String prdNo;

    public String getPrdName() {
        return prdName;
    }

    public void setPrdName(String prdName) {
        this.prdName = prdName;
    }

    public String getPrdNo() {
        return prdNo;
    }

    public void setPrdNo(String prdNo) {
        this.prdNo = prdNo;
    }
}
