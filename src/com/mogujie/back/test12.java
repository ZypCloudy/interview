package com.mogujie.back;

public class test12 {
    String str=new String("good");

    char[]ch={'a','b','c'};

    public static void main(String args[]){

        test12 ex=new test12();

        ex.change(ex.str,ex.ch);

        System.out.print(ex.str+" and ");

        System.out.print(ex.ch);

    }

    public void change(String str,char ch[]){

        str="test ok";

        ch[0]='g';

    }
}
