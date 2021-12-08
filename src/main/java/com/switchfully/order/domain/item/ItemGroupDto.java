package com.switchfully.order.domain.item;

import java.time.LocalDate;

public class ItemGroupDto {

    private String itemId;
    private int amount;
    private double itemGroupPrice;
    private LocalDate shippingDate;

    public ItemGroupDto setItemid(String itemId){
        this.itemId = itemId;
        return this;
    }

    public double getItemGroupPrice() {
        return itemGroupPrice;
    }

    public ItemGroupDto setItemGroupPrice(double itemGroupPrice) {
        this.itemGroupPrice = itemGroupPrice;
        return this;
    }


    public LocalDate getShippingDate() {
        return shippingDate;
    }
    public ItemGroupDto changeShippingDate(LocalDate shippingDate){
        this.shippingDate=shippingDate;
        return this;
    }

    public int getAmount() {
        return amount;
    }
    public ItemGroupDto setAmount(int amount){
        this.amount = amount;
        return this;
    }

    public String getItemGroupId() {
        return itemId;
    }
}
