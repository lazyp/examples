package org.example.jsonrpc4j;

public class IServiceImpl implements IService {

    @Override
    public String sayHello() {
        return new String("hello client !!!");
    }

    @Override
    public String echo(String s) {
        return s;
    }

}
