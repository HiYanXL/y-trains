package com.yxl.trains.trains.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.List;
import java.util.Map;

public class AbstractElement implements Element, ApplicationContextAware {

    private String name;
    private String type;
    private String params;
    private ApplicationContext applicationContext;
    private Converter<CheckItem, CheckItem> checker;
    private Map<String, String> attributes;
    private List<String> paramsList;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getParams() {
        return params;
    }

    @Override
    public void setParams(String params) {
        this.params = params;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext){
        this.applicationContext = applicationContext;
    }

    public ApplicationContext getApplicationContext(){
        return this.applicationContext;
    }

    public Converter<CheckItem, CheckItem> getChecker() {
        return checker;
    }

    public void setChecker(Converter<CheckItem, CheckItem> checker) {
        this.checker = checker;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }

    public List<String> getParamsList() {
        return paramsList;
    }

    public void setParamsList(List<String> paramsList) {
        this.paramsList = paramsList;
    }
}
