package ch2.r6;

import org.springframework.core.io.Resource;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class BannerLoader {

    private Resource banner;

    public void setBanner(Resource banner) {
        this.banner = banner;
    }

    @PostConstruct  // 빈 생성 후, 이 메서드 실행. IoC 컨테이너 구성 시점에 출력됨
    public void showBanner() throws IOException {
        Files.lines(Paths.get(banner.getURI()), Charset.forName("UTF-8"))
            .forEachOrdered(System.out::println); // 배너 파일 내용 차례로 읽어, 콘솔에 한 줄씩 출력
    }
}
