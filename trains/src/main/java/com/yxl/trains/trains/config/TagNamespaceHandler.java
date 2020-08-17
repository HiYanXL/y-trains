package com.yxl.trains.trains.config;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

public class TagNamespaceHandler extends NamespaceHandlerSupport {

    @Override
    public void init() {
        //自定义标签中的element标签名为styles解析注册使用StylesParser进行.
        this.registerBeanDefinitionParser("styles", new StylesParser());
    }
}
