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
        setItemId();
    }

    public String getItemid() {
        return itemId;
    }

    private void setItemId() {
        String tempName = name;
        itemId = removeVowels(tempName).toUpperCase();
    }

    private String removeVowels(String word) {
        return word.replaceAll("[aeiou]", "").trim();
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

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "[ " + name + " ] \n" +
                "* Description: " + description + " \n" +
                "* Price: " + price + " \n" +
                "* Amount In Stock: " + amountInStock;

    }
}
