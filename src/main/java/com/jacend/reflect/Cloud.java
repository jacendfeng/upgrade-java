package com.jacend.reflect;

public class Cloud {

    private int height;
    private int size;

    public Cloud(int height, int size) {
        this.height = height;
        this.size = size;
    }

    public Cloud(int height) {
        this.height = height;
    }

    public Cloud() {}

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Cloud{" +
                "height=" + height +
                ", size=" + size +
                '}';
    }

    public void sayWhatIwantToSay(String str) {
        System.out.println(str);
    }
}
