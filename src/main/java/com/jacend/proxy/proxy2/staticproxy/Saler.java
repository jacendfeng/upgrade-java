package com.jacend.proxy.proxy2.staticproxy;

public class Saler implements BuyTicket {

    private BuyTicket target;

    public Saler (BuyTicket buyTicket) {
        this.target = buyTicket;
    }

    @Override
    public void buyTicket() {
        System.out.println("检查身份证");
        target.buyTicket();
    }
}
