package com.yxl.trains.trains.template;

import com.yxl.trains.trains.dto.req.Req;
import com.yxl.trains.trains.dto.res.Res;
import com.yxl.trains.trains.facade.YCommonService;
import com.yxl.trains.trains.service.FieldStyleChecker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;

public abstract class ProductQryTemplate implements YCommonService<Req, Res> {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void prepare(Req req) {
        //显示调用checker进行属性值校验
        FieldStyleChecker.checkAttributeValue(req);
        //校验通过才会打印对象
        logger.info(req.toString());
    }

    @Override
    public abstract Res execute(Req req);

    @Override
    public boolean checkSuccess(Res res){
        if(res != null && "000000".equals(res._RejCode) ){
            return true;
        }
        return false;
    }

    @Override
    public void afterAll(Req req, Res res) {
        String msg;
        Timestamp timestamp;
        if (this.checkSuccess(res)) {
            msg = ": We made it!";
            timestamp = res._ResponseTime;
        } else {
            msg = ": We failed.";
            timestamp = req._RequestTime;
        }
        StringBuffer sb = new StringBuffer(this.AUTHOR_NAME);
        sb.append(msg).append(" ").append(timestamp).append(" ").append(this.ADDRESS);
        logger.info(sb.toString());
    }
}
