package chapter3_9_3_12.court.domain;

import lombok.Data;

@Data
public class SportType {
    private int id;
    private String name;

    public SportType(int id, String name) {
    }
}
