package xyz.soulspace.cinemaline.service.impl;

import xyz.soulspace.cinemaline.entity.Role;
import xyz.soulspace.cinemaline.mapper.RoleMapper;
import xyz.soulspace.cinemaline.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author soulspace
 * @since 2022-06-04 10:32:57
 */
@Service
public class RoleServiceImp extends ServiceImpl<RoleMapper, Role> implements RoleService {

}
