/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.jedis;

import java.util.logging.Level;
import java.util.logging.Logger;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

/**
 *
 * @author hxl
 */
public class JedisPubSubDemo1 {

    private static final Logger logger = Logger.getLogger(JedisPubSubDemo1.class.getName());
    private static final String CHANNEL_KEY = "test_channel";

    public static void subsribe() {
        new Thread() {
            @Override
            public void run() {
                Jedis jedis = new Jedis("127.0.0.1", 6379);
                JedisPubSub jps = new JedisPubSub() {
                    @Override
                    public void onMessage(String channel, String message) {
                        logger.info(String.format("channel:%s , message: %s", channel, message));
                    }

                };
                jedis.subscribe(jps, CHANNEL_KEY);
            }

        }.start();
    }

    public static void publish() {
        new Thread() {
            @Override
            public void run() {
                Jedis jedis = new Jedis("127.0.0.1", 6379);
                while (true) {
                    try {
                        jedis.publish(CHANNEL_KEY, "hello" + (int) (Math.random() * 10));
                        Thread.sleep(1000L);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(JedisPubSubDemo1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

        }.start();
    }

    public static void main(String[] args) {
        subsribe();
        publish();
    }

}
