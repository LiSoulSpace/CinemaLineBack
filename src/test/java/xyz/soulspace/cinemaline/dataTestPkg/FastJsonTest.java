package xyz.soulspace.cinemaline.dataTestPkg;

import cn.hutool.core.util.RandomUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
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


}
