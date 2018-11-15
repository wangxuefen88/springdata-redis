package com.example.redisjudy.config;


import com.example.redisjudy.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
* @Description:    java类作用描述
* @Author:         王雪芬
* @CreateDate:     2018/11/14 14:16
* @UpdateUser:     王雪芬
* @UpdateDate:     2018/11/14 14:16
* @UpdateRemark:   修改内容
* @Version:        1.0
*/

@Configuration
public class AppConfig {
    private static  @Value("${redis.address}") String redisHost;
    private static  @Value("${redis.port}") int reidsPort;

    @Bean
    JedisConnectionFactory jedisConnectionFactory(){
        JedisConnectionFactory factory= new JedisConnectionFactory();
        factory.setHostName(redisHost);
        factory.setPort(reidsPort);
        factory.setUsePool(true);
        return factory;
    }

    @Bean
    RedisTemplate<String,User> redisTemplate(){
        RedisTemplate<String,User> template=new RedisTemplate<>();
        template.setKeySerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(new StringRedisSerializer());
        template.setConnectionFactory(jedisConnectionFactory());
        return template;
    }
}
