package com.company;


import com.google.gson.GsonBuilder;

public class User extends Thread{
        long id;
        BlockChain chain;

        public User(int id , BlockChain chain ){
            this.chain = chain;
            this.id = id;

        }

        public void run(){

            var b = new Block( chain.getLength()+1 , "second block" , chain.getLatestBlock().hash);
            b.previousHash = this.chain.blockchain.get(chain.blockchain.size() - 1).hash;
            b.mineBlock(4);
            if(Thread.currentThread().isInterrupted()) {

                return;
            }

            this.chain.blockchain.add(b);


            String blockchainJson1 = new GsonBuilder().setPrettyPrinting().create().toJson(chain.blockchain);

            System.out.println(blockchainJson1);
            System.out.println("Block mined by user"+id);

        }

}