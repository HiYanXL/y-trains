package com.yxl.trains.trains.usercases;

import com.yxl.magicbox.utils.PrintSeparatorUtils;
import com.yxl.trains.trains.TrainsApplicationTests;
import com.yxl.trains.trains.annotions.DataLen;
import com.yxl.trains.trains.annotions.FieldStyle;
import com.yxl.trains.trains.dto.req.ProductQryReq;
import com.yxl.trains.trains.facade.ProductQryService;
import com.yxl.trains.trains.service.DataLenChecker;
import com.yxl.trains.trains.service.FieldStyleChecker;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;


public class AnnotationTests extends TrainsApplicationTests {
    @Autowired
    public ProductQryService productQryService;

    public class A {
        @DataLen(value = 4)
        private String name;
        @FieldStyle(value = "[A-Z]")
        private String word;

        public A(String name, String word) {
            this.name = name;
            this.word = word;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setWord(String word) {
            this.word = word;
        }

        public String getName() {
            return name;
        }

        public String getWord() {
            return word;
        }
    }

    @Test
    public void test() throws Exception {
        A a = new A("tony", "git push!");

        DataLenChecker.checkAttributeValueLen(a);
    }

    @Test
    public void testFieldStyleChecker() throws Exception {
        A a = new A("tony", "cd /home");

        FieldStyleChecker.checkAttributeValue(a);

    }


    @Test
    public void testPrdQry() {

        productQryService.query(new ProductQryReq("hello", "GFL202001"));
        PrintSeparatorUtils.print();

        try {
            productQryService.query(new ProductQryReq("yes", "90"));
        } catch (Exception e) {
            e.printStackTrace();
            PrintSeparatorUtils.print();
        }

        try {
            productQryService.query(new ProductQryReq("", "90"));
        } catch (Exception e) {
            e.printStackTrace();
            PrintSeparatorUtils.print();
        }
    }

    @Test
    public void testSwitch() {
        String str = null;
        System.out.println(selectValue(str));
    }

    private String selectValue(String str) {
        if(str!=null)
        switch (str) {
            case "a":
                return str + "1";

            case "b":
                return str + new Date();
            default:
                return str;
        }
        return null;
    }


}
