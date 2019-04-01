package ch2.r11;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Date;


/**
 * 쇼핑몰 애플리케이션에서 체크아웃 기능 구현.
 * 카트에 담긴 상품 및 체크아웃 시각을 텍스트 파일로 기록하는 기능 포함.
 * */

/**
 * Configuration 파일에서 Bean을 반환하는 경우에는 @Bean 옆에 초기화/폐기시 메소드 이름을 적을 수 있다.
 *
 * 여기서는 자바 구성 클래스 외부에 @Componenet를 붙여 POJO 를 정의하는 경우를 보자
 *
 * */

@Component
public class Cashier {

    @Value("checkout")
    private String fileName;

    @Value("/Users/a1101082/Study/spring-study/src/ch2/r8/fff")
    private String path;

    private BufferedWriter writer;

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @PostConstruct
    public void openFile() throws IOException {

        File targetDir = new File(path);
        if (!targetDir.exists()) {
            targetDir.mkdir();
        }

        File checkoutFile = new File(path, fileName + ".txt");
        if (!checkoutFile.exists()) {
            checkoutFile.createNewFile();
        }

        writer = new BufferedWriter(
                new OutputStreamWriter(
                        new FileOutputStream(checkoutFile, true)));
    }

    public void checkout(ShoppingCart cart) throws IOException {
        writer.write(new Date() + "\t" + cart.getItems() + "\r\n");
        writer.flush();
    }

    @PreDestroy
    public void closeFile() throws IOException {
        writer.close();
    }
}
