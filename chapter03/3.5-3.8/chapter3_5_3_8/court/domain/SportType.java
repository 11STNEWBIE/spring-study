package chapter3_5_3_8.court.domain;

import lombok.Data;

@Data
public class SportType {
    private int id;
    private String name;

    public SportType(int id, String name) {
    }
}
