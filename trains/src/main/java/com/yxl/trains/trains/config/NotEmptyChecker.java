package com.yxl.trains.trains.config;

public class NotEmptyChecker extends AbstractDataItemChecker {


    public NotEmptyChecker() {
        super("NotEmpty");
        this.setAttribute("e2n", "false");
    }

    @Override
    public CheckItem checkDataItem(Element element, Object object, CheckItem item) {
        if (object == null || object.toString().length() == 0) {
            this.fail(item, new Object[]{element.getName(), object});
        }
        return item;
    }
}
