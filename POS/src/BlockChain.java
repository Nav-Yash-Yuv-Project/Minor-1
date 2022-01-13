import java.util.*;
import java.util.Random;

public class BlockChain {
    Random rand = new Random();
    public ArrayList<Block> blockchain = new ArrayList<Block>();
    int difficulty;
    int stakeBlockChain;
    public BlockChain() {
        blockchain.add(createGenesisBlock());
        this.difficulty = 4;
        this.stakeBlockChain =  rand.nextInt(100);
    }

    public Block createGenesisBlock() {
        return new Block(1, "genesis block", "0");
    }

    public Block getLatestBlock() {
        return this.blockchain.get(blockchain.size() - 1);
    }



    public int getLength() {

        return this.blockchain.size() ;
    }

    public void addBlock(Block newBlock) {
        newBlock.previousHash = getLatestBlock().hash;

        newBlock.mineBlock(this.difficulty);

        this.blockchain.add(newBlock);

    }

    public Boolean isChainValid() {
        Block currentBlock;
        Block previousBlock;

        //loop through blockchain to check hashes:
        for (int i = 1; i < blockchain.size(); i++){
            currentBlock = blockchain.get(i);
            previousBlock = blockchain.get(i - 1);

            //compare registered hash and calculated hash:
            if (!currentBlock.hash.equals(currentBlock.calculateHash())) {
                System.out.println("Current Hashes not equal");
                return false;
            }

            //compare previous hash and registered previous hash
            if (!previousBlock.hash.equals(currentBlock.previousHash)) {
                System.out.println("Previous Hashes not equal");
                return false;
            }
        }
        return true;
    }

}
