package com.company;

import java.util.Date;
public class Block {
    int index;
    long timestamp;
    private String data;
    String previousHash;
    String hash;
    private int nonce;


    public Block(int index  , String data , String previousHash ){
        this.index = index;
        this.timestamp = new Date().getTime();
        this.data = data;
        this.previousHash = previousHash;
        this.hash = this.calculateHash();
    }

    public  String calculateHash() {
        String hash = StringUtil.applySha256(
                previousHash +
                        timestamp +
                        nonce +
                        data);
        return hash;
    }

    public void mineBlock(int difficulty) {
        String target = new String(new char[difficulty]).replace('\0', '0'); //Create a string with difficulty * "0"
        while(!hash.substring( 0, difficulty).equals(target)) {
            this.nonce ++;
            this.hash = this.calculateHash();
        }
        System.out.println("Block Mined!!! : " + hash);
    }
}
