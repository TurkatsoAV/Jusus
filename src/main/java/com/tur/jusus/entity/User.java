package com.tur.jusus.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "USERS")
@Getter
@Setter
public class User extends Base implements UserDetails {

    @Column(name = "USER_NAME", nullable = false, unique = true)
    private String username;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "ACCOUNT_EXPIRED", nullable = false)
    private boolean accountExpired;
    @Column(name = "ACCOUNT_LOCKED", nullable = false)
    private boolean accountLocked;
    @Column(name = "CREDENTIALS_EXPIRED", nullable = false)
    private boolean credentialsExpired;
    @Column(name = "ENABLED", nullable = false)
    private boolean isEnabled;
    @ManyToMany
    @JoinTable(name = "USER_ROLES", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toSet());
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return !this.accountExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !this.accountLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return !this.credentialsExpired;
    }

    @Override
    public boolean isEnabled() {
        return this.isEnabled;
    }
}
