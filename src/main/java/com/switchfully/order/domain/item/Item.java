package com.switchfully.order.domain.item;

import java.util.Objects;

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

        itemId = removeVowels(tempName);
    }

    public String getNameOfItem(){
        return name;
    }

    public void changeNameOfItem(String name){
        this.name=name;
    }

    private String removeVowels(String word) {
        word = word.toUpperCase();
        return word.replaceAll("[AEIOU]", "").trim();
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
    public void changeAmountOfItem(int amount){
        this.amountInStock=amount;
    }

    public double getPrice() {
        return price;
    }
    public void changePriceOfItem(double price){
        this.price = price;
    }

    @Override
    public String toString() {
        return "[ [ " + name + " ] \n" +
                "* Description: " + description + " \n" +
                "* Price: " + price + " \n" +
                "* Amount In Stock: " + amountInStock+" ]";

    }

    @Override
    public boolean equals(Object o){
        if(this==o) return true;
        if(o==null || getClass()!=o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(name, item.name)&& Objects.equals(description, item.description);
    }


}
