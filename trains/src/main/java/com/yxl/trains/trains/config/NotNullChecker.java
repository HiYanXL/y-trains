package com.yxl.trains.trains.config;

public class NotNullChecker extends CommonChecker {
    public NotNullChecker() {
        super("NotNull");
        this.setAttribute("e2n", "false");
    }

    public CheckItem convertInner(CheckItem item) {
        if (!this.assertNotNull(item)) {
            this.fail(item, new Object[]{item.getElement().getName()});
        }
        return item;
    }
}
