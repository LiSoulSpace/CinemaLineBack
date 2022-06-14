package xyz.soulspace.cinemaline.service;

import xyz.soulspace.cinemaline.dto.OrderDTO;
import xyz.soulspace.cinemaline.dto.OrderIdDTO;
import xyz.soulspace.cinemaline.entity.Order;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author soulspace
 * @since 2022-06-02 10:03:04
 */
public interface OrderService extends IService<Order> {
    boolean sendOrder(Order order);

    OrderDTO getOrderDTOByOrderId(Long orderId);

    OrderIdDTO getOrderIdByInfo(Long userId, Long filmId, Long cinemaId, Long showId,
                                List<Integer> rows, List<Integer> cols);
}
