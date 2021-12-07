package com.switchfully.order.domain.item;

import com.switchfully.order.repository.ItemRepository;

import java.time.LocalDate;

public class ItemGroup {
    private String itemId;
    private int amount;
    private LocalDate shippingDate;



    public ItemGroup(String itemId, LocalDate shippingDate, int amount) {
        this.itemId = itemId;
        this.amount = amount;
        this.shippingDate=shippingDate;
    }

    public String getItemId(){
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
        return "[ [ItemGroup]" +"\n"+
                "* Item ordered: " + itemId +"\n"+
                "* Amount ordered: " + amount +" ]";
    }

    public void changeShippingDate(LocalDate shippingDate) {
        this.shippingDate=shippingDate;
    }
}
