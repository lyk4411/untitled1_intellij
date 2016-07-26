package cfets.TCPIPSocket.chapter2;

/**
 * Created by lyk on 2016/7/15.
 * Package name: cfets.TCPIPSocket.chapter2
 * Porject name: untitled1
 */

import java.net.*;  // for Socket, ServerSocket, and InetAddress
import java.io.*;   // for IOException and Input/OutputStream

public class TCPEchoServer {

    private static final int BUFSIZE = 32;   // Size of receive buffer

    public static void main(String[] args) throws IOException {

        if (args.length != 1)  // Test for correct # of args
            throw new IllegalArgumentException("Parameter(s): <Port>");

        int servPort = Integer.parseInt(args[0]);

        // Create a server socket to accept client connection requests
        ServerSocket servSock = new ServerSocket(servPort);

        int recvMsgSize;   // Size of received message
        byte[] receiveBuf = new byte[BUFSIZE];  // Receive buffer

        while (true) { // Run forever, accepting and servicing connections
            Socket clntSock = servSock.accept();     // Get client connection

            SocketAddress clientAddress = clntSock.getRemoteSocketAddress();
            System.out.println("Handling client at " + clientAddress);

            System.out.println("get Inet Address" + clntSock.getInetAddress());
            System.out.println("get Local Address:" + clntSock.getLocalAddress());
            System.out.println("get Local Port:" + clntSock.getLocalPort());


            InputStream in = clntSock.getInputStream();
            OutputStream out = clntSock.getOutputStream();

            // Receive until client closes connection, indicated by -1 return
            while ((recvMsgSize = in.read(receiveBuf)) != -1) {
                //out.write(123456);
                out.write(receiveBuf, 0, recvMsgSize);
                out.write(123456);
                //break;
            }

            clntSock.close();  // Close the socket.  We are done with this client!
        }
    /* NOT REACHED */
    }
}
