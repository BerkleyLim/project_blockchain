package basic;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

// 출처 : http://guruble.com/java-%EC%BD%94%EB%93%9C%EB%A1%9C-%EC%9D%B4%ED%95%B4%ED%95%98%EB%8A%94-%EB%B8%94%EB%A1%9D%EC%B2%B4%EC%9D%B8blockchain/

// 버전
public class BlockchainDriver {
    List<Block> blockchain = new ArrayList<Block>();
    
    public static void main(String[] args) throws NoSuchAlgorithmException {
        
        // Genesis block
        String[] transactions = {"Hosang sent 1k Bitcoins to Zuckerberg."};
        Block genesisBlock = new Block(new BlockHeader(null, transactions), transactions);
        System.out.println("Block Hash : " + genesisBlock.getBlockHash());
        
        // Transaction Forgery 
        transactions[0] = "Hosang sent 10k Bitcoins to Zuckerberg.";
        genesisBlock = new Block(new BlockHeader(null, transactions), transactions);
        System.out.println("Block Hash : " + genesisBlock.getBlockHash());
        
      }
}
