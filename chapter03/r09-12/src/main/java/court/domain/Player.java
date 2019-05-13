package court.domain;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class Player {

    @NotNull
    private String name;

    @NotNull
    @Length(min=7, max=11, message = "전화 번호는 7자리 이상 11자리 이")
    private String phone;

    public Player() {
    }

    public Player(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

