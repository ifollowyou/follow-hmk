package org.ifollowyou.spel.literal;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ExponentBean {

    @Value("2.1E-7")
    private Double exponentialValue;

    @Value("2.1E+1")
    private Double exponentialDoubleValue;

    public Double getExponentialValue() {
        return exponentialValue;
    }

    public Double getExponentialDoubleValue() {
        return exponentialDoubleValue;
    }

}
