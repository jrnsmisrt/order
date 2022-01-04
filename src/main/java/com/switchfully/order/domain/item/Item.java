package com.switchfully.order.domain.item;

import javax.persistence.*;
import java.util.Objects;
@Entity
@Table(name="items")
public class Item {
    private static long idCounter;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long itemId;
    @Column(name="name")
    private String name;
    @Column(name="description")
    private String description;
    @Column(name="price")
    private double price;
    @Column(name="amount_in_stock")
    private int amountInStock;


    public Item(String name, String description, double price, int amountInStock) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.amountInStock = amountInStock;
        this.itemId = idCounter;
        idCounter++;
    }

    public Item(){

    }

    public long getItemid() {
        return itemId;
    }

    public String getNameOfItem() {
        return name;
    }

    public void changeNameOfItem(String name) {
        this.name = name;
    }

    public String showDescription() {
        return description;
    }

    public void changeDescription(String description) {
        this.description = description;
    }

    public int showAmountInStock() {
        return amountInStock;
    }

    public void changeAmountOfItem(int amount) {
        this.amountInStock = amount;
    }

    public double getPrice() {
        return price;
    }

    public void changePriceOfItem(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "[ [ " + name + " ] \n" +
                "* Description: " + description + " \n" +
                "* Price: " + price + " \n" +
                "* Amount In Stock: " + amountInStock + " ]";

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(name, item.name) && Objects.equals(description, item.description);
    }


    public void setName(String name) {
        this.name = name;
    }
}
