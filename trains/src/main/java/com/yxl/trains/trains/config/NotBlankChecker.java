package com.yxl.trains.trains.config;

public class NotBlankChecker extends AbstractDataItemChecker {


    public NotBlankChecker() {
        super("NotBlank");
        this.setAttribute("e2n", "false");
    }

    @Override
    public CheckItem checkDataItem(Element element, Object object, CheckItem item) {
        if (object != null && object.toString().trim().length() == 0) {
            this.fail(item, new Object[]{element.getName(), object});
        }
        return item;
    }
}
