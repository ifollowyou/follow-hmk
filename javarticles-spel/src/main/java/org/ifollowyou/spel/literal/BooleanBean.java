package org.ifollowyou.spel.literal;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BooleanBean {

    @Value("true")
    private boolean booleanTrueValue;

    @Value("1")
    private boolean oneValue;

    @Value("yes")
    private boolean yesValue;

    public boolean isBooleanValueTrue() {
        return booleanTrueValue;
    }

    public boolean isOneTrue() {
        return oneValue;
    }

    public boolean isYesTrue() {
        return yesValue;
    }
}
