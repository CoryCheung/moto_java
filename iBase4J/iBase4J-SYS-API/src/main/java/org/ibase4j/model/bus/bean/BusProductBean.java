package org.ibase4j.model.bus.bean;

import org.ibase4j.model.bus.BusProduct;

/**
 * Created by Administrator on 2016/7/13.
 */
public class BusProductBean extends BusProduct{
    private String typeText;

    public String getTypeText() {
        return typeText;
    }

    public void setTypeText(String typeText) {
        this.typeText = typeText;
    }
}
