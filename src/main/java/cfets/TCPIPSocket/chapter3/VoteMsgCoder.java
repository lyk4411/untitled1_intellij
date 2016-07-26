package cfets.TCPIPSocket.chapter3;

/**
 * Created by lyk on 2016/7/26.
 * Package name: cfets.TCPIPSocket.chapter3
 * Porject name: untitled1
 */
import java.io.IOException;

public interface VoteMsgCoder {
    byte[] toWire(VoteMsg msg) throws IOException;
    VoteMsg fromWire(byte[] input) throws IOException;
}
