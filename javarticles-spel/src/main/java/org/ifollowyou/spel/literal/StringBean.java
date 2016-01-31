package org.ifollowyou.spel.literal;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class StringBean {

    @Value("John")
    private String name;

    @Value("#{'Hello World'.substring(6)}")
    private String substringValue;

    public String getName() {
        return name;
    }

    public String getSubstringValue() {
        return substringValue;
    }
}
