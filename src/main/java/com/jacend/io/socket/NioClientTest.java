package com.jacend.io.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class NioClientTest {

    public static void main(String[] args) {

        int port = 9999;
        // bio client1
        new Thread(new Runnable() {
            @Override
            public void run() {
                try (Socket cSocket = new Socket("127.0.0.1", port)) {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(cSocket.getInputStream()));
                    // rintWriter out = new PrintWriter(cSocket.getOutputStream(), true);

                    // out.println("hello serverdd");
                    bufferedReader.lines().forEach(s -> System.out.println("客户端 1 打印：" + s));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();


        // bio client1
        new Thread(new Runnable() {
            @Override
            public void run() {
                try (SocketChannel cSocket = SocketChannel.open()) {
                    cSocket.connect(new InetSocketAddress("127.0.0.1", 9999)
                    );
                    ByteBuffer buf = ByteBuffer.allocate(48);
                    int bytesRead = cSocket.read(buf);


                    // out.println("hello serverdd");
                    System.out.println("客户端 1 打印：" + buf);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
