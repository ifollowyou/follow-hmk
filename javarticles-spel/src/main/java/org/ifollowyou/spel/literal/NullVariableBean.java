package org.ifollowyou.spel.literal;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class NullVariableBean {

    @Value("#{null}")
    private String nullValue;

    @Value("null")
    private String nullStringValue;


    public String getNullValue() {
        return "Is value '#{null}' null? " + (nullValue == null);
    }

    public String getNullStringValue() {
        return "Is value 'null' null? " + (nullStringValue == null);
    }
}
