package ru.shitlin.springboot.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.shitlin.springboot.model.User;
import ru.shitlin.springboot.service.abstract_srv.UserService;


@Service
public class UserDetailsServiceImp implements UserDetailsService {

    @Autowired
    UserService userService;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getUserbyName(username);

        if (user == null) {
            throw new UsernameNotFoundException("Username " + username + " not found");
        }

        return user;
    }
}
//    @Autowired
//    private UserService service;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//        User user = service.getUserbyName(username);
//        UserBuilder builder = null;
//        if (user != null) {
//
//            builder = org.springframework.security.core.userdetails.User.withUsername(username);
//            builder.disabled(!user.isEnabled());
//            builder.password(user.getPassword());
//            String[] authorities = user.getAuthorities()
//                    .stream().map(a -> a.getAuthority()).toArray(String[]::new);
//
//            builder.authorities(authorities);
//        } else {
//            throw new UsernameNotFoundException("User not found.");
//        }
//        return builder.build();
//    }
