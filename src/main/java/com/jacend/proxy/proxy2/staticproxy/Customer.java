package com.jacend.proxy.proxy2.staticproxy;

public class Customer implements BuyTicket {

    @Override
    public void buyTicket() {
        System.out.println("customer buy a ticket");
    }
}
