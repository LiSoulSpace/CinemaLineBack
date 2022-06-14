package xyz.soulspace.cinemaline.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import xyz.soulspace.cinemaline.dto.OrderDTO;
import xyz.soulspace.cinemaline.dto.OrderIdDTO;
import xyz.soulspace.cinemaline.dto.OrderSimpleDTO;
import xyz.soulspace.cinemaline.entity.Order;
import xyz.soulspace.cinemaline.mapper.OrderMapper;
import xyz.soulspace.cinemaline.service.OrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author soulspace
 * @since 2022-06-02 10:03:04
 */
@Slf4j
@Service
public class OrderServiceImp extends ServiceImpl<OrderMapper, Order> implements OrderService {

    @Autowired
    OrderMapper orderMapper;

    @Override
    public boolean sendOrder(Order order) {
        return false;
    }

    @Override
    public OrderDTO getOrderDTOByOrderId(Long orderId) {
        try {
            OrderSimpleDTO orderSimpleDTO = orderMapper.selectOrderSimpleDTOById(orderId);
            if (orderSimpleDTO == null) return null;
            log.warn(String.valueOf(orderSimpleDTO));
            String seatInfo = orderSimpleDTO.getSeatInfo();
            List<List<Integer>> seatInfo1 = getSeatInfo(seatInfo);
            OrderDTO order = new OrderDTO();
            order.setFromSimple(orderSimpleDTO);
            order.setRow(seatInfo1.get(0));
            order.setCol(seatInfo1.get(1));
            return order;
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return null;
    }

    @Override
    public OrderIdDTO getOrderIdByInfo(Long userId, Long filmId, Long cinemaId, Long showId,
                                       List<Integer> rows, List<Integer> cols) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cols.size(); i++) {
            if (i != 0) sb.append(' ');
            sb.append('(').append(rows.get(i)).append(',').append(cols.get(i)).append(')');
        }
        String seatInfo = sb.toString();
        log.warn("{}-{}-{}", userId, showId, seatInfo);
        List<Order> id = orderMapper.getIdByUserIdAndProcessIdAndSeatInfo(userId, showId, seatInfo);
        OrderIdDTO orderIdDTO = new OrderIdDTO();
        orderIdDTO.setOrderId(id.get(0).getId());
        return orderIdDTO;
    }

    public List<List<Integer>> getSeatInfo(String seatInfo) {
        String[] strings = seatInfo.split(" ");
        List<List<Integer>> seats = new ArrayList<>();
        seats.add(new ArrayList<>());
        seats.add(new ArrayList<>());
        for (String s : strings) {
            if (s.length() > 3) {
                String[] split = s.split(",");
                String rowT = split[0].trim();
                String colT = split[1].trim();
                seats.get(0).add(Integer.valueOf(rowT.substring(1)));
                seats.get(1).add(Integer.valueOf(colT.substring(0, rowT.length() - 1)));
            }
        }
        return seats;
    }

}
