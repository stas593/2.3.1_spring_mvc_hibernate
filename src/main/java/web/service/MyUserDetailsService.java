package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import web.models.User;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDetailService us;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User myUser = us.findUserByLogin(s);
        if (s == null) {
            throw new UsernameNotFoundException("Unknown user: "+s);
        }
        return myUser;
    }
}
