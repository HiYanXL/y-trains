package com.yxl.trains.trains.config;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.ManagedList;
import org.springframework.beans.factory.support.ManagedMap;
import org.springframework.beans.factory.xml.AbstractSimpleBeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class StylesParser extends AbstractSimpleBeanDefinitionParser {
    @Override
    protected Class getBeanClass(Element element) {
        // 返回该标签所定义的类实现
        return StyleChecker.class;
    }

    @Override
    protected void doParse(Element element, ParserContext parserContext, BeanDefinitionBuilder builder) {
        ManagedList<String> preList = new ManagedList<>();
        ManagedMap<String,Object> attributes = new ManagedMap<>();
        NodeList nodeList = element.getChildNodes();
        for(int i=0;i<nodeList.getLength();i++){
            Node node =nodeList.item(i);
            if(node instanceof Element){
                Element subElement = (Element) node;
                String name = subElement.getLocalName();
                String nameAttr;
                if("style".equals(name)){
                    nameAttr = subElement.getAttribute("name");
                    //TODO 可考虑校验style的name属性
                    preList.add(nameAttr);
                    NodeList grandChildNodeList = subElement.getChildNodes();
                    for(int j = 0;j<grandChildNodeList.getLength();j++){
                        Node gcNode = grandChildNodeList.item(j);
                        if(gcNode instanceof Element){
                            Element gcElement = (Element)gcNode;
                            String gcName = gcNode.getLocalName();
                            if("check".equals(gcName)){
                                String gcNameAttr = gcElement.getAttribute("pattern");
                                //TODO 可考虑校验Pattern的name属性
                                String gcAttrValue = gcElement.getTextContent();
                                //style.pattern : regex
                                attributes.put(nameAttr+"."+gcNameAttr,gcAttrValue);
                            }
                        }
                    }
                }
            }
        }
        builder.addPropertyValue("pre",preList);
        builder.addPropertyValue("attributes",attributes);
    }
}
