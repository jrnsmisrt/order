package com.switchfully.order.domain.item;

import java.time.LocalDate;

public class ItemGroupDto {
    private Item item;
    private int amount;
    private LocalDate shippingDate;
    private double itemGroupPrice;

    public ItemGroupDto setItem(Item item) {
        this.item = item;
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

    public ItemGroupDto changeShippingDate(LocalDate shippingDate) {
        this.shippingDate = shippingDate;
        return this;
    }

    public int getAmount() {
        return amount;
    }

    public ItemGroupDto setAmount(int amount) {
        this.amount = amount;
        return this;
    }

    public Item getItem() {
        return item;
    }
}
