package com.yxl.trains.trains.config;

import com.yxl.magicbox.exceptions.YRuntimeException;

import java.util.Map;

public class StyleChecker extends CommonChecker {
    public StyleChecker() {
    }

    public StyleChecker(String id) {
        super(id);
    }
    @Override
    public CheckItem convert(CheckItem input){
        if(input.getStyleAttributes()!=null){
            throw new YRuntimeException("styleChecker error");
        }else{
            input.setStyleAttributes(this.getAttributes());
            CheckItem item;
            try{
                item = super.convert(input);
            }finally {
                input.setStyleAttributes((Map)null);
            }
            return item;
        }
    }
}
