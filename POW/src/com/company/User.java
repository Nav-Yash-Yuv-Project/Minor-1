package com.company;
import java.util.Random;


import com.google.gson.GsonBuilder;

public class User extends Thread{
    Random rand = new Random();
        long id;
        BlockChain chain;

        public User(int id , BlockChain chain ){
            this.chain = chain;
            this.id = id;
            int stake= rand.nextInt(100);
        }

        public void run(){

            var b = new Block( chain.getLength()+1 , "second block" , chain.getLatestBlock().hash);
            b.previousHash = this.chain.blockchain.get(chain.blockchain.size() - 1).hash;
            b.mineBlock(4);
            if(Thread.currentThread().isInterrupted()) {

                return;
            }

            long start1 = System.nanoTime();

            this.chain.blockchain.add(b);


            String blockchainJson1 = new GsonBuilder().setPrettyPrinting().create().toJson(chain.blockchain);

            System.out.println(blockchainJson1);
            System.out.println("Block mined by user"+id);


            long end1 = System.nanoTime();

            System.out.println("---------------------------------------------");
            System.out.println("Elapsed Time in nano seconds: "+ (end1-start1));
            System.out.println("---------------------------------------------");

        }

}