package xyz.soulspace.cinemaline.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import xyz.soulspace.cinemaline.dto.OrderDTO;
import xyz.soulspace.cinemaline.dto.OrderSimpleDTO;
import xyz.soulspace.cinemaline.entity.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author soulspace
 * @since 2022-06-02 10:03:04
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {
    List<Order> selectAllById(@Param("id") Long id);

    OrderSimpleDTO selectOrderSimpleDTOById(@Param("id") Long id);
}
