package com.yxl.trains.trains.dto.req;

import com.yxl.magicbox.utils.StringUtils;

public class Req {
    private static int counter = 0;

    @Override
    public String toString() {
        counter++;
        return this.Obj2String(this);
    }

    public String Obj2String(Object object) {
        if (counter > 1) {
            counter = 0;
            return super.toString();
        }
        return StringUtils.Obj2String(object);
    }
}
