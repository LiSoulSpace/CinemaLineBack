package xyz.soulspace.cinemaline.service.impl;

import xyz.soulspace.cinemaline.entity.Order;
import xyz.soulspace.cinemaline.mapper.OrderMapper;
import xyz.soulspace.cinemaline.service.OrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author soulspace
 * @since 2022-06-02 10:03:04
 */
@Service
public class OrderServiceImp extends ServiceImpl<OrderMapper, Order> implements OrderService {

}
