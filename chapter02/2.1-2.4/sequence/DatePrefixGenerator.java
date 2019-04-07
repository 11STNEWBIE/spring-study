package com.apress.springrecipes.sequence;

import lombok.Data;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@Component
@Primary
public class DatePrefixGenerator implements PrefixGenerator {
    private String pattern;

    @Override
    public String getPrefix() {
        DateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        return formatter.format(new Date());
    }
}
