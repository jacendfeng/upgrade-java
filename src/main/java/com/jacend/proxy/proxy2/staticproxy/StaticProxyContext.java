package com.jacend.proxy.proxy2.staticproxy;

public class StaticProxyContext {

    public static void main(String[] args) {
        Customer customer = new Customer();
        Saler saler = new Saler(customer);
        saler.buyTicket();
    }
}
