package xyz.soulspace.cinemaline.component.security;

import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import xyz.soulspace.cinemaline.entity.Permission;
import xyz.soulspace.cinemaline.entity.User;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class AppUserDetails implements UserDetails {
    private User user;

    private List<Permission> permissionList;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return permissionList.stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getId() + ":" + permission.getPermissionName()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return user.getPasswordU();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
