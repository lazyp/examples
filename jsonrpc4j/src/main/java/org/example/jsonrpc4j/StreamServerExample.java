package org.example.jsonrpc4j;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import com.googlecode.jsonrpc4j.JsonRpcBasicServer;
import com.googlecode.jsonrpc4j.StreamServer;

/**
 * jsonrpc4j stream server 例子
 * 
 * @see https://github.com/briandilley/jsonrpc4j
 * @author lazy_p
 *
 */
public class StreamServerExample {

    public static void main(String[] args) throws UnknownHostException, IOException {
        JsonRpcBasicServer jsonRpcServer = new JsonRpcBasicServer(new IServiceImpl());// json
        // rpc
        // server端协议处理类
        StreamServer socketStreamServer = new StreamServer(jsonRpcServer, 2, 10340, 10,
                InetAddress.getByName("127.0.0.1"));
        socketStreamServer.start();
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
