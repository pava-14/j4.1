package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class TShirt extends Product {
    private String color;
    private String size;

    public TShirt(String color, String size) {
        this.color = color;
        this.size = size;
    }

    public TShirt(int id, String name, int price, String color, String size) {
        super(id, name, price);
        this.color = color;
        this.size = size;
    }

    @Override
    public boolean matches(String search) {
        return super.matches(search) || color.equalsIgnoreCase(search) || size.equalsIgnoreCase(search);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
