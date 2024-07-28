package org.example.springdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Cart {
    private List<Info> items;

    public Cart() {
        this.items = new ArrayList<>();
    }

    public void addItem(Info item) {
        for(Info info : items) {
            if(info.getName().equals(item.getName())) {
                info.setQuantity(info.getQuantity()+1);
                return;
            }
        }
        items.add(item);

    }


}

