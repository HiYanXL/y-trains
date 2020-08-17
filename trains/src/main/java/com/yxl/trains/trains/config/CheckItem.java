package com.yxl.trains.trains.config;

import java.util.Map;

public class CheckItem {
    private AbstractElement element;
    private Map<String,String> attributes;
    private Map<String,String> styleAttributes;
    private Object[] objects;
    private Object[] parents;
    private Map<String,Converter<CheckItem,CheckItem>> checkers;

    public CheckItem(Map<String, String> attributes, Map<String, Converter<CheckItem, CheckItem>> checkers) {
        this.attributes = attributes;
        this.checkers = checkers;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }

    public Map<String, String> getStyleAttributes() {
        return styleAttributes;
    }

    public void setStyleAttributes(Map<String, String> styleAttributes) {
        this.styleAttributes = styleAttributes;
    }

    public Object[] getObjects() {
        return objects;
    }

    public void setObjects(Object[] objects) {
        this.objects = objects;
    }

    public Object getObject() {
        return objects[0];
    }

    public void setObject(Object object) {
        this.objects[0] = object;
    }

    public Object[] getParents() {
        return parents;
    }

    public void setParents(Object[] parents) {
        this.parents = parents;
    }

    public Map<String, Converter<CheckItem, CheckItem>> getCheckers() {
        return checkers;
    }

    public void setCheckers(Map<String, Converter<CheckItem, CheckItem>> checkers) {
        this.checkers = checkers;
    }

    public AbstractElement getElement() {
        return element;
    }

    public void setData(AbstractElement element,Object[] objects,Object[] parents){
        this.element = element;
        this.objects = objects;
        this.parents = parents;
    }
}
