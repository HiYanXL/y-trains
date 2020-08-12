package com.yxl.trains.trains.service;

import com.yxl.magicbox.exceptions.YRuntimeException;
import com.yxl.trains.trains.dto.req.ProductQryReq;
import com.yxl.trains.trains.facade.ProductQryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProductQryServiceImpl implements ProductQryService {

    @Override
    public List<Map<String, Object>> query(ProductQryReq req) {
        this.prepare(req);
        return this.execute(req);
    }


    @Override
    public void prepare(ProductQryReq req) {

        try {
            FieldStyleChecker.checkAttributeValue(req);
        } catch (Exception e) {
            throw new YRuntimeException(e.getMessage());
        }


    }

    @Override
    public List<Map<String, Object>> execute(ProductQryReq req) {
        System.out.println(req);

        return null;
    }
}
