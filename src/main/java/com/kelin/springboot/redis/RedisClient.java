package com.kelin.springboot.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Component;

/**
 * redis client
 *
 * Author: Mr.tan
 * Date:  2017/09/06
 */
@Component
public class RedisClient {

    @Autowired
    private RedisTemplate<String,?> redisTemplate;


    public String get(final String key) {
        return redisTemplate.execute(new RedisCallback<String>() {
            @Override
            public String doInRedis(RedisConnection redisConnection) throws DataAccessException {
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
                byte[] value =  redisConnection.get(serializer.serialize(key));
                return serializer.deserialize(value);
            }
        });
    }

    public boolean set(final String key,final String value) {
        return redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection redisConnection) throws DataAccessException {
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
                redisConnection.set(serializer.serialize(key), serializer.serialize(value));
                return true;
            }
        });
    }

    public String hGet(String key,String mapKey) {
       return (String) redisTemplate.opsForHash().get(key,mapKey);
    }

}
