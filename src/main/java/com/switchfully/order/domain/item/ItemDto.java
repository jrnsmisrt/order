package com.switchfully.order.domain.item;

public class ItemDto {
    private String itemId;
    private String name;
    private String description;
    private double price;
    private int amountInStock;


    public ItemDto(String name, String description, double price, int amountInStock) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.amountInStock = amountInStock;

    }

    public String getItemid() {
        return this.itemId;
    }

    private ItemDto setItemId(String itemId) {
        this.itemId=itemId;
        return this;
    }


    public ItemDto updateItem(String name, String description, double price, int amountInStock) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.amountInStock = amountInStock;
        return this;
    }

    public ItemDto showItem() {
        return this;
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

    @Override
    public String toString() {
        return "[ " + name + " ] \n" +
                "* Description: " + description + " \n" +
                "* Price: " + price + " \n" +
                "* Amount In Stock: " + amountInStock;

    }
}
