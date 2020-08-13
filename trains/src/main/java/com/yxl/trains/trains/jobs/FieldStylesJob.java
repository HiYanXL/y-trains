package com.yxl.trains.trains.jobs;

import com.yxl.magicbox.utils.PrintSeparatorUtils;
import org.springframework.util.ResourceUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class FieldStylesJob {

    public static Map<String, String> stylesCache = new HashMap<>();

    private static String defaultPath = "classpath:styles.xml";

    public static void getFieldStyles() throws Exception {
        getFieldStyles(defaultPath);
    }


    public static void getFieldStyles(String path) throws Exception {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        String str = System.getProperty("user.dir");
        Document document = builder.parse(ResourceUtils.getFile(path));
        Element root = document.getDocumentElement();

        //获取根元素的属性值
        NodeList list = root.getElementsByTagName("style");

        for (int i = 0; i < list.getLength(); i++) {
            Element element = (Element) list.item(i);
            String key = element.getAttribute("name");
            NodeList tmpList = element.getElementsByTagName("Pattern");
            Element tmpElement = (Element) tmpList.item(0);
            String value = tmpElement.getTextContent();

            stylesCache.put(key, value);
        }
        //PrintCollectionUtils.print(stylesCache);
        System.out.println(new Date() + PrintSeparatorUtils.get32Dash() + "stylesCache加载完毕");
    }
}
