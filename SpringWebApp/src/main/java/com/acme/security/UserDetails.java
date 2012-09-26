package com.acme.security;

import com.acme.shared.dto.User;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * User: jdavis
 * Date: 9/12/12
 * Time: 2:06 PM
 */
public class UserDetails implements Serializable, org.springframework.security.core.userdetails.UserDetails {

    /**
     * logger to log error messages and warnings.
     */
    public static final org.slf4j.Logger log = LoggerFactory.getLogger(UserDetails.class);

    private String password;
    private String username;
    private User user;

    public Collection<? extends GrantedAuthority> getAuthorities() {

        log.debug("Getting authorities");

        //temporary implemention
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        GrantedAuthority newrole = new SimpleGrantedAuthority("ROLE_ADMIN");

        authorities.add(newrole);

        return authorities;
    }

    public String getPassword() {
        log.debug("Calling getPassword(), returning: " + password);
        return password;
    }

    public String getUsername() {
        log.debug("Calling getUsername(), returning: " + username);
        return username;
    }

    public boolean isAccountNonExpired() {
        return true;
    }

    public boolean isAccountNonLocked() {
        return true;
    }

    public boolean isCredentialsNonExpired() {
        return true;
    }

    public boolean isEnabled() {
        return true;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Username is:: " + username + "Password is:: " + password;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
