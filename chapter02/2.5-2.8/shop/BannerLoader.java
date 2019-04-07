package com.apress.springrecipes.shop;

import lombok.Data;
import org.springframework.core.io.Resource;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

@Data
public class BannerLoader {

    private Resource banner;

    @PostConstruct
    public void showBanner() throws IOException {
        Files.lines(Paths.get(banner.getURI()), Charset.forName("UTF-8")).forEachOrdered(System.out::println);
    }
}
