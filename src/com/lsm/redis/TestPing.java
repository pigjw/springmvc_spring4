package com.lsm.redis;

import redis.clients.jedis.Jedis;

public class TestPing {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.102.111",6381);
        System.out.println(jedis.ping());
    }
}
