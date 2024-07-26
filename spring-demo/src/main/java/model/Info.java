package model;

import lombok.Data;




@Data

public class Info {
    private String name;
    private int price;
    private int quantity;

    public Info() {
        this.quantity = 1;
    }

    public Info(String name, int price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = 1;
    }

    public Info(Info info) {
        this.name = info.name;
        this.price = info.price;
        this.quantity = info.quantity;
    }
}
