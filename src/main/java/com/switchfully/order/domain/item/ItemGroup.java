package com.switchfully.order.domain.item;

import com.switchfully.order.repository.ItemRepository;

import java.time.LocalDate;

public class ItemGroup {
    private Item item;
    private String itemId;
    private int amount;
    private double itemGroupPrice;
    private LocalDate shippingDate;



    public ItemGroup(String itemId, int amount) {
        this.itemId = itemId;
        this.amount = amount;
        calculateShippingDate();
        calculateItemGroupPrice();
    }

    public String getItemId(){
        return itemId;
    }


    private void calculateItemGroupPrice() {
        itemGroupPrice = item.getPrice()*amount;
    }
    public double getItemGroupPrice(){
        return itemGroupPrice;
    }

    public void calculateShippingDate() {
        if (this.item.showAmountInStock() > 0) {
            this.shippingDate = LocalDate.now().plusDays(1);
        }
        else this.shippingDate = LocalDate.now().plusDays(7);
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
                "* Amount ordered: " + amount +"\n"+
                "* Price of itemGroup: " + itemGroupPrice+" ]";
    }
}
