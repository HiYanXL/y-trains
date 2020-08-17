package com.yxl.trains.trains.service;

import com.yxl.trains.trains.dto.req.ProductQryReq;
import com.yxl.trains.trains.dto.req.Req;
import com.yxl.trains.trains.facade.ProductQryService;
import com.yxl.trains.trains.template.ProductQryTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProductQryServiceImpl extends ProductQryTemplate implements ProductQryService {

    @Override
    public List<Map<String, Object>> query(ProductQryReq req) {
        this.prepare(req);
        return this.execute(req);
    }

    @Override
    public List execute(Req req) {
        return null;
    }


}
