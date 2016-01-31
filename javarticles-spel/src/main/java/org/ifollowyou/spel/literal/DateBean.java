package org.ifollowyou.spel.literal;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class DateBean {

    @Value("#{new java.text.SimpleDateFormat('yyyyMMdd').parse('20150616')}")
    private Date dateValue;

    public Date getDateValue() {
        return dateValue;
    }

}
