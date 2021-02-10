package com.lsm.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

public class TestTx {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.102.111",6381);
        Transaction multi = jedis.multi();
        multi.set("k4","v44");
        multi.set("k5","v55");
        multi.discard();
    }
}
