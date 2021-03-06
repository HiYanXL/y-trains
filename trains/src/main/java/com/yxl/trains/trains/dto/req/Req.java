package com.yxl.trains.trains.dto.req;

import com.yxl.magicbox.utils.StringUtils;

import java.sql.Timestamp;

public class Req {
    /**
     * 计数器:
     * 因为里面用了反射构造this，会不断加载this.toString()。
     * 使用计数器，只允许加载this.toString()一次。
     * 其余加载super.toString()。
     */
    private static int counter = 0;

    /**
     * 请求时间
     */
    public Timestamp _RequestTime = new Timestamp(System.currentTimeMillis());

    @Override
    public String toString() {
        counter++;
        return this.obj2String(this);
    }

    private String obj2String(Object object) {
        if (counter > 1) {
            counter = 0;
            return super.toString();
        }
        return StringUtils.obj2String(object);
    }
}
