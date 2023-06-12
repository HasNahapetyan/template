package com.example.example.security;

import com.example.example.entity.User;
import com.example.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

//Custom-aysinqn  mer grac classn e, voch te springiny
@Service//???????? dnum enq vor haskana vor da springi service e. darnum en springi bean (ete chliner
        // mez cher toxni @Autowire anel). heto kancnenq.
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //ays loadUserByUsername(..) metodin kanchum e spring securityn(form-i mej mer grac usernamen e talis), heto
        // menq bazayic ete gtanq et anunov userin, apa talis enq springin, springn el es erkusi passwordnery kvercne
        // u matchy kstuge avtomat

        Optional<User> byEmail = userRepository.findByEmail(username);
        if(byEmail.isEmpty()){
            throw new UsernameNotFoundException("User does not exists");
        }
        return new CurrentUser(byEmail.get());
    }
}
