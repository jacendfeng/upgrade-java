package com.jacend.io.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

public class NioTest {

    public static void main(String[] args) {
        int port = 9999;

        // server
        new Thread(new Runnable() {
            @Override
            public void run() {
                try (Selector selector = Selector.open();
                     ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();){

                     serverSocketChannel.bind(new InetSocketAddress(InetAddress.getByName("127.0.0.1"), port));
                     serverSocketChannel.configureBlocking(false);
                     serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

                     while (true) {
                         selector.select(); // 阻塞等待就绪的 Channel
                         Set<SelectionKey> selectionKeys = selector.selectedKeys();
                         Iterator<SelectionKey> iterator = selectionKeys.iterator();
                         while (iterator.hasNext()) {
                             SelectionKey key = iterator.next();
                             try (SocketChannel channel = ((ServerSocketChannel) key.channel()).accept()) {
                                channel.write(Charset.defaultCharset().encode("老王，你好"));
                             }
                             iterator.remove();
                         }
                     }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }
}
