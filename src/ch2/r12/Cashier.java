package ch2.r12;

import ch2.r11.ShoppingCart;
import org.springframework.beans.factory.BeanNameAware;
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
    Cashier 클래스의 POJO  인스턴스가 지신의 빈 이름을 인지하도록 해보자.

    이 인터페이스를 구현하기만 해도, 스프링은 빈 이름을 POJO 인스턴스에 자동으로 주입하며
    이렇게 가져온 빈 이름을 세터 메서드(setBeanName)에서 처리하면 된다.

 */

@Component
public class Cashier implements BeanNameAware {

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


    /**
     * 맨 아래 메서드에서처럼 빈 이름이 주입되면, 그 값을 이용해 빈 이름이 필수인, 다른 연관된 작업을 할 수 있다.
     *
     * 예를 들어, Cashier 클래스에서 체크아웃 데이터를 기록할 파일명에 해당하는 fileName 프로퍼티는 앞서 빈 이름으로 설정했기에,
     *
     * setFileName()메서드를 호출할 필요가 없다.  -> Config 파일로 고고
     * */

    /* BeanNameAware 오버라이딩 */
    @Override
    public void setBeanName(String beanName) {
        this.fileName = beanName;
    }

}
