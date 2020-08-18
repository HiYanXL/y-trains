package com.yxl.trains.trains.template;

import com.yxl.trains.trains.dto.req.Req;
import com.yxl.trains.trains.facade.YCommonService;
import com.yxl.trains.trains.service.FieldStyleChecker;

import java.util.List;

public abstract class ProductQryTemplate implements YCommonService<Req> {
    @Override
    public void prepare(Req req) {
        //显示调用checker进行属性值校验
        FieldStyleChecker.checkAttributeValue(req);
        //校验通过才会打印对象
        System.out.println(req);
    }

    @Override
    public abstract List execute(Req req);
}
