package xyz.soulspace.cinemaline.dataTestPkg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import xyz.soulspace.cinemaline.redis.RedisServiceImp;

@SpringBootTest
public class RedisDataTest {
    @Autowired
    RedisServiceImp redisServiceImp;


}
