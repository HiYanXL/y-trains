package com.yxl.trains.trains.dto.res;

import java.util.List;
import java.util.Map;

public class ProductQryRes extends Res {

    private List<Map<String,Object>> mapList;

    public List<Map<String, Object>> getMapList() {
        return mapList;
    }

    public void setMapList(List<Map<String, Object>> mapList) {
        this.mapList = mapList;
    }
}
