package com.switchfully.order.domain.item;

public class ItemDto {
    private long itemId;
    private String name;
    private String description;
    private double price;
    private int amountInStock;

    public long getItemId() {
        return this.itemId;
    }

    public ItemDto setItemId(long itemId) {
        this.itemId=itemId;
        return this;
    }

    public ItemDto setName(String name){
        this.name = name;
        return this;
    }
    public String showName(){
        return name;
    }


    public int ShowAmountInStock() {
        return amountInStock;
    }
    public ItemDto setAmountInStock(int amountInStock){
        this.amountInStock=amountInStock;
        return this;
    }

    public double getPrice() {
        return price;
    }
    public ItemDto setPrice(double price){
        this.price=price;
        return this;
    }
    public ItemDto changeDescription(String description){
        this.description=description;
        return this;
    }
    public String showDescription(){
        return description;
    }
    @Override
    public String toString() {
        return "[ [ " + name + " ] \n" +
                "* Description: " + description + " \n" +
                "* Price: " + price + " \n" +
                "* Amount In Stock: " + amountInStock+" ]";

    }
}
