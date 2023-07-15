package com.masai.problem2;

public class Main {

//    Static block
//    Non-Static block
{
    System.out.println(1);
}
static {
    System.out.println(2);
}
Main(){
    System.out.println(3);
}

    public static void main(String[] args) {
        System.out.println(4);

        Main m =new Main();
        System.out.println(5);
    }



}
