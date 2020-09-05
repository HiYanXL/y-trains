package com.yxl.trains.trains.facade;

import com.yxl.trains.trains.dto.req.ProductQryReq;
import com.yxl.trains.trains.dto.res.ProductQryRes;

public interface ProductQryService{
    ProductQryRes query(ProductQryReq req);
}
