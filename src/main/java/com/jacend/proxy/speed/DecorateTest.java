package com.jacend.proxy.speed;

public class DecorateTest implements Test {

    private Test target;

    public DecorateTest(Test target) {
        this.target = target;
    }

    @Override
    public int test(int i) {
        return i + 1;
    }
}
