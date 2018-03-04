package com.mogujie.back;

public class test13 {
    public static test13 t1 = new test13();

    {

        System.out.println("blockA");

    }

    static

    {

        System.out.println("blockB");

    }

    public static void main(String[] args) {

        test13 t2 = new test13();

    }

}
