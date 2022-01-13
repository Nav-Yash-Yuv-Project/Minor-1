package com.company;
import com.google.gson.*;




public class Main  {

    public static void main(String[] args) {

         BlockChain chain1 = new BlockChain();


        var User1 = new User(1 ,chain1);
        var User2 = new User(2,chain1);

         User1.start();
         User2.start();
         User1.interrupt();

    }

}
