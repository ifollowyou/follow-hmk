package org.ifollowyou.spel.literal;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class NumberBean {
    @Value("5000")
    private int intValue;

    @Value("2.5")
    private Double doubleValue;

    @Value("#{2.5d}")
    private Double doubleValueExpression;

    @Value("3.2")
    private float floatValue;

    @Value("#{new Integer(20)}")
    private Integer newInt;

    @Value("-2.5d")
    private Double negativeDoubleValue;

    @Value("#{2.5d * 2}")
    private Double multiplyDoubleValue;

    public int getIntValue() {
        return intValue;
    }

    public Double getDoubleValue() {
        return doubleValue;
    }

    public Double getDoubleValueExpression() {
        return doubleValueExpression;
    }

    public float getFloatValue() {
        return floatValue;
    }

    public Integer getNewInt() {
        return newInt;
    }

    public Double getNegativeDoubleValue() {
        return negativeDoubleValue;
    }

    public Double getMultiplyDoubleValue() {
        return multiplyDoubleValue;
    }
}
