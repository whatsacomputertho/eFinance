package com.efinance.details;

import com.efinance.model.User;
import java.util.ArrayList;
import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails implements UserDetails
{
    private User user;
    
    public CustomUserDetails(User user)
    {
        this.user = user;
    }
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()
    {
        ArrayList<GrantedAuthority> authorities = new ArrayList();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getUsertype().toString()));
        return authorities;
    }

    @Override
    public String getPassword()
    {
        return user.getUserpass();
    }

    @Override
    public String getUsername()
    {
        return user.getEmail();
    }
    
    public User getUser()
    {
        return user;
    }

    @Override
    public boolean isAccountNonExpired()
    {
        return true;
    }

    @Override
    public boolean isAccountNonLocked()
    {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired()
    {
        return true;
    }

    @Override
    public boolean isEnabled()
    {
        return true;
    }
}
