package com.yxl.trains.trains.config;

public abstract class AbstractDataItemChecker extends CommonChecker {

    public AbstractDataItemChecker(String id) {
        super(id);
        this.setAttribute("e2n","true");
    }

    public abstract CheckItem checkDataItem(Element element,Object object,CheckItem item);

    public CheckItem convertInner(CheckItem item){
        if(!this.assertNotNull(item)&&this.getAttribute(item,"e2n",true)){
            return item;
        }else{
            Element element = item.getElement();
            Class<?> ce = element.getClass();
            return ce == DataItem.class?this.checkDataItem(item.getElement(),item.getObject(),item):this.unsupported(new Object[]{ce});
        }
    }
}
