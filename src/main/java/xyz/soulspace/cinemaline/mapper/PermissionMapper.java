package xyz.soulspace.cinemaline.mapper;

import xyz.soulspace.cinemaline.entity.Permission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 权限表 Mapper 接口
 * </p>
 *
 * @author soulspace
 * @since 2022-06-04 10:32:57
 */
@Mapper
public interface PermissionMapper extends BaseMapper<Permission> {

}
