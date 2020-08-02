package com.kangpei.miaosha.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * description: RedisService <br>
 * date: 2020/7/26 10:00 下午 <br>
 * author: kangpei <br>
 * version: 1.0 <br>
 */
@Service
public class RedisService {

    @Autowired
    private RedisConfig redisConfig;



    @Bean
    public JedisPool jedisPool() {

        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(redisConfig.getPoolMaxIdle());
        config.setMaxTotal(redisConfig.getPoolMaxTotal());
        config.setMaxWaitMillis(redisConfig.getPoolMaxWait() * 1000);

        return new JedisPool(config, redisConfig.getHost());
    }
}
