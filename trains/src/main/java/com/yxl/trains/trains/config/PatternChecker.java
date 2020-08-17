package com.yxl.trains.trains.config;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternChecker extends AbstractDataItemChecker {

    private Map<String, Pattern> patterns;

    public final static String ATTRIBUTE_REPLACE = "replace";

    public PatternChecker() {
        super("Pattern");
    }

    @Override
    public CheckItem checkDataItem(Element element, Object object, CheckItem item) {

        String atValue = this.getAttribute(item, "value");
        Pattern pattern = (Pattern) this.patterns.get(atValue);
        if (pattern == null) {
            pattern = Pattern.compile(atValue);
        }
        Matcher m = pattern.matcher(object.toString());
        if (!m.matches()) {

        } else {
            String atReplace = this.getAttribute(item, "replace");
            if (atReplace.length() != 0) {
                item.setObject(m.replaceAll(atReplace));
            }
        }
        return item;
    }
}
