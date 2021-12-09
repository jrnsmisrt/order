package com.switchfully.order.domain.item;

import com.switchfully.order.repository.ItemRepository;

import java.time.LocalDate;

public class ItemGroup {
    private String itemId;
    private int amount;
    private LocalDate shippingDate;
    private double itemGroupPrice;

    public ItemGroup(String itemId, LocalDate shippingDate, int amount) {
        this.itemId = itemId;
        this.amount = amount;
        this.shippingDate = shippingDate;
        this.itemGroupPrice = 0;
    }

    public void setItemGroupPrice(double itemGroupPrice) {
        this.itemGroupPrice = itemGroupPrice;
    }

    public double getItemGroupPrice() {
        return itemGroupPrice;
    }

    public String getItemId() {
        return itemId;
    }

    public LocalDate getShippingDate() {
        return shippingDate;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "* Item ordered: " + itemId + "| Amount ordered: " + amount + "| Price: " + itemGroupPrice + " ]";
    }

//    public void changeShippingDate(LocalDate shippingDate) {
//        this.shippingDate = shippingDate;
//    }
}
