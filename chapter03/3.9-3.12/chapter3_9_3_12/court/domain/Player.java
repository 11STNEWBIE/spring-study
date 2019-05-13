package chapter3_9_3_12.court.domain;

import lombok.Data;

@Data
public class Player {
    private String name;
    private String phone;

    public Player(){
    }
    public Player(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
}
