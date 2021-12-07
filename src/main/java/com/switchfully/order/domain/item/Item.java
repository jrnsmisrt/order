package com.switchfully.order.domain.item;

public class Item {
    private String itemId;
    private String name;
    private String description;
    private double price;
    private int amountInStock;


    public Item(String name, String description, double price, int amountInStock) {
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

    public String getNameOfItem(){
        return name;
    }

    private String removeVowels(String word) {
        return word.replaceAll("[aeiou]", "").trim();
    }

    public void updateItem(String name, String description, double price, int amountInStock) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.amountInStock = amountInStock;
    }

    public Item showItem() {
        return this;
    }
    public String showDescription(){
        return description;
    }
    public void changeDescription(String description){
        this.description=description;
    }
    public int showAmountInStock() {
        return amountInStock;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "[ [ " + name + " ] \n" +
                "* Description: " + description + " \n" +
                "* Price: " + price + " \n" +
                "* Amount In Stock: " + amountInStock+" ]";

    }


}
