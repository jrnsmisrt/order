package com.switchfully.order.domain.item;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;


public class ItemGroup {

    private Item item;
    private int amount;
    private LocalDate shippingDate;
    private double itemGroupPrice;

    public ItemGroup(Item item, LocalDate shippingDate, int amount) {
        this.item = item;
        this.amount = amount;
        this.shippingDate = shippingDate;
        this.itemGroupPrice = setItemGroupPrice(item, amount);
    }

    private double setItemGroupPrice(Item item, int amount) {
        return item.getPrice() * amount;
    }

    public Item getItem() {
        return item;
    }

    public double getItemGroupPrice() {
        return itemGroupPrice;
    }

    public LocalDate getShippingDate() {
        return shippingDate;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return item.getItemid() + "| Amount ordered: " + amount + "| Price: " + itemGroupPrice + " \n ";
    }

    public void changeShippingDate(LocalDate shippingDate) {
        this.shippingDate = shippingDate;
    }
}
