package com.company;

public class HelloWorld {


    public static void main(String []args){
        long minerId = 31;
        int block = 2;
        long verifier = minerId+block;  //33
        long random_int=0;
        while (random_int < verifier   ){
            random_int = (int)Math.floor(Math.random()*verifier);
            //  System.out.println("randoms : "+random_int);
        }
        System.out.println("random : "+random_int);
    }
}
