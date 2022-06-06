package xyz.soulspace.cinemaline.service;

import xyz.soulspace.cinemaline.entity.Permission;

import java.util.List;

public interface UserCacheService {

    List<Permission> getPermissionList(Long userId);

    int setPermissionList(Long userId, List<Permission> permissionList);
}
