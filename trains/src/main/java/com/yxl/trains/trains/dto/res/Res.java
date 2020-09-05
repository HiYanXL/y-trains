package com.yxl.trains.trains.dto.res;

import com.yxl.magicbox.utils.StringUtils;

import java.sql.Timestamp;

public class Res {
    /**
     * 计数器:
     * 因为里面用了反射构造this，会不断加载this.toString()。
     * 使用计数器，只允许加载this.toString()一次。
     * 其余加载super.toString()。
     */
    private static int counter = 0;

    /**
     * 响应时间
     */
    public Timestamp _ResponseTime = new Timestamp(System.currentTimeMillis());

    /**
     * 状态码
     */
    public String _RejCode;

    /**
     * 状态信息
     */
    public String _RejMsg;

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
