package com.yxl.trains.trains.config;

import com.yxl.magicbox.exceptions.YRuntimeException;
import org.springframework.beans.factory.BeanNameAware;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CommonChecker implements Converter<CheckItem, CheckItem>, BeanNameAware {
    private Map<String, String> attributes;
    protected List<String> preList;
    protected List<String> aftList;
    private String id;
    private String defaultMessage;

    public CommonChecker() {
    }

    public CommonChecker(String id) {
        this.id = id;
    }

    public CheckItem convertInner(CheckItem input) {
        return input;
    }


    public String getId() {
        return id;
    }

    @Override
    public void setBeanName(String id) {
        this.id = id;
    }

    private Converter<CheckItem, CheckItem> getChecker(String type, CheckItem input) {
        return input.getCheckers() != null ? (Converter) input.getCheckers().get(type) : null;
    }

    protected CheckItem check(List<String> checks, CheckItem input) {
        Converter check;
        for (Iterator it = checks.iterator(); it.hasNext(); input = (CheckItem) check.convert(input)) {
            String type = (String) it.next();
            check = this.getChecker(type, input);
            if (check == null) {
                throw new YRuntimeException("styles type not exist");
            }
        }
        return input;
    }

    @Override
    public CheckItem convert(CheckItem input) {
        boolean disable = this.getAttribute(input, "disable", false);
        if (disable) {
            return input;
        } else if (this.getAttribute(input, "option", false) && !this.assertNotBlank(input)) {
            return input;
        } else {
            if (this.preList != null) {
                input = this.check(this.preList, input);
            }
            input = this.convertInner(input);
            if (this.aftList != null) {
                input = this.check(this.aftList, input);
            }
            return input;
        }
    }


    protected String getAttribute(CheckItem item, String name) {
        String key = this.getId() + '.' + name;
        String str = this.searchAttribute(item, key, name);
        return str == null ? "" : str.trim();
    }

    protected boolean getAttribute(CheckItem item, String name, boolean flag) {
        String key = this.getId() + '.' + name;
        String str = this.searchAttribute(item, key, name);
        if (str == null) {
            return flag;
        } else {
            str = str.trim().toLowerCase();
            return str.length() == 0 ? true : "true".equals(str) || "y".equals(str) || name.equals(str);
        }
    }

    private String searchAttribute(CheckItem item, String key, String name) {
        String value;
        if (item.getStyleAttributes() != null) {
            value = (String) item.getStyleAttributes().get(key);
            if (value != null) {
                return value;
            }
        }
        value = (String) item.getAttributes().get(key);
        if (value != null) {
            return value;
        } else {
            return this.attributes != null ? (String) this.attributes.get(name) : null;
        }
    }

    protected boolean assertNotNull(CheckItem item) {
        if (item != null && item.getAttributes() != null) {
            Object object = item.getObject();
            if (object == null) {
                return false;
            } else if (object instanceof String && ((String) object).length() == 0
                    && this.getAttribute(item, "e2n", false)) {
                item.setObject((Object) null);
                return false;
            } else {
                return true;
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    protected boolean assertNotBlank(CheckItem item) {
        if (item != null && item.getAttributes() != null) {
            Object object = item.getObject();
            if (object == null) {
                return false;
            } else if (object instanceof String && ((String) object).trim().length() == 0) {
                item.setObject((Object) null);
                return false;
            } else {
                return true;
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void setPreList(List<String> preList) {
        this.preList = preList;
    }

    public void setAftList(List<String> aftList) {
        this.aftList = aftList;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, String> attributes) {
        if (this.attributes != null) {
            this.attributes.putAll(attributes);
        } else {
            this.attributes = attributes;
        }
    }

    public void setAttribute(String name, String value) {
        if (this.attributes != null) {
            this.attributes = new HashMap<>();
        }
        this.attributes.put(name, value);
    }

    protected CheckItem unsupported(Object... args) {
        throw new YRuntimeException("unsupported element", args);
    }

    protected String getMessage(CheckItem item) {
        return this.getMessage(item, (String) null);
    }

    protected String getMessage(CheckItem item, String defaultMsg) {
        String msg = this.getAttribute(item, "message");
        if (msg.length() == 0) {
            return defaultMsg != null ? defaultMsg : this.getDefaultMessage();
        } else {
            return msg;
        }
    }

    protected String getDefaultMessage() {
        return this.defaultMessage != null ? this.defaultMessage : "fail check" + this.getId().toLowerCase();
    }

    protected CheckItem fail(CheckItem item, Object... args) {
        throw new YRuntimeException(this.getMessage(item), args);
    }

    protected CheckItem fail(CheckItem item, Throwable t, Object... args) {
        throw new YRuntimeException(this.getMessage(item), t, args);
    }
}
