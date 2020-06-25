package basic;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Block {
    private int blockSize;  // 블록 크기 : 나머지 데이터들의 크기를 바이트 단위로 표현
    private BlockHeader blockHeader;    // 해당 블록의 메타 데이터를 담고 있는 객체
    private int transactionCount;   // 거래(transactions)의 수를 저장하는 필드
    private Object[] transactions;  // 거래 정보를 담고 있는 컬랙션(collection)
    
    public Block(BlockHeader blockHeader, Object[] transactions) {
        this.blockHeader = blockHeader;
        this.transactions = transactions;
    }
    
    public String getBlockHash() throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        
        // 해쉬 2번째 - K-pop 걸그룹이 아님
        byte[] blockHash = messageDigest.digest(blockHeader.toByteArray());
        blockHash = messageDigest.digest(blockHash);
        
        return new String(blockHash, 0, blockHash.length);
    }
}
