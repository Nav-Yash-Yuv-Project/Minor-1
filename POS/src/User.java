import java.io.*;
import java.util.Random;

import com.google.gson.GsonBuilder;

public class User extends Thread{
    Random rand = new Random();
    int id;
        BlockChain chain;
        int stakeUser;
        public User(int id , BlockChain chain ){
            this.chain = chain;
            this.id = id;
            this.stakeUser =  rand.nextInt(100);

        }

        public void run(){

            var b = new Block( chain.getLength()+1 , "second block" , chain.getLatestBlock().hash);

            b.previousHash = this.chain.blockchain.get(chain.blockchain.size() - 1).hash;

            b.mineBlock(4);

            long start1 = System.nanoTime();

            try {


                FileOutputStream f1 = new FileOutputStream(new File("D:FileOperationExample.dat"));
                System.out.println("---------------------------------------------- ");
                System.out.println("Transactions being written to the file.......| ");
                System.out.println("---------------------------------------------- ");

                for (float i =0 ; i < 1000000 ; i++) {

                    f1.write(" This is the user_1 -> Rs20 -> user_2".getBytes());
                    f1.write(" This is the user_2 -> Rs23 -> user_3".getBytes());
                    f1.write(" This is the user_4 -> Rs1000 -> user_1".getBytes());
                }

                // close the reader
                f1.close();

            } catch (IOException ex) {
                ex.printStackTrace();

            }



            this.chain.blockchain.add(b);



            String blockchainJson1 = new GsonBuilder().setPrettyPrinting().create().toJson(chain.blockchain);

            System.out.println(blockchainJson1);
            System.out.println("Block mined by user:"+id);


            long end1 = System.nanoTime();

            System.out.println("---------------------------------------------");
            System.out.println("Elapsed Time in nano seconds: "+ (end1-start1));
            System.out.println("---------------------------------------------");


        }

}