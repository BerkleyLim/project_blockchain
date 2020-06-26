package basic;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

// 블록 헤더의 데이터 구조
public class BlockHeader {
    private int version;    // SW 혹은 protocal 등 업그레이드를 추적하기 위해 사용 정보
    private byte[] previousBlockHash;   // 블록체인 상의 이전 블록(부모 블록)의 해쉬값
    private int merkleRootHash; // 머클트리의 루트에 대한 해쉬값
    private int timestamp;      // 해당 블록의 생성 시각
    private int difficultyTarget;   // 채굴 과정에서 필요한 작업증명(Proof of Work) 알고리즘의 난이도 목표
    private int nonce;  // 채굴과정의 작업 증명에서 사용되는 카운터
    
    // 블록해더 생성자
    public BlockHeader(byte[] previousBlockHash, Object[] transactions) {
        this.previousBlockHash = previousBlockHash;
        this.merkleRootHash = this.someMethod(transactions);
    }
    
    public byte[] toByteArray() {
        String tmpStr = "";
        if(previousBlockHash != null) {
            tmpStr += new String(previousBlockHash, 0, previousBlockHash.length);
        }
        
        tmpStr += merkleRootHash;
        return tmpStr.getBytes(StandardCharsets.UTF_8);
    }
    
    private int someMethod(Object[] transations) {
        return Arrays.hashCode(transations);
    }
}
