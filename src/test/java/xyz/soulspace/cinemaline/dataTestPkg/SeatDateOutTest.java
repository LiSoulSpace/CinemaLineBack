package xyz.soulspace.cinemaline.dataTestPkg;

import cn.hutool.core.util.RandomUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import xyz.soulspace.cinemaline.dto.SeatDTO;
import xyz.soulspace.cinemaline.entity.SeatInfo;
import xyz.soulspace.cinemaline.mapper.SeatInfoMapper;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@SpringBootTest
public class SeatDateOutTest {
    @Autowired
    SeatInfoMapper seatInfoMapper;


    @Test
    void testSeatInfo() {
        List<SeatInfo> seatInfos = seatInfoMapper.selectSeatArrangementByProcessId(1L);
        String seatArrangement = seatInfos.get(0).getSeatArrangement();
        SeatDTO parseObject = JSON.parseObject(seatArrangement, SeatDTO.class, Feature.DisableCircularReferenceDetect);
        log.warn(parseObject.toString());
    }

    //@Test
    void addSeatInfo() {
        for (int i = 2; i < 3; i++) {
            SeatInfo seatInfo = new SeatInfo();
            seatInfo.setColumnNum(RandomUtil.randomInt(5, 15));
            seatInfo.setRowNum(RandomUtil.randomInt(4, 12));
            seatInfo.setSeatArrangement(seatArraysTest(seatInfo.getRowNum(), seatInfo.getColumnNum()));
            seatInfo.setProcessId((long) i);
            log.warn(seatInfo.toString());
            int insert = seatInfoMapper.insert(seatInfo);
            if (insert == 0) {
                log.error("wrong");
                break;
            }
        }
    }

    @Test
    void seatArraysTest() {
        int row = 10, col = 5;
        List<List<Integer>> seatInfo = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < col; j++) {
                list.add(RandomUtil.randomInt(0, 4));
            }
            seatInfo.add(list);
        }
        log.warn(seatInfo.toString());
    }

    String seatArraysTest(int row, int col) {
        //row = 10, col = 5;
        List<List<Integer>> seatInfo = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < col; j++) {
                list.add(RandomUtil.randomInt(0, 4));
            }
            seatInfo.add(list);
        }
        return "{\"seatMsg\":" + seatInfo.toString() + '}';
    }

    @Test
    void oneTest() {
        String s = seatArraysTest(5, 4);
        log.warn(s);
    }


}
