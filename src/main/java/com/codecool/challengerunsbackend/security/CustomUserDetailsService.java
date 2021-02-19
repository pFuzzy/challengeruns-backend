package com.codecool.challengerunsbackend.security;

import com.codecool.challengerunsbackend.entity.CrUser;
import com.codecool.challengerunsbackend.repository.CrUserRepository;
import java.util.stream.Collectors;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    private final CrUserRepository crUserRepository;

    public CustomUserDetailsService(CrUserRepository crUserRepository) {
        this.crUserRepository = crUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CrUser user = crUserRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(
                        "Username: " + username + " not found"));
        return new User(user.getUsername(), user.getPassword(),
                user.getRoles().stream().map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList()));
    }
}
