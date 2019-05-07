package chapter3_5_3_8.court.domain;

import lombok.Data;

@Data
public class Player {
    private String name;
    private String phone;

    public Player(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
}
