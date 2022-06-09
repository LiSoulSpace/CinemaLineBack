package xyz.soulspace.cinemaline.dataTestPkg;

import cn.hutool.core.util.RandomUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import xyz.soulspace.cinemaline.dto.SeatDTO;

import java.util.*;
import java.util.random.RandomGenerator;

@Slf4j
public class FastJsonTest {
    @Test
    void arraysJsonTest() {
        int[][] a = new int[][]{{1, 2, 3}, {4, 5, 6}};
        String s = Arrays.deepToString(a);
        JSONObject jsonObject = JSON.parseObject('{' + s + '}');
        Object o = jsonObject.get("");
        SeatDTO seatDTO = jsonObject.toJavaObject(SeatDTO.class);
        log.warn(seatDTO.toString());
    }

    @Test
    void jsonTest2() {
        String seatArrangement = "{\"seatMsg\":[[3,3,2,1,0,0,0,0,0,2,1,0]," +
                "[2,1,2,1,1,2,3,0,3,0,2,3],[1,0,0,1,2,1,2,1,0,0,2,0]" +
                ",[2,1,0,0,2,0,2,0,1,1,3,0],[0,3,3,0,3,1,0,3,3,3,3,1]]}";
        SeatDTO seatDTO = JSON.parseObject(seatArrangement,
                SeatDTO.class, Feature.DisableCircularReferenceDetect);
        log.warn(seatDTO.toString());
        String s = JSON.toJSONString(seatDTO.getSeatMsg(), SerializerFeature.DisableCircularReferenceDetect);
        log.warn(s);
        log.warn(seatDTO.seatsToString());

    }

    @Test
    void stringTest() {
        String s = "  123)".trim();

        int integer = Integer.parseInt(s.trim().substring(0, s.length() - 1));
        log.warn(Integer.toString(integer));
    }

}
