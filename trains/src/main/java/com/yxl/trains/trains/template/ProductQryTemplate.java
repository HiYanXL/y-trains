package com.yxl.trains.trains.template;

import com.yxl.magicbox.exceptions.YRuntimeException;
import com.yxl.trains.trains.dto.req.Req;
import com.yxl.trains.trains.facade.YCommonService;
import com.yxl.trains.trains.service.FieldStyleChecker;

import java.util.List;

public abstract class ProductQryTemplate implements YCommonService<Req> {
    @Override
    public void prepare(Req req) {
        try {
            FieldStyleChecker.checkAttributeValue(req);
        } catch (Exception e) {
            throw new YRuntimeException(e.getMessage());
        }
        System.out.println(req);

    }
    @Override
    public abstract List execute(Req req);
}
