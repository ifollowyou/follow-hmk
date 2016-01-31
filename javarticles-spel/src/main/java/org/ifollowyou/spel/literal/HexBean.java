package org.ifollowyou.spel.literal;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class HexBean {

    @Value("0x7FFFF")
    private int hexIntValue;

    @Value("0x4AFFF")
    private Long hexLongValue;

    @Value("#{0x35 * 3L}")
    private Long hexExpression;

    @Value("#{-0x20L}")
    private Long hexNegativeLongValue;

    public int getHexIntValue() {
        return hexIntValue;
    }

    public Long getHexLongValue() {
        return hexLongValue;
    }

    public Long getHexExpression() {
        return hexExpression;
    }

    public Long getHexNegativeLongValue() {
        return hexNegativeLongValue;
    }
}
