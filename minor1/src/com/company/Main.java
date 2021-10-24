package com.company;
import com.google.gson.*;

public class Main {

    public static void main(String[] args) {
         var chain1 = new BlockChain();  // user1
         var chain2 = new BlockChain();  // user 2


        System.out.println("mining block 1 ....");
         chain1.addBlock(new Block(1, "second block" , chain1.getLatestBlock().hash));

        System.out.println("mining block 1 ....");
        chain2.addBlock(new Block(1, "second block" , chain1.getLatestBlock().hash));

        System.out.println("mining block 2 ....");
        chain1.addBlock(new Block(2, "third block" , chain1.getLatestBlock().hash));

        System.out.println("mining block 2 ....");
        chain2.addBlock(new Block(2, "third block" , chain1.getLatestBlock().hash));


//        System.out.println(chain1.isChainValid());

        String blockchainJson1 = new GsonBuilder().setPrettyPrinting().create().toJson(chain1.blockchain);
        String blockchainJson2 = new GsonBuilder().setPrettyPrinting().create().toJson(chain1.blockchain);


        System.out.println(blockchainJson1);
        System.out.println(blockchainJson2);

    }
}
