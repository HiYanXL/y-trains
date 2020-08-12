package com.yxl.trains.trains.facade;

import com.yxl.trains.trains.dto.req.ProductQryReq;

import java.util.List;
import java.util.Map;

public interface ProductQryService extends YCommonService<ProductQryReq>{
    List<Map<String,Object>> query(ProductQryReq req);
}
