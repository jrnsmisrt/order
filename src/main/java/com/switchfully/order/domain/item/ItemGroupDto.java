package com.switchfully.order.domain.item;

import java.time.LocalDate;

public class ItemGroupDto {
    private Item item;
    private int amount;
    private double itemGroupPrice;
    private LocalDate shippingDate;


    public ItemGroupDto(String itemId, int amount) {
        this.amount = amount;
        calculateShippingDate();
        calculateItemGroupPrice();
    }

    private void calculateItemGroupPrice() {
        itemGroupPrice = item.getPrice() * amount;
    }

    public double getItemGroupPrice() {
        return itemGroupPrice;
    }

    public ItemGroupDto calculateShippingDate() {
        if (this.item.ShowAmountInStock() > 0) {
            this.shippingDate = LocalDate.now().plusDays(1);
        } else {
            this.shippingDate = LocalDate.now().plusDays(7);
        }

        return this;
    }

    public LocalDate getShippingDate() {
        return shippingDate;
    }

    public int getAmount() {
        return amount;
    }
}
