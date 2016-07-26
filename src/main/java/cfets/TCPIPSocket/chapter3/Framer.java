package cfets.TCPIPSocket.chapter3;

/**
 * Created by lyk on 2016/7/26.
 * Package name: cfets.TCPIPSocket.chapter3
 * Porject name: untitled1
 */
import java.io.IOException;
import java.io.OutputStream;

public interface Framer {
    void frameMsg(byte[] message, OutputStream out) throws IOException;
    byte[] nextMsg() throws IOException;
}
