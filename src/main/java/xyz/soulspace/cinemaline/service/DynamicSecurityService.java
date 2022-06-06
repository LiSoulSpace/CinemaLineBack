package xyz.soulspace.cinemaline.service;

import org.springframework.security.access.ConfigAttribute;

import java.util.Map;

/**
 * 动态权限
 */
public interface DynamicSecurityService {
    Map<String, ConfigAttribute> loadDataSource();
}
