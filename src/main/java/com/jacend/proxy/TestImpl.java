package com.jacend.proxy;

import com.jacend.proxy.speed.Test;

public class TestImpl implements Test {
    @Override
    public int test(int i) {
        return i + 1;
    }
}
