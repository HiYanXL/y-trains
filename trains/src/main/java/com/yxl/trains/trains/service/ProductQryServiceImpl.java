package com.yxl.trains.trains.service;

import com.yxl.trains.trains.dto.req.ProductQryReq;
import com.yxl.trains.trains.dto.req.Req;
import com.yxl.trains.trains.dto.res.ProductQryRes;
import com.yxl.trains.trains.facade.ProductQryService;
import com.yxl.trains.trains.template.ProductQryTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProductQryServiceImpl extends ProductQryTemplate implements ProductQryService {

    @Override
    public ProductQryRes query(ProductQryReq req) {
        this.prepare(req);
        ProductQryRes res = this.execute(req);
        this.afterAll(req,res);
        return res;
    }

    @Override
    public ProductQryRes execute(Req req) {


        return null;
    }

}
