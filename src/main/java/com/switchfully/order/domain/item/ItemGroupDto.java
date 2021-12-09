package com.switchfully.order.domain.item;

import java.time.LocalDate;

public class ItemGroupDto {

    private String itemId;
    private int amount;
    private LocalDate shippingDate;
    private double itemGroupPrice;

    public LocalDate getShippingDate() {
        return shippingDate;
    }

    public String getItemId() {
        return itemId;
    }

    public double getItemGroupPrice() {
        return itemGroupPrice;
    }

    public int getAmount() {
        return amount;
    }

    public ItemGroupDto setItemId(String itemId) {
        this.itemId = itemId;
        return this;
    }

    public ItemGroupDto setItemGroupPrice(double itemGroupPrice) {
        this.itemGroupPrice = itemGroupPrice;
        return this;
    }


    public ItemGroupDto changeShippingDate(LocalDate shippingDate) {
        this.shippingDate = shippingDate;
        return this;
    }


    public ItemGroupDto setAmount(int amount) {
        this.amount = amount;
        return this;
    }

    @Override
    public String toString() {
        return "* Item ordered: " + itemId + "| Amount ordered: " + amount + "| Price: " + itemGroupPrice + " ]";
    }


}
