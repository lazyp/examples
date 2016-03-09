package org.example.jsonrpc4j;

import java.net.Socket;
import javax.net.SocketFactory;

import com.googlecode.jsonrpc4j.JsonRpcClient;
import com.googlecode.jsonrpc4j.ProxyUtil;

public class JsonRpcClientExample {

    public static void main(String[] args) throws Throwable {
        Socket socket = SocketFactory.getDefault().createSocket("127.0.0.1", 10340);

        JsonRpcClient jsonRpcClient = new JsonRpcClient();// json rpc client
                                                          // 协议处理类

        IService iService = ProxyUtil.createClientProxy(JsonRpcClientExample.class.getClassLoader(), IService.class,
                jsonRpcClient, socket);

        System.out.println(iService.echo("hello"));

        socket.close();
    }

}
