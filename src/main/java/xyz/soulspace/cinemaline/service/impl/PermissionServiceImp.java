package xyz.soulspace.cinemaline.service.impl;

import xyz.soulspace.cinemaline.entity.Permission;
import xyz.soulspace.cinemaline.mapper.PermissionMapper;
import xyz.soulspace.cinemaline.service.PermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 权限表 服务实现类
 * </p>
 *
 * @author soulspace
 * @since 2022-06-04 10:32:57
 */
@Service
public class PermissionServiceImp extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {

}
