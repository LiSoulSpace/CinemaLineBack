package xyz.soulspace.cinemaline.dataTestPkg;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.RedisScript;
import xyz.soulspace.cinemaline.dto.SeatDTO;
import xyz.soulspace.cinemaline.redis.RedisService;
import xyz.soulspace.cinemaline.redis.RedisServiceImp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@SpringBootTest
@Slf4j
public class RedisDataTest {
    @Autowired
    RedisService redisService;
    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Test
    public void addSeatsToRedisHash() {
        String seatArrangement = "{\"seatMsg\":[[3, 0, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0], " +
                "[2, 1, 2, 1, 1, 2, 3, 0, 3, 0, 2, 3], " +
                "[1, 0, 0, 1, 2, 1, 2, 1, 0, 0, 2, 0], " +
                "[2, 1, 0, 0, 2, 0, 2, 0, 1, 1, 3, 0], " +
                "[0, 3, 3, 0, 3, 1, 0, 3, 3, 3, 3, 1]]}";
        SeatDTO seatDTO = JSON.parseObject(seatArrangement,
                SeatDTO.class, Feature.DisableCircularReferenceDetect);
        log.warn(seatDTO.toString());
        log.warn(seatDTO.seatsToString());
        List<List<Integer>> seatMsg = seatDTO.getSeatMsg();
        long processId = 4L;
        int m = seatMsg.size();
        int n = seatMsg.get(0).size();
        String s = "set:" + processId;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (seatMsg.get(i).get(j) == 0) {
                    String seatInfo = String.format("(%d,%d)", i, j);
                    log.debug(seatInfo);
                    redisService.sAdd(s, seatInfo);
                }
            }
        }
        Set<Object> objects = redisService.sMembers(s);
        objects.forEach(o ->{
            log.info(o.toString());
        });
    }

    @Test
    void getRedisData(){
        List<String> sList = new ArrayList<>();
        sList.add(String.valueOf(1));
        sList.add(String.valueOf(2));
        sList.add("(1,3) (4,1)");
        Set<Object> objects1 = redisService.sMembers("set:seatArrangement:1");
        log.warn(objects1.toString());
//        Object execute = redisTemplate.execute(
//                RedisScript.of(new ClassPathResource("META-INF/scripts/getTicket.lua"), Object.class),
//                sList);
        Object execute = redisService.execute("getTicket.lua", sList);
        log.warn("answer of execute:{}", execute);
        Set<Object> objects2 = redisService.sMembers("set:seatArrangement:1");
        log.warn(objects2.toString());
    }

}
