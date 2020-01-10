package com.jacend.io.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.util.Date;
import java.util.concurrent.*;

public class AIOServer {

    public static void main(String[] args) {
        int port = 9999;
        new Thread(new Runnable() {
            @Override
            public void run() {
                AsynchronousChannelGroup group = null;
                try {
                    group = AsynchronousChannelGroup.withThreadPool(Executors.newFixedThreadPool(5));
                    AsynchronousServerSocketChannel server =
                            AsynchronousServerSocketChannel.
                                    open(group)
                                    .bind(new InetSocketAddress("127.0.0.1", port));

                    server.accept(null, new CompletionHandler<AsynchronousSocketChannel, AsynchronousServerSocketChannel>() {
                        @Override
                        public void completed(AsynchronousSocketChannel result, AsynchronousServerSocketChannel attachment) {
                            server.accept(null, this); // 接收下一个请求
                            try {
                                Future<Integer> f = result.write(Charset.defaultCharset().encode("Hi, 老王"));
                                f.get();
                                System.out.println("服务端发送时间：" + DateFormat.getDateTimeInstance().format(new Date()));
                                result.close();
                            } catch (InterruptedException | ExecutionException | IOException e) {
                                e.printStackTrace();
                            }
                        }
                        @Override
                        public void failed(Throwable exc, AsynchronousServerSocketChannel attachment) {
                        }
                    });

                    group.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
