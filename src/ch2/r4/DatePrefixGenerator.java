package ch2.r4;

import ch2.r3.PrefixGenerator;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@DatePrefixAnnotation   // 빈 인스턴스를 생성하는 POJO 주입클래스에 붙임
public class DatePrefixGenerator implements PrefixGenerator {

    private DateFormat formatter;

    public void setPattern(String pattern) {
        this.formatter = new SimpleDateFormat(pattern);
    }

    @Override
    public String getPrefix() {
        return formatter.format(new Date());
    }
}
